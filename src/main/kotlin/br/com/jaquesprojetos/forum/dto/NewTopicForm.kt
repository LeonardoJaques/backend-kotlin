package br.com.jaquesprojetos.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm(
    @field:NotEmpty @field:Size(min = 5, max = 100, message = "The title should have between 5 and 100")
    val title: String,
    @field:NotEmpty val message: String,
    @field:NotNull val courseId: Long,
    @field:NotNull val authorId: Long
)
