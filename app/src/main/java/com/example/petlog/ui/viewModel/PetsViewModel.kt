package com.example.petlog.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petlog.data.dto.GetPetsResponseItem
import com.example.petlog.data.repository.PetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetsViewModel @Inject constructor(
    private val repo:PetsRepository
): ViewModel(){
    private val _state = MutableStateFlow(emptyList<GetPetsResponseItem>())
    val state : StateFlow<List<GetPetsResponseItem>>
        get() = _state

    init {
viewModelScope.launch {
    _state.value = repo.getAllPets()
}
    }
}