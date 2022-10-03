package io.nirmal.croix.feature_profile.presentation.profile

import io.nirmal.croix.feature_profile.domain.model.Profile

data class ProfileState(
    val profile: Profile? = null,
    val isLoading: Boolean = false,

    )
