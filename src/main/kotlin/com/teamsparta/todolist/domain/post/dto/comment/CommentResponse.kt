package com.teamsparta.todolist.domain.post.dto.comment

data class CommentResponse(
    val id: Long,
    val commentWriter: String,
    val comment: String,
)
