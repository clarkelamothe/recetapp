package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import kotlinx.coroutines.flow.flowOf

class GetRecipeUseCase {

    operator fun invoke() = flowOf(
        listOf(
            Recipe(
                "https://img.delicious.com.au/cBifuvzJ/del/2016/05/baked-butter-chicken-30562-1.jpg",
                "Baked butter chicken"
            ),
            Recipe(
                "https://www.delicious.com.au/recipes/pasta-allamatriciana/b4793f68-8413-4294-9340-5f86aea7fa6c?r=recipes/collections/2mzgg7y0",
                "Pasta all'amaticiana"
            ),
            Recipe(
                "https://www.delicious.com.au/recipes/instant-pork-ragu/8bfc8222-78fc-40eb-ad02-1d7ab6471709?r=recipes/collections/2mzgg7y0",
                "Instant Pork Ragu"
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
                "",
                "Dummy name"
            )
        )
    )
}