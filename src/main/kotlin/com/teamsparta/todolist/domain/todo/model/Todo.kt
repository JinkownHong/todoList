package com.teamsparta.todolist.domain.todo.model

import jakarta.persistence.*

@Entity
@Table(name = "todo")
class Todo(
    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    val status: TodoStatus,


    @Column(name = "date")
    val date: String,

    @Column(name = "name")
    val name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}