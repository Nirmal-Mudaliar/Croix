package io.nirmal.croix.feature_auth.domain.use_case

import android.util.Patterns
import io.nirmal.croix.core.domain.util.ValidationUtil
import io.nirmal.croix.core.util.Constants
import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.feature_auth.domain.models.RegisterResult
import io.nirmal.croix.feature_auth.domain.repository.AuthRepository
import io.nirmal.croix.feature_auth.presentation.util.AuthError

class RegisterUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        username: String,
        password: String
    ): RegisterResult {
        val emailError = ValidationUtil.validateEmail(email)
        val usernameError = ValidationUtil.validateUsername(username)
        val passwordError = ValidationUtil.validatePassword(password)
        if (emailError != null || usernameError != null || passwordError != null) {
            return RegisterResult(
                emailError = emailError,
                usernameError = usernameError,
                passwordError = passwordError,
            )
        }
        val result = authRepository.register(email, username, password)

        return RegisterResult(
            result = result
        )
    }
}