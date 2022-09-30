package io.nirmal.croix.feature_auth.domain.repository

import io.nirmal.croix.core.data.dto.response.BasicApiResponse
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.feature_auth.data.dto.request.CreateAccountRequest

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource

    suspend fun login(
        email: String,
        password: String
    ): SimpleResource

    suspend fun authenticate(): SimpleResource
}