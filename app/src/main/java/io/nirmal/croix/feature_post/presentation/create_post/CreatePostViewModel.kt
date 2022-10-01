package io.nirmal.croix.feature_post.presentation.create_post

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.core.domain.states.StandardTextFieldStates
import io.nirmal.croix.feature_post.domain.use_case.CreatePostUseCase
import io.nirmal.croix.feature_post.domain.use_case.PostUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val postUseCase: PostUseCases
): ViewModel() {

    private val _descriptionState = mutableStateOf<StandardTextFieldStates>(StandardTextFieldStates())
    val descriptionState: State<StandardTextFieldStates> = _descriptionState
    
    private val _chosenImageUri = mutableStateOf<Uri?>(null)
    val chosenImageUri: State<Uri?> = _chosenImageUri

    fun onEvent(event: CreatePostEvent) {

        when(event) {
            is CreatePostEvent.EnterDescription -> {
                _descriptionState.value = descriptionState.value.copy(
                    text = event.value
                )
            }
            is CreatePostEvent.PickImage -> {
                _chosenImageUri.value = event.uri
            }
            is CreatePostEvent.PostImage -> {
                chosenImageUri.value?.let {
                    viewModelScope.launch {
                        postUseCase.createPostUseCase(description = descriptionState.value.text, imageUri = it)

                    }
                }
            }
        }
    }
}