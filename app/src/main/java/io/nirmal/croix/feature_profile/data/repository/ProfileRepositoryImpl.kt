package io.nirmal.croix.feature_profile.data.repository

import io.nirmal.croix.R
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.UiText
import io.nirmal.croix.feature_profile.data.remote.ProfileApi
import io.nirmal.croix.feature_profile.domain.model.Profile
import io.nirmal.croix.feature_profile.domain.repository.ProfileRepository
import retrofit2.HttpException
import java.io.IOException

class ProfileRepositoryImpl(
    private val api: ProfileApi
): ProfileRepository {
    override suspend fun getProfile(userId: String): Resource<Profile> {
        return try {
            val response = api.getProfile(userId)
            if (response.successful) {
                Resource.Success(response.data?.toProfile())
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(UiText.StringResource(R.string.error_couldnt_reach_server))
        } catch (e: HttpException) {
            Resource.Error(UiText.StringResource(R.string.error_something_went_wrong))
        }
    }
}