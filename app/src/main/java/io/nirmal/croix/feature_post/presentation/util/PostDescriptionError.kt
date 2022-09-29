package io.nirmal.croix.feature_post.presentation.util

import io.nirmal.croix.core.util.Error
import io.nirmal.croix.feature_auth.presentation.util.AuthError

sealed class PostDescriptionError: Error() {
    object FieldEmpty: PostDescriptionError()
}
