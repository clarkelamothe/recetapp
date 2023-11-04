package com.clarkelamothe.recetapp.recipe.presentation

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiModel
import com.clarkelamothe.recetapp.recipe.presentation.utils.toDomain
import com.clarkelamothe.recetapp.recipe.presentation.utils.toUiModel
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class MappersExtensionsTest {
    @Test
    fun `recipe to recipeUiModel mapper`() {
        val recipe = mockk<Recipe>(relaxed = true)
        val expected = mockk<RecipeUiModel> {
            every { imageUrl } returns recipe.imageUrl
            every { name } returns recipe.name
            every { description } returns recipe.description
            every { location.latitude } returns recipe.location.latitude
            every { location.longitude } returns recipe.location.longitude
            every { items } returns recipe.items
        }

        val result = recipe.toUiModel()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `recipeUiModel to domain mapper`() {
        val recipeUiModel = mockk<RecipeUiModel>(relaxed = true)
        val expected = mockk<Recipe> {
            every { imageUrl } returns recipeUiModel.imageUrl
            every { name } returns recipeUiModel.name
            every { description } returns recipeUiModel.description
            every { location.latitude } returns recipeUiModel.location.latitude
            every { location.longitude } returns recipeUiModel.location.longitude
            every { items } returns recipeUiModel.items
        }

        val result = recipeUiModel.toDomain()

        assertThat(result).isEqualTo(expected)
    }
}