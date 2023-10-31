package com.clarkelamothe.recetapp.recipe.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.clarkelamothe.recetapp.R
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.core.ui.MarginItemDecorator
import com.clarkelamothe.recetapp.databinding.FragmentRecipeBinding
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
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
        collectState()
        collectEvent()
    }

    private fun collectState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect {
                binding?.bindState(it)
            }
        }
    }

    private fun collectEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.eventFlow.collect {
                when (it) {
                    is RecipeUiEvent.OnItemClicked -> navigateTo(R.id.action_recipeFragment_to_detailFragment)
                }
            }
        }
    }

    private fun setAdapter(items: List<Recipe>) {
        binding?.let {
            it.rvRecipes.adapter = RecipeAdapter(items) {
                viewModel.onRecipeClicked(it)
            }
            it.rvRecipes.addItemDecoration(MarginItemDecorator())
        }
    }

    private fun FragmentRecipeBinding.bindState(state: RecipeUiState) {
        with(this) {
            incLoading.pbLoading.isVisible = state is RecipeUiState.Loading
            incError.tvErrorMsg.isVisible = state is RecipeUiState.Error
            incError.ibError.isVisible = state is RecipeUiState.Error

            if (state is RecipeUiState.Success) {
                setAdapter(state.items)
            }
        }
    }
}