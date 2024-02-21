package br.com.jaquesprojetos.forum.controller

import br.com.jaquesprojetos.forum.dto.NewTopicForm
import br.com.jaquesprojetos.forum.dto.TopicView
import br.com.jaquesprojetos.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

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
    fun createTopic(@RequestBody @Valid dto: NewTopicForm) {
        service.createTopic(dto)
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }
}