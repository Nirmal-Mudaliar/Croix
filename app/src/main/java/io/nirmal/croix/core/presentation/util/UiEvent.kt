package io.nirmal.croix.core.presentation.util

import io.nirmal.croix.core.util.UiText

sealed class UiEvent {
    data class SnackbarEvent(val value: UiText): UiEvent()
    data class NavigateEvent(val route: String): UiEvent()
}