package io.nirmal.croix.feature_profile.data.remote

import io.nirmal.croix.core.data.dto.response.BasicApiResponse
import io.nirmal.croix.feature_profile.data.remote.response.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApi {

    @GET("/api/user/profile")
    suspend fun getProfile(
        @Query("userId") userId: String,
    ): BasicApiResponse<ProfileResponse>

    companion object {
        const val BASE_URL = "http://192.168.1.6:8080/"
    }
}