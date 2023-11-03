package com.clarkelamothe.recetapp.recipe.domain.usecase

import assertk.assertThat
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class FilterOutRecipesUseCaseTest {
    private lateinit var filterOutRecipes: FilterOutRecipesUseCase

    @BeforeEach
    fun setup() {
        filterOutRecipes = FilterOutRecipesUseCase()
    }

    @Test
    fun `filter out list by a null query returns empty list`() {
        val query = null
        val list = listOf(mockk<Recipe>(relaxed = true))

        val result = filterOutRecipes(query, list)

        assertThat(result).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["black pepper", "   black pepper  "]
    )
    fun `filter out list by a ingredient returns an expected list`(query: String) {
        val list = listOf(
            Recipe(
                name = "Homemade Mexican Chorizo",
                items = listOf(
                    "chile peppers",
                    "skinless and boneless pork butt",
                    "pork fat",
                    "allspice berries",
                    "cider vinegar",
                    "cloves",
                    "salt",
                    "black pepper",
                    "cumin seeds",
                    "hog casing"
                )
            ),
            Recipe(
                name = "Pollo a la Pina",
                items = listOf(
                    "soy sauce",
                    "salt",
                    "black pepper",
                    "garlic powder",
                    "ground cumin",
                    "boneless, skinless chicken breasts",
                    "pineapple syrup",
                    "white sugar",
                    "potato starch",
                    "vegetable oil",
                    "tomato paste",
                    "bell pepper",
                    "green onions"
                )
            ),
            Recipe(
                name = "Empanadas Salteñas",
                items = listOf(
                    "water",
                    "salt",
                    "all-purpose flour",
                    "melted margarine",
                    "vegetable oil",
                    "potatoes",
                    "salted butter",
                    "onions",
                    "bell peppers",
                    "ground beef",
                    "cayenne pepper",
                    "ground cumin",
                    "paprika",
                    "hard-boiled eggs"
                )
            )
        )

        val expected = listOf(
            Recipe(
                name = "Homemade Mexican Chorizo",
                items = listOf(
                    "chile peppers",
                    "skinless and boneless pork butt",
                    "pork fat",
                    "allspice berries",
                    "cider vinegar",
                    "cloves",
                    "salt",
                    "black pepper",
                    "cumin seeds",
                    "hog casing"
                )
            ),
            Recipe(
                name = "Pollo a la Pina",
                items = listOf(
                    "soy sauce",
                    "salt",
                    "black pepper",
                    "garlic powder",
                    "ground cumin",
                    "boneless, skinless chicken breasts",
                    "pineapple syrup",
                    "white sugar",
                    "potato starch",
                    "vegetable oil",
                    "tomato paste",
                    "bell pepper",
                    "green onions"
                )
            ),
        )

        val result = filterOutRecipes(query, list)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["homemade", "   mexican  "]
    )
    fun `filter out list by a name returns an expected list`(query: String) {
        val list = listOf(
            Recipe(
                name = "Homemade Mexican Chorizo",
                items = listOf(
                    "chile peppers",
                    "skinless and boneless pork butt",
                    "pork fat",
                    "allspice berries",
                    "cider vinegar",
                    "cloves",
                    "salt",
                    "black pepper",
                    "cumin seeds",
                    "hog casing"
                )
            ),
            Recipe(
                name = "Pollo a la Pina",
                items = listOf(
                    "soy sauce",
                    "salt",
                    "black pepper",
                    "garlic powder",
                    "ground cumin",
                    "boneless, skinless chicken breasts",
                    "pineapple syrup",
                    "white sugar",
                    "potato starch",
                    "vegetable oil",
                    "tomato paste",
                    "bell pepper",
                    "green onions"
                )
            ),
            Recipe(
                name = "Empanadas Salteñas",
                items = listOf(
                    "water",
                    "salt",
                    "all-purpose flour",
                    "melted margarine",
                    "vegetable oil",
                    "potatoes",
                    "salted butter",
                    "onions",
                    "bell peppers",
                    "ground beef",
                    "cayenne pepper",
                    "ground cumin",
                    "paprika",
                    "hard-boiled eggs"
                )
            )
        )

        val expected = listOf(
            Recipe(
                name = "Homemade Mexican Chorizo",
                items = listOf(
                    "chile peppers",
                    "skinless and boneless pork butt",
                    "pork fat",
                    "allspice berries",
                    "cider vinegar",
                    "cloves",
                    "salt",
                    "black pepper",
                    "cumin seeds",
                    "hog casing"
                )
            )
        )

        val result = filterOutRecipes(query, list)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["", "   "]
    )
    fun `filter out list by a empty query returns original list`(query: String) {
        val list = (1..10).map {
            Recipe()
        }

        val result = filterOutRecipes(query, list)

        assertThat(result).isEqualTo(list)
    }
}