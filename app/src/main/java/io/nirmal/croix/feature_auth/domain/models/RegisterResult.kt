package io.nirmal.croix.feature_auth.domain.models

import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.feature_auth.presentation.util.AuthError

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)