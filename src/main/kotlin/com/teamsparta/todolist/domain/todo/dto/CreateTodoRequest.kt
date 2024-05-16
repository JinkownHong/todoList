package com.teamsparta.todolist.domain.todo.dto

import java.util.Date

data class CreateTodoRequest(
    val title: String,
    val description: String?,
    val name: String,
    val date: Date
)
