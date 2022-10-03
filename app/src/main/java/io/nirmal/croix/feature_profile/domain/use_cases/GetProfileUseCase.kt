package io.nirmal.croix.feature_profile.domain.use_cases

import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.feature_profile.domain.model.Profile
import io.nirmal.croix.feature_profile.domain.repository.ProfileRepository

class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}