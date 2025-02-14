package com.example.expmdmfebrero.domain

import org.koin.core.annotation.Single

@Single
class GetCollectionByIdUseCase(private val repository: CollectionRepository) {

    operator fun invoke(collectionId: String): Collection? {
        return repository.getCollectionById(collectionId)
    }
}