package io.nirmal.croix.feature_profile.presentation.editProfile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.core.domain.states.StandardTextFieldStates
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
): ViewModel() {
    private val _usernameState = mutableStateOf<StandardTextFieldStates>(StandardTextFieldStates())
    val usernameStates: State<StandardTextFieldStates> = _usernameState

    fun setUsernameState(state: StandardTextFieldStates) {
        _usernameState.value = state
    }

    private val _githubTextFieldState = mutableStateOf<StandardTextFieldStates>(
        StandardTextFieldStates())
    val githubTextFieldState: State<StandardTextFieldStates> = _githubTextFieldState

    fun setGithubTextFieldState(state: StandardTextFieldStates) {
        _githubTextFieldState.value = state
    }

    private val _instagramTextFieldState = mutableStateOf<StandardTextFieldStates>(
        StandardTextFieldStates())
    val instagramTextFieldState: State<StandardTextFieldStates> = _instagramTextFieldState

    fun setInstagramTextFieldState(state: StandardTextFieldStates) {
        _instagramTextFieldState.value = state
    }

    private val _linkedinTextFieldState = mutableStateOf<StandardTextFieldStates>(
        StandardTextFieldStates())
    val linkedinTextFieldState: State<StandardTextFieldStates> = _linkedinTextFieldState

    fun setLinkedinTextFieldState(state: StandardTextFieldStates) {
        _linkedinTextFieldState.value = state
    }

    private val _bioState = mutableStateOf<StandardTextFieldStates>(StandardTextFieldStates())
    val bioState: State<StandardTextFieldStates> = _bioState

    fun setBioState(state: StandardTextFieldStates) {
        _bioState.value = state
    }
}