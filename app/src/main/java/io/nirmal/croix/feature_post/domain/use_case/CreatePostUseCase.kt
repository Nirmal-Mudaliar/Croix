package io.nirmal.croix.feature_post.domain.use_case

import android.content.ContentResolver
import android.net.Uri
import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.feature_post.domain.repository.PostRepository

class CreatePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(
        description: String,
        imageUri: Uri,
    ): SimpleResource {
        return postRepository.createPost(description = description, imageUri = imageUri)
    }
}