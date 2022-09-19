package io.nirmal.croix.presentation.create_post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.presentation.utils.states.StandardTextFieldStates
import javax.inject.Inject

@HiltViewModel
class CreatePostViewModel @Inject constructor(
): ViewModel() {

    private val _descriptionState = mutableStateOf<StandardTextFieldStates>(StandardTextFieldStates())
    val descriptionState: State<StandardTextFieldStates> = _descriptionState

    fun setDescriptionState(state: StandardTextFieldStates) {
        _descriptionState.value = state
    }
}