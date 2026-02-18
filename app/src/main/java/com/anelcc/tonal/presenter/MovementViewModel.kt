package com.anelcc.tonal.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anelcc.tonal.data.Movement
import com.anelcc.tonal.domain.MoventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovementViewModel @Inject constructor(val movementUseCase: MoventUseCase): ViewModel() {
    val _uiState = MutableStateFlow(MovementUiState())
    val uiState : StateFlow<MovementUiState> = _uiState.asStateFlow()

    val selectedItem = MutableStateFlow<Movement?>(null)


    fun fetchMovementList() {
        viewModelScope.launch {// fetch real service
            val list =  movementUseCase.invoke()
            _uiState.update {
                it.copy(
                    movementList = list
                )
            }
        }
    }

    fun onSelectItem(item: Movement) {
        selectedItem.update {
            item
        }
    }
}

data class MovementUiState(
    val movementList: MutableList<Movement> = mutableListOf()
)