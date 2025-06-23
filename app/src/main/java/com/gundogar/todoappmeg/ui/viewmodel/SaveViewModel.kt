package com.gundogar.todoappmeg.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gundogar.todoappmeg.domain.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor(private val todosRepository: TodosRepository) : ViewModel() {

     fun save(name: String) {
        viewModelScope.launch {
            todosRepository.save(name)
        }
    }
}