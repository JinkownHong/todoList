package com.teamsparta.todolist.domain.todo.exception

data class DisagreementException(val modelName: String) : RuntimeException(
    "$modelName does not match"
)
