package io.nirmal.croix.feature_profile.presentation.util

import io.nirmal.croix.core.util.Error
import io.nirmal.croix.feature_auth.presentation.util.AuthError

sealed class EditProfileError: Error() {
    object FieldEmpty: EditProfileError()

}
