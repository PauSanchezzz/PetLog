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
            "Order by:",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.width(10.dp))
        ExposedDropdownMenuBox(
            expanded = false,
            onExpandedChange = {
            }
        ) {
            TextField(
                value = "breed",
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = true) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = false,
                onDismissRequest = { }
            ) {
                DropdownMenuItem(
                    text = { Text("breed") },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text("name") },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text("age") },
                    onClick = { }
                )
            }
        }
    }
}