package com.teamsparta.todolist.domain.post.dto.todo

import jakarta.validation.constraints.Size

data class CreateTodoRequest(
    @field: Size(max = 100, message = "Please enter less than 100 characters")
    val title: String,
    @field: Size(min = 1, max = 1000, message = "Please enter at least 1 character and not more than 1000 characters")
    val description: String,
    val name: String,
)
