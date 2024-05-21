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
import androidx.navigation.NavController
import com.example.petlog.data.model.GetPetsResponseItem
import com.example.petlog.ui.navigation.AppScreens
import com.example.petlog.ui.viewModel.PetsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetSearchList(navController: NavController, petsViewModel: PetsViewModel) {
    val searchText = petsViewModel.searchText
    val petsList = petsViewModel._listPet
    val isSearching = petsViewModel._isSearching

    SearchBar(
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = "")
        },
        query = searchText,
        onQueryChange = petsViewModel::onSearchTextChange,
        onSearch = petsViewModel::onSearchTextChange,
        active = isSearching,
        onActiveChange = { petsViewModel.onToogleSearch() },
    ) {
        LazyColumn {
            items(petsList) {
                PetCard(
                    title = it.name,
                    subtitle = it.breed,
                    onTap = { navController.navigate("${AppScreens.PetDetailScreen.route}/${it.name}") },
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
