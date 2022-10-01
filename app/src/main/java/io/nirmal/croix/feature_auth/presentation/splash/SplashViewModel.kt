package io.nirmal.croix.feature_auth.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.core.presentation.util.UiEvent
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.Screen
import io.nirmal.croix.feature_auth.domain.use_case.AuthenticateUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
): ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            when(authenticateUseCase()) {
                is Resource.Success -> {
                    _eventFlow.emit(UiEvent.Navigate(Screen.MainFeedScreen.route))
                }
                is Resource.Error -> {
                    _eventFlow.emit(UiEvent.Navigate(Screen.LoginScreen.route))

                }
            }
        }
    }
}