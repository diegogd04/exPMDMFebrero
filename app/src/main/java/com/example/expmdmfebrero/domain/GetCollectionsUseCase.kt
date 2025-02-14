package com.example.expmdmfebrero.domain

import org.koin.core.annotation.Single

@Single
class GetCollectionsUseCase(private val repository: CollectionRepository) {

    operator fun invoke(): List<Collection> {
        return repository.getCollections()
    }
}