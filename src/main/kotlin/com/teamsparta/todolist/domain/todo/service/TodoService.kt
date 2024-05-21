package com.teamsparta.todolist.domain.todo.service

import com.teamsparta.todolist.domain.todo.dto.*

interface TodoService {

    fun getAllTodoList(): List<TodoResponse>

    fun getTodoById(todoId: Long): TodoResponse

    fun createTodo(request: CreateTodoRequest): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse

    fun changeTodoStatus(todoId: Long): TodoResponse

    fun deleteTodo(todoId: Long)

    fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse
}