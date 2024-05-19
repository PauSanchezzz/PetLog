package com.example.petlog.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetOrderBy() {
    Row(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Ordenado por:",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.width(10.dp))
        PetOrderByMenu()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetOrderByMenu() {
    val items = listOf("Nombre", "Raza", "Edad")
    var selectedItemIndex by remember { mutableIntStateOf(0) }
    var expandedState by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expandedState,
        onExpandedChange = {
            expandedState = it
        }
    ) {
        TextField(
            value = items[selectedItemIndex],
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = true) },
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expandedState,
            onDismissRequest = { expandedState = false },
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Text(item)
                    },
                    onClick = {
                        selectedItemIndex = index
                        expandedState = false
                    }
                )
            }

        }
    }
}