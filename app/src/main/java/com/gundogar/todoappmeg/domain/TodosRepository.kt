package com.gundogar.todoappmeg.domain

import com.gundogar.todoappmeg.data.Todo
import kotlinx.coroutines.flow.Flow

interface TodosRepository {

    suspend fun save(name: String)

    suspend fun update(id: Int, name: String)

    suspend fun delete(todo: Todo)

    fun getTodos(): Flow<List<Todo>>

    fun search(query: String): Flow<List<Todo>>


}