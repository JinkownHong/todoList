package com.teamsparta.todolist.domain.post.model

import com.teamsparta.todolist.domain.post.dto.comment.CommentResponse
import com.teamsparta.todolist.domain.post.repository.TodoRepository
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment (
    @Column(name = "comment_writer")
    val commentWriter: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "comment")
    var comment: String,

    @ManyToOne
    @JoinColumn(name = "todo_id")
    val todo: Todo
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun isValidWriter(
        writer: String
    ):Boolean  {
     return writer == commentWriter
    }

    fun isValidPassword(
        pw: String
    ):Boolean  {
        return pw == password
    }
}

fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        id = id!!,
        commentWriter = commentWriter,
        comment = comment
    )
}