package br.com.jaquesprojetos.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewAnswersForm(
    @field:NotEmpty @field:Size(min = 5, max = 100) val message: String,
    @field:NotNull val topicId: Long,
    @field:NotNull val authorId: Long,
    @field:NotNull val solution: Boolean
)

