package com.teamsparta.todolist.domain.todo.model

import com.teamsparta.todolist.domain.todo.dto.CommentResponse
import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import jakarta.persistence.*
import java.time.format.DateTimeFormatter

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
}

fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        id = id!!,
        todo = todo.toResponse(),
        commentWriter = commentWriter,
        comment = comment
    )
}