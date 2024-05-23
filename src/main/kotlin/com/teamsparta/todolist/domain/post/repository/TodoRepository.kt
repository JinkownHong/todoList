package com.teamsparta.todolist.domain.post.repository

import com.teamsparta.todolist.domain.post.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
    fun findAllByOrderByDateDesc(): List<Todo>
}