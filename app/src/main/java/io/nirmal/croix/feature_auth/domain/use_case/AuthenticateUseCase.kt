package io.nirmal.croix.feature_auth.domain.use_case

import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): SimpleResource {
        return authRepository.authenticate()
    }
}