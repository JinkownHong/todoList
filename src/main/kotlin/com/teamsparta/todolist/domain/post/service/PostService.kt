package com.teamsparta.todolist.domain.post.service

import com.teamsparta.todolist.domain.post.dto.comment.CommentResponse
import com.teamsparta.todolist.domain.post.dto.comment.CreateCommentRequest
import com.teamsparta.todolist.domain.post.dto.comment.DeleteCommentRequest
import com.teamsparta.todolist.domain.post.dto.comment.UpdateCommentRequest
import com.teamsparta.todolist.domain.post.dto.todo.CreateTodoRequest
import com.teamsparta.todolist.domain.post.dto.todo.TodoResponse
import com.teamsparta.todolist.domain.post.dto.todo.UpdateTodoRequest

interface PostService {

    fun getAllTodoList(): List<TodoResponse>

    fun getTodoById(todoId: Long): TodoResponse

    fun createTodo(request: CreateTodoRequest): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse

    fun changeTodoStatus(todoId: Long): TodoResponse

    fun deleteTodo(todoId: Long)

    fun createComment(todoId: Long, request: CreateCommentRequest): CommentResponse

    fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(todoId: Long, commentId: Long, request: DeleteCommentRequest)
}