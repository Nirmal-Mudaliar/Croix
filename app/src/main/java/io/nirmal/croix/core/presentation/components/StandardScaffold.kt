package io.nirmal.croix.core.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.core.domain.models.BottomNavItem
import io.nirmal.croix.core.util.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    showToolbar: Boolean = true,
    toolbarTitle: String? = null,
    showBackArrow: Boolean = true,
    navActions: @Composable RowScope.()->Unit = {},
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.MainFeedScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = "Home",

            ),
        BottomNavItem(
            route = Screen.ChatScreen.route,
            icon = Icons.Outlined.Message,
            contentDescription = "Message",

            ),
        BottomNavItem(route = ""),
        BottomNavItem(
            route = Screen.ActivityScreen.route,
            icon = Icons.Outlined.Notifications,
            contentDescription = "Activity",

            ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Person",

            ),
    ),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit) {
    androidx.compose.material.Scaffold(

        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    backgroundColor = Color(0xFFFFFFFF),
                    cutoutShape = RoundedCornerShape(26.dp),
                    elevation = 10.dp,


                ) {
                    BottomNavigation(
                        backgroundColor = Color(0xFFFFFFFF),
                        modifier = modifier.fillMaxWidth(),
                        elevation = 0.dp

                    ) {
                        bottomNavItems.forEachIndexed { i, bottomNavItem ->

                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                                ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }

                            }

                        }

                    }

                }
            }


        },

        floatingActionButton = {
            if (showBottomBar) {
                androidx.compose.material3.FloatingActionButton(
                    contentColor = Color.White,
                    onClick = onFabClick,
                    containerColor = Color(0xFF2A2A2A)

                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.make_post),
                        tint = Color.White

                    )
                }
            }

        },

        modifier = modifier,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) {
        content()
    }
}