package io.nirmal.croix.feature_auth.data.data_source.remote.request

data class CreateAccountRequest(
    val email: String,
    val username: String,
    val password: String
)
