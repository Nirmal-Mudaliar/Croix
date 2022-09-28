package io.nirmal.croix.feature_activity.data

sealed class ActivityAction {
    object LikedPost: ActivityAction()
    object CommentedOnPost: ActivityAction()
    object FollowedYou : ActivityAction()
}
