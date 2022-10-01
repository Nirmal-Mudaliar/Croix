package io.nirmal.croix.feature_post.domain.repository

import android.content.ContentResolver
import android.net.Uri
import androidx.paging.PagingData
import io.nirmal.croix.core.domain.models.Post
import io.nirmal.croix.core.util.Constants
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.SimpleResource
import kotlinx.coroutines.flow.Flow
import java.io.File


interface PostRepository {
    val posts: Flow<PagingData<Post>>

    suspend fun createPost(description: String, imageUri: Uri): SimpleResource
}