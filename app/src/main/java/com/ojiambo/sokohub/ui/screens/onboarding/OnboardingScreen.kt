package com.ojiambo.sokohub.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ojiambo.sokohub.R

@Composable
fun OnboardingScreen(){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.product),
            contentDescription = "product",
            modifier = Modifier.size(300.dp)


            )

    }

}


@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen()
}