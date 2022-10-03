package io.nirmal.croix.feature_profile.data.remote.response

import io.nirmal.croix.feature_profile.domain.model.Profile

data class ProfileResponse(
    val userId: String,
    val username: String,
    val bio: String,
    val followerCount: Int,
    val followingCount: Int,
    val postCount: Int,
    val profilePictureUrl: String,
    val bannerUrl: String,
    val topSkillUrls: List<String>,
    val gitHubUrl: String?,
    val instagramUrl: String?,
    val linkedInUrl: String?,
    val isOwnProfile: Boolean,
    val isFollowing: Boolean,

) {
    fun toProfile(): Profile {
        return Profile(
            userId,
            username,
            bio,
            followerCount,
            followingCount,
            postCount,
            profilePictureUrl,
            bannerUrl,
            topSkillUrls,
            gitHubUrl,
            instagramUrl,
            linkedInUrl,
            isOwnProfile,
            isFollowing
        )
    }
}