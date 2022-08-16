package io.nirmal.croix.domain.models

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val icon: ImageVector,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
    val route: String
)
