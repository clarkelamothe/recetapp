package com.clarkelamothe.recetapp.location.presentation

import android.os.Bundle
import android.view.View
import com.clarkelamothe.recetapp.R
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class LocationFragment : BaseFragment<FragmentLocationBinding>(
    FragmentLocationBinding::inflate
), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createFragment()
    }

    private fun createFragment() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        addMarker(LatLng(-34.0, 151.0))
    }

    private fun addMarker(coordinates: LatLng) {
        val markerOptions = MarkerOptions().position(coordinates).title("Marker in Sydney")
        map.addMarker(markerOptions)
        animateCameraTo(coordinates)
    }

    private fun animateCameraTo(coordinates: LatLng) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 12f),
            4000,
            null
        )
    }
}