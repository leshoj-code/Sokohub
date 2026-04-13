package com.ojiambo.sokohub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ojiambo.sokohub.ui.screens.about.AboutScreen
import com.ojiambo.sokohub.ui.screens.auth.LoginScreen
import com.ojiambo.sokohub.ui.screens.auth.RegisterScreen
import com.ojiambo.sokohub.ui.screens.home.HomeScreen
import com.ojiambo.sokohub.ui.screens.intent.IntentScreen
import com.ojiambo.sokohub.ui.screens.onboarding.OnboardingScreen
import com.ojiambo.sokohub.ui.screens.scaffold.ScaffoldScreen
import com.ojiambo.sokohub.ui.screens.service.ServiceScreen
import com.ojiambo.sokohub.ui.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUT_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUT_ONBOARDING) {
            OnboardingScreen(navController)
        }
        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }
        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_SCAFFOLD) {
            ScaffoldScreen(navController)
        }

    }
}