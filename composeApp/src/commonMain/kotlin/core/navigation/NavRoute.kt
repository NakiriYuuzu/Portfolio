package core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import core.util.extension.safePopBackStack
import feature.profile.ProfileScreenRoot
import feature.setting.SettingScreenRoot

@Composable
fun NavRoute(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = ProfileGroup
    ) {
        profileGraph(navController)
        portfolioGraph(navController)
        settingGraph(navController)
    }
}

private fun NavGraphBuilder.profileGraph(
    navController: NavHostController
) {
    navigation<ProfileGroup>(
        startDestination = ProfileGroup.ProfileScreen,
    ) {
        composable<ProfileGroup.ProfileScreen> {
            ProfileScreenRoot(
                onSettingClick = { navController.navigate(SettingGroup.SettingScreen) }
            )
        }
    }
}

private fun NavGraphBuilder.portfolioGraph(
    navController: NavHostController
) {
    navigation<PortfolioGroup>(
        startDestination = PortfolioGroup.PortfolioScreen,
    ) {
        composable<PortfolioGroup.PortfolioScreen> {  }
    }
}

private fun NavGraphBuilder.settingGraph(
    navController: NavHostController
) {
    navigation<SettingGroup>(
        startDestination = SettingGroup.SettingScreen,
    ) {
        composable<SettingGroup.SettingScreen> {
            SettingScreenRoot(
                onBackClicked = { navController.safePopBackStack() }
            )
        }
    }
}