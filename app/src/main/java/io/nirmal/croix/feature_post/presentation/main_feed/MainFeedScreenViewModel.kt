package io.nirmal.croix.feature_post.presentation.main_feed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.feature_post.domain.use_case.PostUseCases


import javax.inject.Inject

@HiltViewModel
class MainFeedScreenViewModel @Inject constructor(
    private val postUseCases: PostUseCases
): ViewModel() {

    private val _state = mutableStateOf(MainFeedState())
    val state: State<MainFeedState> = _state

    val posts = postUseCases.getPostsForFollowsUseCase()
        .cachedIn(viewModelScope)

    fun onEvent(event: MainFeedEvents) {
        when(event){
            is MainFeedEvents.LoadMorePost -> {
                _state.value = state.value.copy(
                    isLoadingNewPosts = true
                )
            }
            is MainFeedEvents.LoadedPage -> {
                _state.value = state.value.copy(
                    isLoadingFirstTime = false,
                    isLoadingNewPosts = false
                )
            }

        }
    }

}