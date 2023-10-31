package com.clarkelamothe.recetapp.recipe.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.clarkelamothe.recetapp.databinding.RecipeItemBinding
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

class RecipeAdapter(
    private val recipes: List<Recipe>,
    private val onItemClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
        return RecipeViewHolder(RecipeItemBinding.inflate(view, parent, false)) {
            onItemClick(recipes[it])
        }
    }

    override fun getItemCount() = recipes.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    inner class RecipeViewHolder(
        binding: RecipeItemBinding,
        onItemClicked: (Int) -> Unit
    ) : ViewHolder(binding.root) {
        private val image = binding.ivRecipeImage
        private val name = binding.tvRecipeName

        init {
            itemView.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }

        fun bind(recipe: Recipe) {
            name.text = recipe.name

            Glide.with(image.context)
                .load(recipe.imageUrl)
                .into(image)
        }
    }
}