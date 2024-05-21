package com.example.petlog.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petlog.data.model.GetPetsResponseItem
import com.example.petlog.di.RetrofitPet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PetsViewModel : ViewModel() {

    var _listPet: List<GetPetsResponseItem> by mutableStateOf(listOf())

    init {
        getPets()
    }

    fun getPets() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitPet.webService.getPets()
            withContext(Dispatchers.Main) {
                _listPet = response
            }
        }
    }
}