package io.nirmal.croix.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.ImageLoader
import io.nirmal.croix.core.domain.models.Post
import io.nirmal.croix.feature_activity.presentation.ActivityScreen
import io.nirmal.croix.feature_chat.presentation.ChatScreen
import io.nirmal.croix.feature_post.presentation.create_post.CreatePostScreen
import io.nirmal.croix.feature_profile.presentation.editProfile.EditProfileScreen
import io.nirmal.croix.feature_post.presentation.person_list.PersonListScreen
import io.nirmal.croix.feature_post.presentation.main_feed.MainFeedScreen
import io.nirmal.croix.feature_auth.presentation.splash.SplashScreen
import io.nirmal.croix.feature_auth.presentation.login.LoginScreen
import io.nirmal.croix.feature_post.presentation.post_detail.PostDetailScreen
import io.nirmal.croix.feature_profile.presentation.profile.ProfileScreen
import io.nirmal.croix.feature_auth.presentation.register.RegisterScreen
import io.nirmal.croix.feature_profile.presentation.search.presentation.SearchScreen
import io.nirmal.croix.core.util.Screen

@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: androidx.compose.material.ScaffoldState,
    imageLoader: ImageLoader
) {

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(
                onPopBackStack = navController::popBackStack,
                onNavigate = navController::navigate
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(onNavigate = navController::navigate, scaffoldState = scaffoldState)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(
                navController = navController,
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
            )
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
            )
        }
        composable(
            route = Screen.ProfileScreen.route + "?userId={userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
            ProfileScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(
                navController = navController,
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader
            )
        }
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                post = Post(
                    username = "Nirmal Mudaliar",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "kj kjdkf jkj kjdflj kdj k jdf kkljkdhjhjdf jhkjh dhjkdhfjkshiodjlkfgj j lkj lkjkf j kj kjkl    jjlkjlksjdflkj kjf lkjfk              jkfjfksj             jdksjfkljllkjdlfj kj kjdkf jkj kjdsdfgdfsg dfgdfg sdfgdfg dsfg dfg sdfg sdf dsfg fdg s dfg gfflj kdj k jdf kkljkdjkj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdflj kdj k jdf kkljkdj",
                    likeCount = 10,
                    commentCount = 6
                )
            )
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
            )
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
            )
        }
        composable(Screen.PersonListScreen.route) {
            PersonListScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
            )
        }
    }
}
