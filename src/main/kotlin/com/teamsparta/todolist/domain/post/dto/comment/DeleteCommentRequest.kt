package com.teamsparta.todolist.domain.post.dto.comment

data class DeleteCommentRequest(
    val commentWriter: String,
    val password: String,
)
