package com.clarkelamothe.recetapp.recipe.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentRecipeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeFragment : BaseFragment<FragmentRecipeBinding>(
    FragmentRecipeBinding::inflate
) {
    private val viewModel: RecipeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect {
                when (it) {
                    RecipeUiState.Loading -> {}
                    is RecipeUiState.Error -> {}
                    is RecipeUiState.Success -> {}
                }
            }
        }
    }
}