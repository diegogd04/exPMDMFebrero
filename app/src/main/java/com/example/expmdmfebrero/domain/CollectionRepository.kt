package com.example.expmdmfebrero.domain

interface CollectionRepository {
    fun getCollections(): List<Collection>
    fun getCollectionById(collectionId: String): Collection?
}