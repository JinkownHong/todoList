package com.teamsparta.todolist.domain.post.dto.todo

data class UpdateTodoRequest(
    val title: String,
    val description: String?,
    val name: String,
)