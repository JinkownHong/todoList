package com.teamsparta.todolist.domain.post.exception

data class RequestBodyEmptyException(val modelName: String) : RuntimeException(
    "$modelName is empty"
)