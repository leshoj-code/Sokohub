package com.ojiambo.sokohub.ui.screens.home

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ojiambo.sokohub.ui.theme.Burgundy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        //TopAppBar
        TopAppBar(
            title = { Text(text = "Home", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                }
            },

            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "cart")
                }

                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "notification")
                }
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Burgundy,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White

            )

        )
        //End of TopAppBar

    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}