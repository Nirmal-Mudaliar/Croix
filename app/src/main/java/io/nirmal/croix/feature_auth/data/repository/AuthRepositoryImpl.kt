package io.nirmal.croix.feature_auth.data.repository

import io.nirmal.croix.R
import io.nirmal.croix.core.data.dto.response.BasicApiResponse
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.core.util.UiText
import io.nirmal.croix.feature_auth.data.dto.request.CreateAccountRequest
import io.nirmal.croix.feature_auth.data.remote.AuthApi
import io.nirmal.croix.feature_auth.domain.repository.AuthRepository
import okio.IOException
import retrofit2.HttpException


class AuthRepositoryImpl(
    private val api: AuthApi
): AuthRepository {

    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource {
        val request = CreateAccountRequest(
            email = email,
            username = username,
            password = password
        )
        return try {
            val response = api.register(request)
            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(uiText = UiText.DynamicString(msg))
                } ?: Resource.Error(uiText = UiText.StringResource(R.string.error_unknown))

            }

        } catch (e: okio.IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_something_went_wrong)
            )
        }
    }
}