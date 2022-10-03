package io.nirmal.croix.feature_profile.domain.repository

import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.feature_profile.domain.model.Profile

interface ProfileRepository {
    suspend fun getProfile(userId: String): Resource<Profile>
}