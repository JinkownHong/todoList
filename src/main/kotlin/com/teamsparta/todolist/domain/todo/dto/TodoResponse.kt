package com.teamsparta.todolist.domain.todo.dto

import java.time.LocalDateTime
import java.util.Date

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val date: String,
    val name: String
)
