package io.nirmal.croix.feature_auth.domain.use_case

import io.nirmal.croix.core.domain.util.ValidationUtil
import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.feature_auth.domain.models.LoginResult
import io.nirmal.croix.feature_auth.domain.repository.AuthRepository
import io.nirmal.croix.feature_auth.presentation.util.AuthError

class LoginUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): LoginResult {
        val emailError = if (email.isBlank()) AuthError.FieldEmpty else null
        val passwordError = if (password.isBlank()) AuthError.FieldEmpty else null

        if (emailError != null || passwordError != null) {
            return LoginResult(
                emailError = emailError,
                passwordError = passwordError
            )
        }
        val result = authRepository.login(email, password)
        return LoginResult(
            result = result
        )
    }
}