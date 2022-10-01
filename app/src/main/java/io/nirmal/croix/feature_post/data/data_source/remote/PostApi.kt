package io.nirmal.croix.feature_post.data.data_source.remote

import io.nirmal.croix.core.data.dto.response.BasicApiResponse
import io.nirmal.croix.core.domain.models.Post
import io.nirmal.croix.feature_post.data.data_source.remote.request.CreatePostRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface PostApi {

    @GET("/api/post/get")
    suspend fun getPostForFollows(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<Post>

    @Multipart
    @POST("/api/post/create")
    suspend fun createPost(
        @Part postData: MultipartBody.Part,
        @Part postImaage: MultipartBody.Part
    ): BasicApiResponse<Unit>

    companion object {
        const val BASE_URL = "http://192.168.1.6:8080/"
    }

}