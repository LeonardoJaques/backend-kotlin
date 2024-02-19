package br.com.jaquesprojetos.forum.controller

import br.com.jaquesprojetos.forum.dto.ResponseView
import br.com.jaquesprojetos.forum.dto.newResponseForm
import br.com.jaquesprojetos.forum.service.ResponseService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic/responses")
class ResponsesController(private val service: ResponseService) {
    @GetMapping
    fun list(): List<ResponseView> {
        return service.list()
    }

    @GetMapping("/{id}", produces = ["application/json"])
    fun getResponse(@PathVariable id: Long): ResponseView {
        return service.getResponse(id)
    }

    @PostMapping
    fun createResponse(@RequestBody @Valid dto: newResponseForm): Unit {
        service.createResponse(dto)
    }

}