package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.model.Location
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import kotlinx.coroutines.flow.flowOf

class GetRecipeUseCase {

    operator fun invoke() = flowOf(
        listOf(
            Recipe(
                "https://www.allrecipes.com/thmb/enBP9Rw1u1LbjL6I4ba0btckFH0=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/272544-Baked-Lemon-Butter-Chicken-Thighs-ddmfs-146-4x3-2d49fd8b8c524fa9ba9be963adb0bfe4.jpg",
                "Baked butter chicken",
                "These butter chicken breasts are dipped in beaten eggs and cracker crumbs, then baked with butter. These chicken breasts are really tender and moist with excellent flavor!",
                Location(35.0, 18.0),
                arrayListOf("tomato", "chicken", "chicken", "pasta")
            ),
            Recipe(
                "https://www.insidetherustickitchen.com/wp-content/uploads/2021/07/Bucatini-Amatriciana-1200px-inside-the-rustic-kitchen.jpg",
                "Pasta all'amaticiana",
                "This classic bucatini all’Amatriciana is packed to the brim with flavor from spices and herbs! If you are looking for a recipe to impress your guests, then look no more. This is the one!",
                Location(35.0, 18.0),
                arrayListOf("tomato", "chicken", "chicken", "pasta")
            ),
            Recipe(
                "https://balancewithjess.com/wp-content/uploads/2021/08/Pork-Ragu-1.jpg",
                "Instant Pork Ragu",
                "This succulent Instant Pot Pork Ragu is comfort food at its best! Juicy braised pork shoulder swimming in a rich tomato sauce feels cozy, rich, and indulgent.",
                Location(35.0, 18.0),
                arrayListOf("tomato", "chicken", "chicken", "pasta")
            ),
            Recipe(
                "https://hips.hearstapps.com/hmg-prod/images/garlic-butter-baked-chicken-thighs-horizontal-1534280494.jpg?crop=0.532xw:0.798xh;0.127xw,0.123xh&resize=1200:*",
                "Baked butter chicken",
                "These butter chicken breasts are dipped in beaten eggs and cracker crumbs, then baked with butter. These chicken breasts are really tender and moist with excellent flavor!",
                Location(35.0, 18.0),
                arrayListOf("tomato", "chicken", "chicken", "pasta")
            )
        )
    )
}