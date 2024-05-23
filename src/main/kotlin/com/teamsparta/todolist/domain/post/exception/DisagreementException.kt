package com.teamsparta.todolist.domain.post.exception

data class DisagreementException(val modelName: String) : RuntimeException(
    "$modelName does not match"
)
