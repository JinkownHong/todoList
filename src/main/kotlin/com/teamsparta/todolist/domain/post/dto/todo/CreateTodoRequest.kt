package com.teamsparta.todolist.domain.post.dto.todo

data class CreateTodoRequest(
    val title: String,
    val description: String?,
    val name: String,
)
