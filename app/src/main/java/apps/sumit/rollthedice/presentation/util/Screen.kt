package apps.sumit.rollthedice.presentation.util

sealed class Screen(val route: String) {
    data object MainScreenRoute : Screen("MainScreen")
    data object SplashScreenRoute : Screen("SplashScreen")
}