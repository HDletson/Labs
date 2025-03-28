package com.example.mycity.data

import com.example.mycity.R

object Datasource {
    private val parksCategory=Category(
        name=R.string.parks_category,
        icon = R.drawable.nature_icon,
        list=listOf(
            Place(
                name = R.string.ural_river_title,
                description = R.string.ural_river_description,
                address = R.string.ural_river_address,
                photo = R.drawable.ural_river
            ),
            Place(
                name = R.string.ecopark_title,
                description = R.string.ecopark_description,
                address = R.string.ecopark_address,
                photo = R.drawable.ecopark
            ),
            Place(
                name = R.string.victory_park_title,
                description = R.string.victory_park_description,
                address = R.string.victory_park_address,
                photo = R.drawable.victory_park
            ),
            Place(
                name = R.string.northern_park_title,
                description = R.string.northern_park_description,
                address = R.string.northern_park_address,
                photo = R.drawable.northern_park
            )
        )
    )
    private val shopsCategory=Category(
        name=R.string.shops_category,
        icon=R.drawable.shops_icon,
        list = listOf(
            Place(
                name = R.string.continent_mall_title,
                description = R.string.continent_mall_description,
                address = R.string.continent_mall_address,
                photo = R.drawable.continent_mall
            ),
            Place(
                name = R.string.gostiniy_dvor_title,
                description = R.string.gostiniy_dvor_description,
                address = R.string.gostiniy_dvor_address,
                photo = R.drawable.gostiniy_dvor
            )
        )
    )

    private val attractionsCategory= Category(
        name = R.string.attractions_category,
        icon = R.drawable.attractions_icon,
        list = listOf(
            Place(
                name = R.string.magnitka_title,
                description = R.string.magnitka_description,
                address = R.string.magnitka_address,
                photo = R.drawable.magnitka
            ),
            Place(
                name = R.string.drama_theater_title,
                description = R.string.drama_theater_description,
                address = R.string.drama_theater_address,
                photo = R.drawable.drama_theater
            ),
            Place(
                name = R.string.museum_title,
                description = R.string.museum_description,
                address = R.string.museum_address,
                photo = R.drawable.museum
            ),
            Place(
                name = R.string.steelers_statue_title,
                description = R.string.steelers_statue_description,
                address = R.string.steelers_statue_address,
                photo = R.drawable.steelers_statue
            ),
            Place(
                name = R.string.bridge_title,
                description = R.string.bridge_description,
                address = R.string.bridge_address,
                photo = R.drawable.bridge
            ),
        )

    )
    val listOfCategories = listOf(parksCategory, shopsCategory, attractionsCategory)

}