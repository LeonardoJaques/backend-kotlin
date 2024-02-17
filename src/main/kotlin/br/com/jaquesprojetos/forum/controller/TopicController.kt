package br.com.jaquesprojetos.forum.controller

import br.com.jaquesprojetos.forum.model.Topic
import br.com.jaquesprojetos.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic")
class TopicController(private val service: TopicService) {
    @GetMapping
    fun list(): List<Topic> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Long): Topic {
        return service.getTopic(id)
    }
}