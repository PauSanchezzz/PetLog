package com.example.petlog.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petlog.ui.components.PetBreed
import com.example.petlog.ui.components.PetTopAppBar
import com.example.petlog.ui.components.PetType
import com.example.petlog.ui.navigation.AppScreens

@Composable
fun AddPetScreen(navController: NavController) {
    Scaffold(
        topBar = {
            PetTopAppBar("PetLog")
        },
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15, 15, 0, 0))
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
                .padding(top = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registro Mascota",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(35.dp))

            OutlinedTextField(
                shape = RoundedCornerShape(25),
                value = "",
                onValueChange = { /*TODO*/ },
                label = { Text("Nombre") }
            )
            PetType()

            OutlinedTextField(
                shape = RoundedCornerShape(25),
                value = "",
                onValueChange = { /*TODO*/ },
                label = { Text("Edad") }
            )
            PetBreed()
            ElevatedButton(
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Imagen", modifier = Modifier
                        .padding(horizontal = 90.dp)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .padding(bottom = 80.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {

                OutlinedButton(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "Guardar", color = MaterialTheme.colorScheme.onPrimary)
                }

                Spacer(modifier = Modifier.width(50.dp))

                OutlinedButton(onClick = {navController.navigate(AppScreens.HomeScreen.route) }) {
                    Text("Atras")
                }

            }
        }
    }
}