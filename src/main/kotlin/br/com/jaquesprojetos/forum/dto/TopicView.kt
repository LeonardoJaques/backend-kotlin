package br.com.jaquesprojetos.forum.dto

import br.com.jaquesprojetos.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long? = null,
    val title: String,
    val message: String,
    val dateCreated: LocalDateTime,
    val status: TopicStatus,
)
