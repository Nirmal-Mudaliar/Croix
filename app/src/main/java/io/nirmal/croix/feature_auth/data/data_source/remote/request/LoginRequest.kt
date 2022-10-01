package io.nirmal.croix.feature_auth.data.data_source.remote.request

data class LoginRequest(
    val email: String,
    val password: String
)