package com.ojiambo.sokohub.ui.screens.about

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojiambo.sokohub.navigation.ROUT_HOME
import com.ojiambo.sokohub.navigation.ROUT_INTENT
import com.ojiambo.sokohub.navigation.ROUT_LOGIN
import com.ojiambo.sokohub.ui.theme.Burgundy



@Composable
fun BusinessCard(
    name: String,
    role: String,
    phone: String,
    email: String,
    backgroundColor: Color
) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            // Top row (Name + Icons)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = role,
                        color = Color.White
                    )
                }

                Row {
                    IconButton(onClick = { /* Edit */ }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.White)
                    }
                    IconButton(onClick = { /* Notification */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notify", tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Phone Row
            Row(verticalAlignment = Alignment.CenterVertically) {

                IconButton(
                    onClick = {
                        val callIntent= Intent(Intent.ACTION_DIAL)
                        callIntent.data="tel:0762876015".toUri()
                        context.startActivity(callIntent)
                    }
                ) {
                    Icon(Icons.Default.Call, contentDescription = "Call", tint = Color.White)
                }

                Text(text = phone, color = Color.White)
            }

            // Email Row
            Row(verticalAlignment = Alignment.CenterVertically) {

                IconButton(
                    onClick = {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("leshyoj@gmail.com"))
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                        context.startActivity(shareIntent)
                    }
                ) {
                    Icon(Icons.Default.Email, contentDescription = "Share", tint = Color.White)
                }

                Text(text = email, color = Color.White)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController){

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(


        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Business Cards") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Back")
                    }
                },

                actions = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Back", tint = Color.White)
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Burgundy,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ),

                )
        },


        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Burgundy
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {


                //Main Contents of the page

                Spacer(modifier = Modifier.height(20.dp))

                BusinessCard(
                    name = "John Smith",
                    role = "Business Consultant",
                    phone = "+254 745 325 564",
                    email = "johnsmith@gmail.com",
                    backgroundColor = Color(0xFF2196F3) // Blue
                )

                BusinessCard(
                    name = "Amanda Black",
                    role = "Dentist",
                    phone = "+1 336 235 564",
                    email = "amandablack@gmail.com",
                    backgroundColor = Color.Red
                )

                BusinessCard(
                    name = "David Hill",
                    role = "Designer",
                    phone = "+1 459 235 564",
                    email = "davidhill@gmail.com",
                    backgroundColor = Color(0xFFFFC107) // Yellow
                )















            }
        }
    )

    //End of scaffold

}



@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}