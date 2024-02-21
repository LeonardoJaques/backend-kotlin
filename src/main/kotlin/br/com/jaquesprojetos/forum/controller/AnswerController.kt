package br.com.jaquesprojetos.forum.controller

import br.com.jaquesprojetos.forum.dto.AnswersView
import br.com.jaquesprojetos.forum.dto.NewAnswersForm
import br.com.jaquesprojetos.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic/answers")
class AnswerController(private val service: AnswerService) {
    @GetMapping
    fun list(): List<AnswersView> {
        return service.list()
    }

    @GetMapping("/{id}", produces = ["application/json"])
    fun getResponse(@PathVariable id: Long): AnswersView {
        return service.getResponse(id)
    }

    @PostMapping
    fun createResponse(@RequestBody @Valid dto: NewAnswersForm): Unit {
        service.createResponse(dto)
    }

    @DeleteMapping("/{id}")
    fun deleteAnswers(@PathVariable id: Long): Unit {
        service.deleteAnswers(id)
    }

}