package br.com.jaquesprojetos.forum.model

import java.time.LocalDate

data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val dateCreate: LocalDate = LocalDate.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val responses: List<Response> = ArrayList()
)