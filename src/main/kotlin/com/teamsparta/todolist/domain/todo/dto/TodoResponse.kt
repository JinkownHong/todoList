package com.teamsparta.todolist.domain.todo.dto

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val status: String,
    val date: String,
    val name: String
)
