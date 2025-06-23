package com.gundogar.todoappmeg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(val todosRepository: TodosRepository) : ViewModel() {

    fun update(id: Int,name: String) {
        viewModelScope.launch {
            todosRepository.update(id,name)
        }
    }

}