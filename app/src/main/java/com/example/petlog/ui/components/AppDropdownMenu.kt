package com.example.petlog.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDropdownMenu(listOfItems: List<String>) {
    var selectedItem by remember { mutableStateOf(listOfItems[0]) }
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
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState) },
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expandedState,
            onDismissRequest = { expandedState = false },
        ) {
            listOfItems.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Text(item)
                    },
                    onClick = {
                        selectedItem = listOfItems[index]
                        expandedState = false
                    }
                )
            }

        }
    }
}