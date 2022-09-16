package io.nirmal.croix.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.domain.models.BottomNavItem
import io.nirmal.croix.presentation.utils.Screen


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
                    modifier = Modifier.fillMaxWidth(),
                    cutoutShape = CircleShape,
                    backgroundColor = Color.White,
                    elevation = 8.dp
                ) {
                    BottomNavigation(
                        backgroundColor = Color.White
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
                FloatingActionButton(
                    backgroundColor =  Color(0xFFD1BEFF),
                    contentColor = Color.Black,
                    onClick = onFabClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.make_post)
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