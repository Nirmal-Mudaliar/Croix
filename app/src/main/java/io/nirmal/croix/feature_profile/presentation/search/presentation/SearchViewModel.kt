package io.nirmal.croix.feature_profile.presentation.search.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.core.domain.states.StandardTextFieldStates
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
): ViewModel() {
    private val _searchState = mutableStateOf<StandardTextFieldStates>(StandardTextFieldStates())
    val searchState: State<StandardTextFieldStates> = _searchState

    fun setSearchState(state: StandardTextFieldStates) {
        _searchState.value = state
    }
}