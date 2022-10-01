package io.nirmal.croix.feature_post.presentation.main_feed

sealed class MainFeedEvents {
    object LoadMorePost: MainFeedEvents()
    object LoadedPage: MainFeedEvents()
}