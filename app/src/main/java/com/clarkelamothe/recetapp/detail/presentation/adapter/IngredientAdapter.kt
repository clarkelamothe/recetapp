package com.clarkelamothe.recetapp.detail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clarkelamothe.recetapp.databinding.IngredientItemBinding

class IngredientAdapter(
    private val ingredients: List<String>,
) : RecyclerView.Adapter<IngredientAdapter.IngredientsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = LayoutInflater.from(parent.context)
        return IngredientsViewHolder(IngredientItemBinding.inflate(view, parent, false))
    }

    override fun getItemCount() = ingredients.size

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    inner class IngredientsViewHolder(
        binding: IngredientItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        private val tvName = binding.tvIngredientName

        fun bind(ingredient: String) {
            tvName.text = ingredient
        }
    }
}