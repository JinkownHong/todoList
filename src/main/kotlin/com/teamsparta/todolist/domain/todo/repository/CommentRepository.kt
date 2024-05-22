package com.teamsparta.todolist.domain.todo.repository

import com.teamsparta.todolist.domain.todo.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
    fun findByTodoIdAndId(todoId: Long, id: Long): Comment?
}