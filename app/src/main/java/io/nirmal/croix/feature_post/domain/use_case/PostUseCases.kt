package io.nirmal.croix.feature_post.domain.use_case

data class PostUseCases(
    val getPostsForFollowsUseCase: GetPostsForFollowsUseCase,
    val createPostUseCase: CreatePostUseCase
)