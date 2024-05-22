package com.teamsparta.todolist.domain.todo.dto

data class UpdateCommentRequest(
    val commentWriter: String,
    val password: String,
    val comment: String,
)
