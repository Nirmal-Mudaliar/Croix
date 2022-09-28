package io.nirmal.croix.core.domain.models

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val icon: ImageVector? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
    val route: String
)
