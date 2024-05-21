package com.teamsparta.todolist.domain.todo.dto

data class CreateTodoRequest(
    val title: String,
    val description: String?,
    val name: String,
)
