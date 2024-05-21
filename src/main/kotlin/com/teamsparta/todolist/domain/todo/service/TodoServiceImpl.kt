package com.teamsparta.todolist.domain.todo.service

import com.teamsparta.todolist.domain.todo.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import com.teamsparta.todolist.domain.todo.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todo.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.todo.model.Todo
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import com.teamsparta.todolist.domain.todo.model.toResponse
import com.teamsparta.todolist.domain.todo.repository.TodoRepository

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {
    override fun getAllTodoList(): List<TodoResponse> {
        return todoRepository.findAllByOrderByDateDesc().map { it.toResponse() }
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo",todoId)
        return todo.toResponse()
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {

        val todo = Todo(
            title = request.title,
            description = request.description,
            name = request.name,
        )
        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {

        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo",todoId)
        todo.title = request.title
        todo.description = request.description
        todo.name = request.name

        return todoRepository.save(todo).toResponse()
    }

    override fun changeTodoStatus(todoId: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        todo.status = !todo.status
        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo",todoId)
        todoRepository.delete(todo)
    }
}