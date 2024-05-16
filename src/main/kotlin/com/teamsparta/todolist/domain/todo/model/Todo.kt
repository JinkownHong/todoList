package com.teamsparta.todolist.domain.todo.model

import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "todo")
class Todo(
    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "date")
    val date: Date,

    @Column(name = "name")
    var name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        description = description,
        date = date,
        name = name
    )
}