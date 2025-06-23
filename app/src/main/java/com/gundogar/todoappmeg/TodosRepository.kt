package com.gundogar.todoappmeg

interface TodosRepository {

    suspend fun save(name: String)

    suspend fun update(name: String)

    suspend fun delete(todo: Todo)

    suspend fun getTodos(): List<Todo>

    suspend fun search(query: String): List<Todo>


}