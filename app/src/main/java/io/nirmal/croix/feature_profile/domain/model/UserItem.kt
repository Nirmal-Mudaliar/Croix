package io.nirmal.croix.feature_profile.domain.model

data class UserItem(
    val userId: String,
    val username: String,
    val profilePictureUrl: String,
    val bio: String,
    val isFollowing: Boolean
) {
    fun toUserItem(): UserItem {
        return UserItem(
            userId, username, profilePictureUrl, bio, isFollowing
        )
    }
}
