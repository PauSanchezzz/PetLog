package com.example.petlog.ui.viewModel

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.petlog.di.RetrofitPet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class AddPetViewModel : ViewModel() {

    val typeList = listOf("Gato", "Perro")
    val catBreedList = listOf("Calico", "Tuxedo")
    val dogBreedList = listOf("bulldog", "pitbull")
    var selectedType: String by mutableStateOf("Gato")
    var _name: String by mutableStateOf("")
    var _age: String by mutableStateOf("")
    var _breed: String by mutableStateOf("Seleccione")
    var _image: Uri? by mutableStateOf(null)

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

    fun onImageChange(image: Uri?) {
        _image = image
    }

    fun addPet(
        context: Context
    ) {
        Log.d("prueba ", _name)
        Log.d("prueba ", _age)
        Log.d("prueba ", selectedType)
        Log.d("prueba ", _breed)
        Log.d("prueba ", _image.toString())


        GlobalScope.launch {
            var file = File(_image?.path ?: "")

            if (file.exists()) {
                try {
                    val response = RetrofitPet.webService.addPet(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), _name),
                        RequestBody.create(
                            "text/plain".toMediaTypeOrNull(), _age
                        ),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), _breed),
                        RequestBody.create(
                            "text/plain".toMediaTypeOrNull(), selectedType
                        ),
                        MultipartBody.Part.createFormData(
                            "image",
                            file.name,
                            file.asRequestBody("image/*".toMediaTypeOrNull())
                        )
                    )

                } catch (e: Exception) {
                    Log.d("Error: ", "${e.message}")
                }
            }

            withContext(Dispatchers.Main) {
            }
        }
    }

}
