package br.com.jaquesprojetos.forum.dto

import java.time.LocalDateTime

data class AnswersView(
    var id: Long? = null,
    val message: String,
    val dateCreated: LocalDateTime,
    val solution: Boolean
)