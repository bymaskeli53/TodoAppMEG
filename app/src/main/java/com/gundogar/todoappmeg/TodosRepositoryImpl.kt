package com.gundogar.todoappmeg

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodosRepositoryImpl @Inject constructor(val todoDao: TodoDao) : TodosRepository {
    override suspend fun save(name: String) {
        todoDao.insertTodo(Todo(name = name))
    }

    override suspend fun update(id: Int,name: String) {
        todoDao.updateTodo(Todo(id = id, name = name))
    }

    override suspend fun delete(todo: Todo) {
        todoDao.delete(todo)
    }

    override fun getTodos(): Flow<List<Todo>> {
        return todoDao.getTodos()
    }

    override  fun search(query: String): Flow<List<Todo>> {
        return todoDao.search(query)
    }
}