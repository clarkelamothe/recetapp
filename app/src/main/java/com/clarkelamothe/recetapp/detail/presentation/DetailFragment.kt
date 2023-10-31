package com.clarkelamothe.recetapp.detail.presentation

import android.os.Bundle
import android.view.View
import com.clarkelamothe.recetapp.R
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.detail?.setOnClickListener {
            navigateTo(R.id.action_detailFragment_to_locationFragment)
        }
    }
}