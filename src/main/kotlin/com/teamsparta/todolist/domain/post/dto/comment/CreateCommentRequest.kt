package com.teamsparta.todolist.domain.post.dto.comment

data class CreateCommentRequest(
    val commentWriter: String,
    val password: String,
    val comment: String,
)
