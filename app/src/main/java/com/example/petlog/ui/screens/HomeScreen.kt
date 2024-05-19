package com.example.petlog.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import com.example.petlog.ui.components.PetOrderBy
import com.example.petlog.ui.components.PetSearchList
import com.example.petlog.ui.components.PetTopAppBar
import com.example.petlog.ui.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            PetTopAppBar("PetLog")
        },
        floatingActionButton = {
            Button(
                shape = RoundedCornerShape(30),
                onClick = { navController.navigate(AppScreens.AddPetScreen.route) },
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Pet")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Add Pet")
            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 20.dp),
        ) {
            PetOrderBy()
            Spacer(modifier = Modifier.height(10.dp))
            PetSearchList(onTap = { navController.navigate(AppScreens.PetDetailScreen.route) })
        }
    }
}