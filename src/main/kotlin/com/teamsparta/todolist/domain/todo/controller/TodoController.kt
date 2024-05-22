package com.teamsparta.todolist.domain.todo.controller

import com.teamsparta.todolist.domain.todo.dto.*
import com.teamsparta.todolist.domain.todo.exception.DisagreementException
import com.teamsparta.todolist.domain.todo.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.todo.exception.RequestBodyEmptyException
import com.teamsparta.todolist.domain.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/todos")
@RestController
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun getTodoList(): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodoList())
    }

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodoById(todoId))
    }

    @PostMapping
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<TodoResponse> {
        if (createTodoRequest.title == "") throw RequestBodyEmptyException("title")
        if (createTodoRequest.name == "") throw RequestBodyEmptyException("name")

        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(createTodoRequest))
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long, @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        if (updateTodoRequest.title == "") throw RequestBodyEmptyException("title")
        if (updateTodoRequest.name == "") throw RequestBodyEmptyException("name")

        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(todoId, updateTodoRequest))
    }

    @PatchMapping("/{todoId}")
    fun changeTodoStatus(
        @PathVariable todoId: Long
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.changeTodoStatus(todoId))
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Unit> {
        todoService.deleteTodo(todoId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @PostMapping("/{todoId}")
    fun createComment(
        @PathVariable todoId: Long, @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createComment(todoId, createCommentRequest))
    }

    @PutMapping("/{todoId}/{commentId}")
    fun updateComment(
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(
                todoService.updateComment(
                    todoId, commentId, updateCommentRequest
                )
            )
    }

    @DeleteMapping("/{todoId}/{commentId}")
    fun deleteComment(
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
        @RequestBody deleteCommentRequest: DeleteCommentRequest
    ): ResponseEntity<Unit> {
        todoService.deleteComment(todoId, commentId, deleteCommentRequest)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(message = e.message))
    }

    @ExceptionHandler(RequestBodyEmptyException::class)
    fun handleRequestBodyException(e: RequestBodyEmptyException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(message = e.message))
    }

    @ExceptionHandler(DisagreementException::class)
    fun handleRequestBodyException(e: DisagreementException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(message = e.message))
    }
}