package com.teamsparta.todolist.domain.post.dto.comment

data class UpdateCommentRequest(
    val commentWriter: String,
    val password: String,
    val comment: String,
)
