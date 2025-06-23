package com.gundogar.todoappmeg

import kotlinx.coroutines.flow.Flow

interface TodosRepository {

    suspend fun save(name: String)

    suspend fun update(name: String)

    suspend fun delete(todo: Todo)

    fun getTodos(): Flow<List<Todo>>

    suspend fun search(query: String): List<Todo>


}