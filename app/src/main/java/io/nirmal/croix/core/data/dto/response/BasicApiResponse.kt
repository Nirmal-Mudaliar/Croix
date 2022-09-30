package io.nirmal.croix.core.data.dto.response

data class BasicApiResponse<T>(
    val successful: Boolean,
    val message: String? = null,
    val data: T? = null

)
