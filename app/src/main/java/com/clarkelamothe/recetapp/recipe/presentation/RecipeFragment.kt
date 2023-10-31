package com.clarkelamothe.recetapp.recipe.presentation

import android.os.Bundle
import android.view.View
import com.clarkelamothe.recetapp.R
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentRecipeBinding

class RecipeFragment : BaseFragment<FragmentRecipeBinding>(
    FragmentRecipeBinding::inflate
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.recipe?.setOnClickListener {
            navigateTo(R.id.action_recipeFragment_to_detailFragment)
        }
    }
}