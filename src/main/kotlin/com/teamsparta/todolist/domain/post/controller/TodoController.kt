package com.teamsparta.todolist.domain.post.controller

import com.teamsparta.todolist.domain.post.dto.todo.CreateTodoRequest
import com.teamsparta.todolist.domain.post.dto.todo.TodoResponse
import com.teamsparta.todolist.domain.post.dto.todo.UpdateTodoRequest
import com.teamsparta.todolist.domain.post.exception.RequestBodyEmptyException
import com.teamsparta.todolist.domain.post.service.PostService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/todos")
@RestController
class TodoController(
    private val postService: PostService
) {

    @GetMapping
    fun getTodoList(): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllTodoList())
    }

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getTodoById(todoId))
    }

    @PostMapping
    fun createTodo(@Valid @RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<TodoResponse> {
        if (createTodoRequest.title == "") throw RequestBodyEmptyException("title")
        if (createTodoRequest.name == "") throw RequestBodyEmptyException("name")

        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createTodo(createTodoRequest))
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long, @Valid @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        if (updateTodoRequest.title == "") throw RequestBodyEmptyException("title")
        if (updateTodoRequest.name == "") throw RequestBodyEmptyException("name")

        return ResponseEntity.status(HttpStatus.OK).body(postService.updateTodo(todoId, updateTodoRequest))
    }

    @PatchMapping("/{todoId}")
    fun changeTodoStatus(
        @PathVariable todoId: Long
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.changeTodoStatus(todoId))
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Unit> {
        postService.deleteTodo(todoId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}