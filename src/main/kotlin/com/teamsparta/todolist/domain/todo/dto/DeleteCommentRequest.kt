package com.teamsparta.todolist.domain.todo.dto

data class DeleteCommentRequest(
    val commentWriter: String,
    val password: String,
)
