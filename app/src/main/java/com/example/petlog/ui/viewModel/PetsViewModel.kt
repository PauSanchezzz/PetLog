package com.example.petlog.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petlog.data.model.GetPetsResponseItem
import com.example.petlog.di.RetrofitPet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PetsViewModel : ViewModel() {
    val listOrderBy = listOf("Nombre", "Raza", "Edad")

    var _listPet: List<GetPetsResponseItem> by mutableStateOf(listOf())
    var selectedItem by mutableStateOf(listOrderBy[0])

    init {
        getPets()
    }

    fun selectItem(item: String) {
        selectedItem = item
        when (item) {
            "Nombre" -> getPetsOrderBy("name")
            "Raza" -> getPetsOrderBy("breed")
            "Edad" -> getPetsOrderBy("age")
        }
    }

    fun getPets() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitPet.webService.getPets()
            withContext(Dispatchers.Main) {
                _listPet = response
            }
        }
    }

    fun getPetsOrderBy(orderBy: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitPet.webService.getPetsSortBy(orderBy)
            withContext(Dispatchers.Main) {
                _listPet = response
            }
        }
    }

}