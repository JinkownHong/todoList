package com.teamsparta.todolist.domain.todo.service

import com.teamsparta.todolist.domain.todo.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import com.teamsparta.todolist.domain.todo.dto.UpdateTodoRequest
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl: TodoService {
    override fun getAllTodoList(): List<TodoResponse> {
        // TODO : DB에서 모든 Todo 목록을 조회하여 TodoResponse 목록으로 변환 후 반환
        TODO("Not yet implemented")
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        // TODO : DB에서 Todo를 ID 기반으로 조회하여 TodoResponse로 변환 후 반환
        TODO("Not yet implemented")
    }

    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        // TODO : request를 Todo로 변환한 후 DB에 저장
        TODO("Not yet implemented")
    }

    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        // TODO : DB에서 todoId에 해당하는 todo card를 가져와 request 기반으로 update 후 DB에 저장, 결과를 TodoResponse로 변환 후 반환
        TODO("Not yet implemented")
    }

    override fun deleteTodo(todoId: Long) {
        // TODO : DB에서 todoId에 해당하는 todo card를 삭제
        TODO("Not yet implemented")
    }
}