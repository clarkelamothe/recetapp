package com.clarkelamothe.recetapp.location.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.clarkelamothe.recetapp.R
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.launch

const val ZOOM = 6f
const val DURATION_MS = 3000

class LocationFragment : BaseFragment<FragmentLocationBinding>(
    FragmentLocationBinding::inflate
), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private val args: LocationFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createFragment()
    }

    private fun createFragment() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                val mapFragment =
                    childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
                mapFragment?.getMapAsync(this@LocationFragment)
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        getLocation()?.let { addMarker(it) }
    }

    private fun addMarker(coordinates: LatLng) {
        val markerOptions = MarkerOptions().position(coordinates)
        map.addMarker(markerOptions)
        animateCameraTo(coordinates)
    }

    private fun animateCameraTo(coordinates: LatLng) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, ZOOM),
            DURATION_MS,
            null
        )
    }

    private fun getLocation() = args.location?.latitude?.let { latitude ->
        args.location?.longitude?.let { longitude ->
            LatLng(
                latitude,
                longitude
            )
        }
    }
}