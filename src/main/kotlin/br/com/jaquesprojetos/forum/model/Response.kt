package br.com.jaquesprojetos.forum.model

import java.time.LocalDate

data class Response(
    val id: Long? = null,
    val message: String,
    val author: User,
    val dateCreate: LocalDate = LocalDate.now(),
    val topic: Topic,
    val solution: Boolean
)
