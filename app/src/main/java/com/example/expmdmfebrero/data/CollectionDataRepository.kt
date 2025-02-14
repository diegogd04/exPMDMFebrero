package com.example.expmdmfebrero.data

import com.example.expmdmfebrero.data.local.CollectionMockLocalDataSource
import com.example.expmdmfebrero.domain.Collection
import com.example.expmdmfebrero.domain.CollectionRepository
import org.koin.core.annotation.Single

@Single
class CollectionDataRepository(private val local: CollectionMockLocalDataSource) :
    CollectionRepository {

    override fun getCollections(): List<Collection> {
        return local.getCollections()
    }

    override fun getCollectionById(collectionId: String): Collection? {
        val collections = local.getCollections()

        val collection = collections.find {
            it.id == collectionId
        }
        return collection
    }
}