package com.teamsparta.todolist.domain.post.model

import com.teamsparta.todolist.domain.post.dto.todo.TodoResponse
import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity
@Table(name = "todo")
class Todo(
    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "date")
    val date: LocalDateTime = LocalDateTime.now(),

    @Column(name = "name")
    var name: String,

    @Column(name = "status")
    var status: Boolean = false,

    @OneToMany(mappedBy = "todo", cascade = [(CascadeType.ALL)], orphanRemoval = true, fetch = FetchType.LAZY)
    val comments: MutableList<Comment> = mutableListOf(),
    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun addComment(comment: Comment) {
        comments.add(comment)
    }
}

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        description = description,
        date = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
        name = name,
        status = status,
        comments = comments.map { it.toResponse() }
    )
}