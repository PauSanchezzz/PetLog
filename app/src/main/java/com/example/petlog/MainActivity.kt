package com.example.petlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.petlog.ui.navigation.AppNavigation
import com.example.petlog.ui.theme.PetLogTheme
import com.example.petlog.ui.viewModel.PetsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: PetsViewModel by viewModels()
                enableEdgeToEdge()
        setContent {
            PetLogTheme {
               AppNavigation(viewModel)
            }
        }
    }
}