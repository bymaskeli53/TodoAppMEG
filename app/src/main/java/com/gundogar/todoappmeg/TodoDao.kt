package com.gundogar.todoappmeg

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    suspend fun getTodos(): List<Todo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun delete(toDo: Todo)

    @Query("SELECT * FROM toDos WHERE name LIKE '%' || :searchText || '%'")
    suspend fun search(searchText: String): List<Todo>


}