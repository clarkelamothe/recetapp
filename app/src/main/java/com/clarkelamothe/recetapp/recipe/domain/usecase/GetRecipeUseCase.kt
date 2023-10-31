package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import kotlinx.coroutines.flow.flowOf

class GetRecipeUseCase {

    operator fun invoke() = flowOf(
        listOf(
            Recipe(
                "https://hips.hearstapps.com/hmg-prod/images/garlic-butter-baked-chicken-thighs-horizontal-1534280494.jpg?crop=0.532xw:0.798xh;0.127xw,0.123xh&resize=1200:*",
                "Baked butter chicken",
                "These butter chicken breasts are dipped in beaten eggs and cracker crumbs, then baked with butter. These chicken breasts are really tender and moist with excellent flavor!"
            ),
            Recipe(
                "https://www.insidetherustickitchen.com/wp-content/uploads/2021/07/Bucatini-Amatriciana-1200px-inside-the-rustic-kitchen.jpg",
                "Pasta all'amaticiana",
                "This classic bucatini all’Amatriciana is packed to the brim with flavor from spices and herbs! If you are looking for a recipe to impress your guests, then look no more. This is the one!"
            ),
            Recipe(
                "https://balancewithjess.com/wp-content/uploads/2021/08/Pork-Ragu-1.jpg",
                "Instant Pork Ragu",
                "This succulent Instant Pot Pork Ragu is comfort food at its best! Juicy braised pork shoulder swimming in a rich tomato sauce feels cozy, rich, and indulgent."
            ),
            Recipe(
                "https://img.delicious.com.au/l7asZ00M/del/2022/05/matt-prestons-traditional-stew-and-dumplings-168040-2.png",
                "Traditional stew and herb dumplings"
            ),
            Recipe(
                "https://www.delicious.com.au/recipes/pasta-allamatriciana/b4793f68-8413-4294-9340-5f86aea7fa6c?r=recipes/collections/2mzgg7y0",
                "Pasta all'amaticiana"
            ),
            Recipe(
                "https://www.delicious.com.au/recipes/pasta-allamatriciana/b4793f68-8413-4294-9340-5f86aea7fa6c?r=recipes/collections/2mzgg7y0",
                "Pasta all'amaticiana"
            ),
            Recipe(
                "https://picsum.photos/200",
                "Dummy name"
            )
        )
    )
}