package com.gundogar.todoappmeg

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTodosRepository(
        todosRepositoryImpl: TodosRepositoryImpl
    ): TodosRepository


}