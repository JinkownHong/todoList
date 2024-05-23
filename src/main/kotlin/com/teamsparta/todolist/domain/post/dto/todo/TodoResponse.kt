package com.teamsparta.todolist.domain.post.dto.todo

import com.teamsparta.todolist.domain.post.dto.comment.CommentResponse

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val date: String,
    val name: String,
    val status: Boolean,
    val comments: List<CommentResponse>
)
