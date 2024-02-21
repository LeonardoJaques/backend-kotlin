package br.com.jaquesprojetos.forum.model

import br.com.jaquesprojetos.forum.dto.TopicView
import java.time.LocalDateTime

data class Answers(
    var id: Long? = null,
    var message: String,
    val author: User,
    val dateCreate: LocalDateTime = LocalDateTime.now(),
    val topic: TopicView,
    var solution: Boolean
)
