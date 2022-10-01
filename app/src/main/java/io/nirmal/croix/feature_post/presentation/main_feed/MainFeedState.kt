package io.nirmal.croix.feature_post.presentation.main_feed

import io.nirmal.croix.core.domain.models.Post

data class MainFeedState(
    val isLoadingFirstTime: Boolean = true,
    val isLoadingNewPosts: Boolean = false,
)
