package com.teamsparta.todolist.domain.post.exception

import com.teamsparta.todolist.domain.post.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(e.bindingResult.allErrors[0].defaultMessage))
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