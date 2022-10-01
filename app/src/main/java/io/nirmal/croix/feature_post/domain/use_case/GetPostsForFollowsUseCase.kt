package io.nirmal.croix.feature_post.domain.use_case

import androidx.paging.PagingData
import io.nirmal.croix.core.domain.models.Post
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.feature_post.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsForFollowsUseCase(
    private val postRepository: PostRepository
) {

    operator fun invoke(): Flow<PagingData<Post>> {
        return postRepository.posts
    }
}