package io.nirmal.croix.core.presentation.util

import io.nirmal.croix.core.util.UiText

sealed class UiEvent {
    data class ShowSnackbar(val value: UiText): UiEvent()
    data class Navigate(val route: String): UiEvent()
    object NavigateUp : UiEvent()
    object OnLogin: UiEvent()
}