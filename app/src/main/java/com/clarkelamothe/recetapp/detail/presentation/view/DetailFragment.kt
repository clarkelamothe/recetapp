package com.clarkelamothe.recetapp.detail.presentation.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.clarkelamothe.recetapp.core.ui.BaseFragment
import com.clarkelamothe.recetapp.databinding.FragmentDetailBinding
import com.clarkelamothe.recetapp.detail.presentation.adapter.IngredientAdapter
import com.clarkelamothe.recetapp.detail.presentation.model.DetailUiEvent
import com.clarkelamothe.recetapp.detail.presentation.viewmodel.DetailViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.bindRecipe()

        setListeners()

        collectEvent()
    }

    private fun setListeners() {
        binding?.fabLocation?.setOnClickListener {
            viewModel.fabClicked()
        }
    }

    private fun collectEvent() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.eventFlow.collect {
                when (it) {
                    DetailUiEvent.OnFabClicked -> navigateTo(
                        DetailFragmentDirections.actionDetailFragmentToLocationFragment(
                            args.recipeDetail?.location
                        )
                    )

                }
            }
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

                setAdapter(it.items)
            }
        }
    }

    private fun setAdapter(items: List<String>) {
        binding?.rvIngredients?.adapter = IngredientAdapter(items)
    }
}