package br.com.jaquesprojetos.forum.service

import br.com.jaquesprojetos.forum.model.Course
import br.com.jaquesprojetos.forum.model.Response
import br.com.jaquesprojetos.forum.model.Topic
import br.com.jaquesprojetos.forum.model.User
import org.springframework.stereotype.Service

@Service
class ResponseService(private var responses: List<Response>) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programacao"
        )
        val author = User(
            id = 1,
            name = "Ana da Silva",
            email = "ana@email.com"
        )
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            course = course,
            author = author
        )

        val responseA = Response(
            id = 1,
            message = "Resposta 1",
            author = author,
            topic = topic,
            solution = false
        )

        val responseB = Response(
            id = 2,
            message = "Resposta 2",
            author = author,
            topic = topic,
            solution = false
        )


        responses = listOf(responseA, responseB)
    }

    fun list(): List<Response> {
        return responses
    }

    fun getResponse(id: Long): Response {
        return responses.stream().filter { it.id == id }.findFirst().get()
    }
}