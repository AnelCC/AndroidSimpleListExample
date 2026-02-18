package com.anelcc.tonal.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anelcc.tonal.data.Movement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovementViewModel(): ViewModel() {


    val _uiState = MutableStateFlow(MovementUiState())
    val uiState : StateFlow<MovementUiState> = _uiState.asStateFlow()

    val selectedItem = MutableStateFlow<Movement?>(null)


    val movements = listOf(
        Movement(id = "1", name = "Bench Press", url = "https://tonal.com/cdn/shop/files/paul_3770x_2_screen.webp?v=1741275088&width=768", description = "Upper-body exercise that uses the chest, shoulders and triceps."),
        Movement(id = "2", name = "Goblet Squat", url = "https://tonal.com/cdn/shop/files/paul_3383x_2_screen.webp?v=1741288691&width=768", description = "Lower-body that involves legs, glutes and core."),
        Movement(id = "3", name = "Biceps Curl", url = "https://tonal.com/cdn/shop/files/jarod_4109x_2_screen.webp?v=1741275614&width=768", description = "Upper-body exercise that lifts weight through elbow flexion."),
        Movement(id = "4", name = "Rotational Chop", url = "https://tonal.com/cdn/shop/files/kelly_6315x_2_screen.jpg?v=1741291777&width=768", description = "Core-strengthening exercise that trains the abdominals and obliques.")
    )



    fun fetchMovementList() {
        val movements = listOf(
            Movement(id = "1", name = "Bench Press", url = "https://tonal.com/cdn/shop/files/paul_3770x_2_screen.webp?v=1741275088&width=768", description = "Upper-body exercise that uses the chest, shoulders and triceps."),
            Movement(id = "2", name = "Goblet Squat", url = "https://tonal.com/cdn/shop/files/paul_3383x_2_screen.webp?v=1741288691&width=768", description = "Lower-body that involves legs, glutes and core."),
            Movement(id = "3", name = "Biceps Curl", url = "https://tonal.com/cdn/shop/files/jarod_4109x_2_screen.webp?v=1741275614&width=768", description = "Upper-body exercise that lifts weight through elbow flexion."),
            Movement(id = "4", name = "Rotational Chop", url = "https://tonal.com/cdn/shop/files/kelly_6315x_2_screen.jpg?v=1741291777&width=768", description = "Core-strengthening exercise that trains the abdominals and obliques.")
        )

        viewModelScope.launch {// fetch real service
            //
            /*uiState.update {
                it.copy(movementList = movements)
            }*/
        }
    }

    fun onSelectItem(item: Movement) {
        selectedItem.update {
            item
        }
    }
}

class MovementUiState(
    movementList: List<Movement> = emptyList()
)