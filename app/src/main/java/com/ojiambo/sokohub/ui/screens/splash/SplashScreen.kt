package com.ojiambo.sokohub.ui.screens.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojiambo.sokohub.R
import com.ojiambo.sokohub.navigation.ROUT_ONBOARDING
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    // Animation states
    var startAnimation by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.7f,
        animationSpec = tween(durationMillis = 1200, easing = EaseOutBack)
    )

    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1200)
    )

    // Launch effect for animation + navigation
    LaunchedEffect(true) {
        startAnimation = true
        delay(2500)
        navController.navigate(ROUT_ONBOARDING) {
            popUpTo(0)
        }
    }

    // Gradient background (burgundy theme)
    val gradient = Brush.verticalGradient(
        colors = listOf(
            androidx.compose.ui.graphics.Color(0xFF5E1224),
            androidx.compose.ui.graphics.Color(0xFF8B1E3F)
        )
    )

    Column(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        // Logo with animation
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Sokohub Logo",
            modifier = Modifier
                .size(220.dp)
                .scale(scale)
                .alpha(alpha)
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Loading indicator (subtle)
        CircularProgressIndicator(
            color = androidx.compose.ui.graphics.Color.White,
            strokeWidth = 3.dp,
            modifier = Modifier.size(30.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}