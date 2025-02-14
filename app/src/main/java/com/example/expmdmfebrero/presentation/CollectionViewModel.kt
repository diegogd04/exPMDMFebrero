package com.example.expmdmfebrero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expmdmfebrero.domain.Collection
import com.example.expmdmfebrero.domain.GetCollectionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class CollectionViewModel(private val getCollectionsUseCase: GetCollectionsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    var uiState: LiveData<UiState> = _uiState

    fun loadCollections() {
        uiState.value?.isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            val collections = getCollectionsUseCase()

            uiState.value?.collections = collections
            uiState.value?.error = error("Error encontrado")
        }
    }

    data class UiState(
        var isLoading: Boolean = false,
        var error: Error? = null,
        var collections: List<Collection>? = emptyList()
    )
}