package com.teamsparta.todolist.domain.todo.dto

import java.time.LocalDateTime
import java.util.Date

data class CreateTodoRequest(
    val title: String,
    val description: String?,
    val name: String,
)
