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

class PetViewModel : ViewModel() {
    var _pet: GetPetsResponseItem by mutableStateOf(GetPetsResponseItem())
    var _petName: String by mutableStateOf("")

    fun saveName(name: String) {
        _petName = name
        getPet(_petName)
    }

    fun getPet(name: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitPet.webService.getPet(name)
            withContext(Dispatchers.Main) {
                val pepito = response.first()
                _pet = pepito
            }
        }
    }
}