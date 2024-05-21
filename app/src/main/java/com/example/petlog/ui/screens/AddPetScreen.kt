package com.example.petlog.ui.screens

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petlog.ui.components.PetTopAppBar
import com.example.petlog.ui.viewModel.AddPetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPetScreen(
    navController: NavController,
    addPetViewModel: AddPetViewModel = AddPetViewModel()
) {
    val spacerHeightModifier = Modifier.height(15.dp)
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
            Spacer(Modifier.height(35.dp))

            OutlinedTextField(shape = RoundedCornerShape(25),
                value = addPetViewModel._name,
                onValueChange = {
                    addPetViewModel.onNameChange(it)
                },
                label = { Text("Nombre") })

            Spacer(spacerHeightModifier)

            var typePet = addPetViewModel.selectedType
            var typeList = addPetViewModel.typeList

            var expandedState by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                modifier = Modifier
                    .clip(RoundedCornerShape(25)),
                expanded = expandedState,
                onExpandedChange = {
                    expandedState = it
                }
            ) {
                TextField(
                    value = typePet,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState) },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expandedState,
                    onDismissRequest = { expandedState = false },
                ) {
                    typeList.forEachIndexed { index, item ->
                        DropdownMenuItem(
                            text = {
                                Text(item)
                            },
                            onClick = {
                                addPetViewModel.onTypeChange(typeList[index])
                                expandedState = false
                            }
                        )
                    }
                }
            }
            Spacer(spacerHeightModifier)

            OutlinedTextField(shape = RoundedCornerShape(25),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = addPetViewModel._age,
                onValueChange = {
                    addPetViewModel.onAgeChange(it)
                },
                label = { Text("Edad") })

            Spacer(spacerHeightModifier)

            var breedList = addPetViewModel.getBreedList()
            var breedSelected = addPetViewModel._breed
            var expanded by remember { mutableStateOf(false) }

            ExposedDropdownMenuBox(
                modifier = Modifier
                    .clip(RoundedCornerShape(25)),
                expanded = expanded,
                onExpandedChange = {
                    expanded = it
                }
            ) {
                TextField(
                    value = breedSelected,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    breedList.forEachIndexed { index, item ->
                        DropdownMenuItem(
                            text = {
                                Text(item)
                            },
                            onClick = {
                                addPetViewModel.onBreedChange(breedList[index])
                                expanded = false
                            }
                        )
                    }

                }
            }

            Spacer(spacerHeightModifier)

            var uri by remember {
                mutableStateOf<Uri?>(null)
            }

            val photoPicker =
                rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.PickVisualMedia(),
                    onResult = {
                        uri = it
                    })

            ElevatedButton(onClick = {
                photoPicker.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }) {
                Text(
                    text = "Imagen", modifier = Modifier.padding(horizontal = 90.dp)
                )
            }
            Log.d("uri ","$uri")

            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier.padding(bottom = 80.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(
                    border = BorderStroke(
                        width = 1.dp, color = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = { addPetViewModel.addPet() },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "Guardar", color = MaterialTheme.colorScheme.onPrimary)
                }
                Spacer(Modifier.width(50.dp))
                OutlinedButton(onClick = { navController.popBackStack() }) {
                    Text("Atras")
                }

            }
        }
    }
}