package com.teamsparta.todolist.domain.todo.exception

data class RequestBodyEmptyException(val modelName: String) : RuntimeException(
    "$modelName is empty"
)