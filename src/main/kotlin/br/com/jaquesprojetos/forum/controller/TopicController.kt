package br.com.jaquesprojetos.forum.controller

import br.com.jaquesprojetos.forum.dto.NewTopicForm
import br.com.jaquesprojetos.forum.dto.TopicView
import br.com.jaquesprojetos.forum.dto.UpdateTopicForm
import br.com.jaquesprojetos.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topic")
class TopicController(private val service: TopicService) {
    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Long): TopicView {
        return service.getTopic(id)
    }

    @PostMapping
    fun createTopic(
        @RequestBody @Valid dto: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.createTopic(dto)
        val uri = uriBuilder.path("/topic/{id}").buildAndExpand(topicView.id).toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid form: UpdateTopicForm): TopicView {
        return service.updateTopic(form)
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }
}