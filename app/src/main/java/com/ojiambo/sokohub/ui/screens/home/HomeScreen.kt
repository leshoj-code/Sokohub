package com.ojiambo.sokohub.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text( text = "Step in")

    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}