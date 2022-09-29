package io.nirmal.croix.core.domain.states

import io.nirmal.croix.core.util.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)
