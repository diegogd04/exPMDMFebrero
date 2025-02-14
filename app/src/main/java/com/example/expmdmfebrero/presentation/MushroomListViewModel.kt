package com.example.expmdmfebrero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expmdmfebrero.domain.GetCollectionByIdUseCase
import com.example.expmdmfebrero.domain.Mushroom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MushroomListViewModel(private val getCollectionByIdUseCase: GetCollectionByIdUseCase) :
    ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    var uiState: LiveData<UiState> = _uiState

    fun loadMushrooms(mushroomId: String) {
        uiState.value?.isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            val mushrooms = getCollectionByIdUseCase(mushroomId)?.mushrooms
            uiState.value?.mushrooms = mushrooms
            uiState.value?.error = error("Error encontrado")
        }
    }

    data class UiState(
        var isLoading: Boolean = false,
        var error: Error? = null,
        var mushrooms: List<Mushroom>? = emptyList()
    )
}