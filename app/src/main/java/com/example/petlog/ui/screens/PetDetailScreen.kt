package com.example.petlog.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PetDetailScreen(){
    Scaffold {
        Column(
            Modifier.padding(it),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Pet Detail Screen")
        }
    }
}