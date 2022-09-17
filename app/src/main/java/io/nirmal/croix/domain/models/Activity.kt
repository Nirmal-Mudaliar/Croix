package io.nirmal.croix.domain.models

import io.nirmal.croix.domain.utils.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)
