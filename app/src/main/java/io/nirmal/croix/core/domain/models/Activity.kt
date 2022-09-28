package io.nirmal.croix.core.domain.models

import io.nirmal.croix.feature_activity.data.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)
