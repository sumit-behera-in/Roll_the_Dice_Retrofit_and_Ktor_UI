package apps.sumit.rollthedice.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import apps.sumit.rollthedice.presentation.features.mainScreen.MainScreen
import apps.sumit.rollthedice.presentation.features.splashScreen.SplashScreen
import apps.sumit.rollthedice.presentation.ui.theme.RollTheDiceTheme
import apps.sumit.rollthedice.presentation.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollTheDiceTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.SplashScreenRoute.route
                ) {
                    composable(route = Screen.SplashScreenRoute.route) {
                        SplashScreen(navController = navController)
                    }
                    composable(route = Screen.MainScreenRoute.route) {
                        MainScreen()
                    }
                }
            }
        }
    }
}

