package com.example.petlog.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetSearchList(onTap: () -> Unit) {
    SearchBar(
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = "")
        },
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = true,
        onActiveChange = {},
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.padding(horizontal = 10.dp),
        ) {
            items(10) {
                PetCard(
                    title = "Name",
                    subtitle = "breed",
                    onTap = onTap,
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}