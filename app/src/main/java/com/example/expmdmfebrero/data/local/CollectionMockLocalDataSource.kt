package com.example.expmdmfebrero.data.local

import com.example.expmdmfebrero.domain.Collection
import com.example.expmdmfebrero.domain.Mushroom
import org.koin.core.annotation.Single

@Single
class CollectionMockLocalDataSource {

    private val mushroomsAvila = listOf(
        Mushroom(
            "1",
            "Boletus",
            System.currentTimeMillis().toString(),
            "Grande y marrón",
            "https://micoex.org/wp-content/uploads/stories/1-boletus-edulis.jpg"
        ),
        Mushroom(
            "2",
            "Niscalo",
            System.currentTimeMillis().toString(),
            "Pequeño y naranja",
            "https://i.blogs.es/ab65d9/niscalos-cesta/450_1000.jpg"
        )
    )

    private val mushroomsSalamanca = listOf(
        Mushroom(
            "1",
            "Niscalo",
            System.currentTimeMillis().toString(),
            "Pequeño y naranja",
            "https://i.blogs.es/ab65d9/niscalos-cesta/450_1000.jpg"
        ),
        Mushroom(
            "2",
            "Seta de cardo",
            System.currentTimeMillis().toString(),
            "Plana y marrón",
            "https://guadarramistas.com/wp-content/uploads/2023/07/setas-de-cardo.jpg"
        )
    )

    private val collections = listOf(
        Collection(
            "1",
            "Ávila",
            mushroomsAvila,
            false
        ),
        Collection(
            "2",
            "Salamanca",
            mushroomsSalamanca,
            false
        )
    )

    fun getCollections(): List<Collection> {
        return collections
    }
}