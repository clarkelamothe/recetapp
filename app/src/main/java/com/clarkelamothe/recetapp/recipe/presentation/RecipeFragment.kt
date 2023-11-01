package com.clarkelamothe.recetapp.recipe.presentation

import android.os.Bundle
import android.view.View
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.core.ui.MarginItemDecorator
import com.clarkelamothe.recetapp.databinding.FragmentRecipeBinding
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiEvent
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiModel
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeFragment : BaseFragment<FragmentRecipeBinding>(
    FragmentRecipeBinding::inflate
) {
    private val viewModel: RecipeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.searchListeners()
        binding?.rvRecipes?.addItemDecoration(MarginItemDecorator())
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
                    is RecipeUiEvent.OnItemClicked -> {
                        navigateTo(
                            RecipeFragmentDirections.actionRecipeFragmentToDetailFragment(it.recipe)
                        )
                    }

                    is RecipeUiEvent.OnSearchQuery -> setAdapter(it.searchResult)
                }
            }
        }
    }

    private fun setAdapter(items: List<RecipeUiModel>) {
        binding?.let {
            it.rvRecipes.adapter = RecipeAdapter(items) {
                viewModel.onRecipeClicked(it)
            }
        }
    }

    private fun FragmentRecipeBinding.bindState(state: RecipeUiState) {
        with(this) {
            svSearchRecipe.isEnabled =
                !(state is RecipeUiState.Loading || state is RecipeUiState.Error)
            incLoading.pbLoading.isVisible = state is RecipeUiState.Loading
            incError.tvErrorMsg.isVisible = state is RecipeUiState.Error
            incError.ibError.isVisible = state is RecipeUiState.Error

            incError.tvErrorMsgCustom.text = if (state is RecipeUiState.Error) state.msg else ""

            if (state is RecipeUiState.Success) {
                setAdapter(state.items)
            }
        }
    }

    private fun FragmentRecipeBinding.searchListeners() {
        with(this) {
            svSearchRecipe.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener, OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?) = true

                    override fun onQueryTextChange(newText: String?): Boolean {
                        viewModel.search(newText)
                        return true
                    }
                })
        }
    }
}