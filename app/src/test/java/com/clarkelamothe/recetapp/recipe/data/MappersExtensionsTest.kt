package com.clarkelamothe.recetapp.recipe.data

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeDto
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class MappersExtensionsTest {

    @Test
    fun `recipeDto to recipe mapper`() {
        val recipeDto = mockk<RecipeDto>(relaxed = true)
        val expected = mockk<Recipe> {
            every { imageUrl } returns recipeDto.imageUrl
            every { name } returns recipeDto.name
            every { description } returns recipeDto.description
            every { location.latitude } returns recipeDto.location.latitude
            every { location.longitude } returns recipeDto.location.longitude
            every { items } returns recipeDto.items
        }

        val result = recipeDto.toDomain()

        assertThat(result).isEqualTo(expected)
    }
}