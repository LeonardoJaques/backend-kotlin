package br.com.jaquesprojetos.forum.controller

import br.com.jaquesprojetos.forum.model.Response
import br.com.jaquesprojetos.forum.service.ResponseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic/responses")
class ResponsesController(private val service: ResponseService) {
    @GetMapping
    fun list(): List<Response> {
        return service.list()
    }

    @GetMapping("/{id}", produces = ["application/json"])
    fun getResponse(@PathVariable id: Long): Response {
        return service.getResponse(id)
    }

}