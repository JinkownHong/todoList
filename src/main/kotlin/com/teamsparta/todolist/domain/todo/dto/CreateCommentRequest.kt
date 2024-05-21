package com.teamsparta.todolist.domain.todo.dto

data class CreateCommentRequest(
    val commentWriter: String,
    val password: String,
    val comment: String,
)
