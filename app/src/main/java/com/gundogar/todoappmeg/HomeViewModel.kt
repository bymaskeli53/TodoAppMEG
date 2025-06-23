package com.gundogar.todoappmeg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val todosRepository: TodosRepository) : ViewModel() {

    val todos: StateFlow<List<Todo>> = todosRepository.getTodos()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            todosRepository.delete(todo)
        }

    }

}