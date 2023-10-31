package com.clarkelamothe.recetapp.detail.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context, "${args.recipeDetail}", Toast.LENGTH_SHORT).show()

    }
}