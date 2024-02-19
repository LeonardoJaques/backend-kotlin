package br.com.jaquesprojetos.forum.service

import br.com.jaquesprojetos.forum.dto.ResponseView
import br.com.jaquesprojetos.forum.dto.newResponseForm
import br.com.jaquesprojetos.forum.mapper.ResponseFormMapper
import br.com.jaquesprojetos.forum.mapper.ResponseViewMapper
import br.com.jaquesprojetos.forum.model.Response
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ResponseService(
    private var responses: List<Response>,
    private val responseViewMapper: ResponseViewMapper,
    private val responseFormMapper: ResponseFormMapper
) {

    fun list(): List<ResponseView> {
        return responses.stream().map { t ->
            responseViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getResponse(id: Long): ResponseView {
        val response = responses.stream().filter { it.id == id }.findFirst().get()
        return responseViewMapper.map(response)
    }

    fun createResponse(form: newResponseForm): Unit {
        val response = responseFormMapper.map(form)
        response.id = responses.size.toLong() + 1
        responses = responses.plus(response)
    }
}