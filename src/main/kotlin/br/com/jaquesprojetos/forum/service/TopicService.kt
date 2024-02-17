package br.com.jaquesprojetos.forum.service

import br.com.jaquesprojetos.forum.model.Course
import br.com.jaquesprojetos.forum.model.Topic
import br.com.jaquesprojetos.forum.model.User
import org.springframework.stereotype.Service
import java.util.*


@Service
class TopicService(private var topics: List<Topic>) {
    init {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin 1",
            message = "Variaveis",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Jaques",
                email = "leonardo@jaquesprojetos.com.br"
            ),
        )
        val topic2 = Topic(
            id = 2,
            title = "Duvida Kotlin 2",
            message = "Variaveis",
            course = Course(
                id = 2,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 2,
                name = "Jaques",
                email = "leonardo@jaquesprojetos.com.br"
            ),
        )
        val topic3 = Topic(
            id = 3,
            title = "Duvida Kotlin 3",
            message = "Variaveis",
            course = Course(
                id = 3,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 3,
                name = "Jaques",
                email = "leonardo@jaquesprojetos.com.br"
            ),
        )
        this.topics = Arrays.asList(topic, topic2, topic3)
    }

    fun list(): List<Topic> {
        return topics
    }

    fun getTopic(id: Long): Topic {
        return topics.stream().filter { it.id == id }.findFirst().get()
    }
}

