package com.example.petlog.ui.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddPetViewModel : ViewModel() {

    val typeList = listOf("Gato", "Perro")
    val catBreedList = listOf("Calico", "Tuxedo")
    val dogBreedList = listOf("bulldog", "pitbull")
    var selectedType: String by mutableStateOf("Gato")
    var _name: String by mutableStateOf("")
    var _age: String by mutableStateOf("")
    var _breed: String by mutableStateOf("Seleccione")

    fun getBreedList(): List<String> {
        if (selectedType == "Gato") {
            return catBreedList
        }
        return dogBreedList
    }

    fun onNameChange(name: String) {
        _name = name
    }

    fun onAgeChange(age: String) {
        _age = age
    }

    fun onBreedChange(breed: String) {
        _breed = breed
    }

    fun onTypeChange(type: String) {
        selectedType = type
        _breed = "Seleccione"
    }

    fun addPet() {
        Log.d("prueba ", _name)
        Log.d("prueba ", _age)
        Log.d("prueba ", selectedType)
        Log.d("prueba ", _breed)

        viewModelScope.launch(Dispatchers.IO) {
           /* val response = RetrofitPet.webService.addPet(_name, _age.toInt(), _breed, selectedType)*/
            withContext(Dispatchers.Main) {
            }
        }
    }

}
