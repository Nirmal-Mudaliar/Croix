package io.nirmal.croix.feature_auth.domain.models

import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.feature_auth.presentation.util.AuthError

data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource?  = null
)
