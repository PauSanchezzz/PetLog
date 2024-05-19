package com.example.petlog.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.petlog.ui.navigation.AppScreens

@Composable
fun AddPetScreen() {
    Scaffold {
        Column(
            Modifier.padding(it),
            verticalArrangement = Arrangement.Center,
            ) {
            Text(text = "Add Pet Screen")
        }
    }
}