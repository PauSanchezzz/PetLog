package com.example.petlog.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petlog.data.model.GetPetsResponseItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetSearchList(onTap: () -> Unit, mascota: List<GetPetsResponseItem>) {
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
        LazyColumn {
            items(mascota) {
                PetCard(
                    title = it.name,
                    subtitle = it.breed,
                    onTap = onTap,
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
