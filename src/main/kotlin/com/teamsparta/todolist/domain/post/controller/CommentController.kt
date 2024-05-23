package com.teamsparta.todolist.domain.post.controller

import com.teamsparta.todolist.domain.post.dto.comment.CommentResponse
import com.teamsparta.todolist.domain.post.dto.comment.CreateCommentRequest
import com.teamsparta.todolist.domain.post.dto.comment.DeleteCommentRequest
import com.teamsparta.todolist.domain.post.dto.comment.UpdateCommentRequest
import com.teamsparta.todolist.domain.post.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/todos/{todoId}")
@RestController
class CommentController(
    private val postService: PostService
) {
    @PostMapping
    fun createComment(
        @PathVariable todoId: Long, @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createComment(todoId, createCommentRequest))
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(
            postService.updateComment(
                todoId, commentId, updateCommentRequest
            )
        )
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable todoId: Long,
        @PathVariable commentId: Long,
        @RequestBody deleteCommentRequest: DeleteCommentRequest
    ): ResponseEntity<Unit> {
        postService.deleteComment(todoId, commentId, deleteCommentRequest)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}