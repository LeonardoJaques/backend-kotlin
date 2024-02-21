package br.com.jaquesprojetos.forum.controller

import br.com.jaquesprojetos.forum.dto.AnswersView
import br.com.jaquesprojetos.forum.dto.NewAnswersForm
import br.com.jaquesprojetos.forum.dto.UpdateAnswerForm
import br.com.jaquesprojetos.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topic/answers")
class AnswerController(private val service: AnswerService) {
    @GetMapping
    fun list(): List<AnswersView> {
        return service.list()
    }

    @GetMapping("/{id}", produces = ["application/json"])
    fun getAnswer(@PathVariable id: Long): AnswersView {
        return service.getAnswers(id)
    }

    @PostMapping
    fun createAnswer(
        @RequestBody @Valid dto: NewAnswersForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AnswersView> {
        val answerView = service.createAnswers(dto)
        val uri = uriBuilder.path("/topic/answers/{id}").buildAndExpand(answerView.id).toUri()
        return ResponseEntity.created(uri).body(answerView)
    }

    @PutMapping
    fun updateAnswer(@RequestBody @Valid form: UpdateAnswerForm): AnswersView {
        return service.updateAnswers(form)
    }

    @DeleteMapping("/{id}")
    fun deleteAnswers(@PathVariable id: Long): Unit {
        service.deleteAnswers(id)
    }

}