package br.com.jaquesprojetos.forum.model

import br.com.jaquesprojetos.forum.dto.TopicView
import java.time.LocalDateTime

data class Response(
    var id: Long? = null,
    val message: String,
    val author: User,
    val dateCreate: LocalDateTime = LocalDateTime.now(),
    val topic: TopicView,
    val solution: Boolean
)
