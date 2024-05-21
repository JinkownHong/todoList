package com.teamsparta.todolist.domain.todo.dto

data class CommentResponse(
    val id: Long,
    val todo: TodoResponse,
    val commentWriter: String,
    val comment: String,
)
