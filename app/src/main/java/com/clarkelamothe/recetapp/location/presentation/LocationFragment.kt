package com.clarkelamothe.recetapp.location.presentation

import android.os.Bundle
import android.view.View
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentLocationBinding

class LocationFragment : BaseFragment<FragmentLocationBinding>(
    FragmentLocationBinding::inflate
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.location?.setOnClickListener {

        }
    }
}