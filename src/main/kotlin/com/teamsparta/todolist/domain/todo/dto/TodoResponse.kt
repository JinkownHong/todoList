package com.teamsparta.todolist.domain.todo.dto

import java.util.Date

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val date: Date,
    val name: String
)
