package com.codingwithme.essaidice.ui.dice.firstclass

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.codingwithme.essaidice.R
import com.codingwithme.essaidice.firstclass.DiceRollerImageProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DiceRollerViewModel : ViewModel()
{
    fun handleUiEvent(event: UiEvent)
    {
        when(event)
        {
            is UiEvent.OnRollClicked -> getDiceImage()
        }
    }
    private fun getDiceImage()
    {
        _uiState.value = with(_uiState.value)
        {
            copy(
                imageToShow = DiceRollerImageProvider().image
            )
        }
    }
    private val _uiState = MutableStateFlow(
        DiceRollerUiState(
            R.drawable.empty_dice,
            R.string.roll,
            R.string.app_name
        )
    )
    data class DiceRollerUiState(
        @DrawableRes val imageToShow: Int,
        @StringRes val buttonLabel: Int,
        @StringRes val contentDescription: Int
    )

    sealed interface UiEvent {
        object OnRollClicked : UiEvent
    }

    val uiState: StateFlow<DiceRollerUiState> = _uiState.asStateFlow()

}