package br.com.jaquesprojetos.forum.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    var title: String,
    var message: String,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val answer: List<Answer> = ArrayList()
)