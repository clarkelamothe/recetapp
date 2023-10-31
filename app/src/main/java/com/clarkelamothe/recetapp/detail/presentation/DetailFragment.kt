package com.clarkelamothe.recetapp.detail.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.bindRecipe()

        binding?.fabLocation?.setOnClickListener {
            navigateTo(DetailFragmentDirections.actionDetailFragmentToLocationFragment(args.recipeDetail?.location))
        }
    }

    private fun FragmentDetailBinding.bindRecipe() {
        with(this) {
            args.recipeDetail?.let {
                Glide.with(ivRecipeDetail)
                    .load(it.imageUrl)
                    .into(ivRecipeDetail)

                tvRecipeName.text = it.name
                tvRecipeDescription.text = it.description
            }
        }
    }
}