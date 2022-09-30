package io.nirmal.croix.feature_auth.data.remote

import com.nirmal.data.response.AuthResponse
import io.nirmal.croix.core.data.dto.response.BasicApiResponse
import io.nirmal.croix.feature_auth.data.dto.request.CreateAccountRequest
import io.nirmal.croix.feature_auth.data.dto.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/user/create")
    suspend fun register(@Body request: CreateAccountRequest): BasicApiResponse<Unit>

    @POST("/api/user/login")
    suspend fun login(@Body request: LoginRequest): BasicApiResponse<AuthResponse>

    companion object {
        const val BASE_URL = "http://192.168.1.6:8080/"
    }
}