package com.teamsparta.todolist.domain.todo.service

import com.teamsparta.todolist.domain.todo.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import com.teamsparta.todolist.domain.todo.dto.UpdateTodoRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl : TodoService {
    override fun getAllTodoList(): List<TodoResponse> {
        // TODO : DB에서 모든 Todo 목록을 조회하여 TodoResponse 목록으로 변환 후 반환
        TODO("Not yet implemented")
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        // TODO: 만약 todoId에 해당하는 todo card가 없다면 throw ModelNotFoundException
        // TODO : DB에서 Todo를 ID 기반으로 조회하여 TodoResponse로 변환 후 반환
        TODO("Not yet implemented")
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        // TODO: 만약 title이나 name을 미입력 한 경우 throw CheckedException
        // if(request.title == "") throw RequestBodyEmptyException("title")
        // if(request.name == "") throw RequestBodyEmptyException("name")
        // TODO : request를 Todo로 변환한 후 DB에 저장
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        // TODO: 만약 todoId에 해당하는 todo card가 없다면 throw ModelNotFoundException
        // TODO : DB에서 todoId에 해당하는 todo card를 가져와 request 기반으로 update 후 DB에 저장, 결과를 TodoResponse로 변환 후 반환
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        // TODO: 만약 todoId에 해당하는 todo card가 없다면 throw ModelNotFoundException
        // TODO : DB에서 todoId에 해당하는 todo card를 삭제
        TODO("Not yet implemented")
    }
}