package com.example.androidretrofit.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidretrofit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier.background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {  }) {
                Icon(
                    painterResource(id = R.drawable.home),
                    contentDescription = "Home", tint = Color.Black,
                    modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = {  }) {
                Icon(painterResource(id = R.drawable.like),
                    contentDescription = "Like", tint = Color.Black,
                    modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = ({})) {
                Icon(
                    painterResource(id = R.drawable.settings),
                    contentDescription = "Settings", tint = Color.Black,
                    modifier = Modifier.size(28.dp))
            }
        }
    }
}