package br.com.jaquesprojetos.forum.service

import br.com.jaquesprojetos.forum.dto.NewTopicForm
import br.com.jaquesprojetos.forum.dto.TopicView
import br.com.jaquesprojetos.forum.dto.UpdateTopicForm
import br.com.jaquesprojetos.forum.exception.NotFoundException
import br.com.jaquesprojetos.forum.mapper.TopicFormMapper
import br.com.jaquesprojetos.forum.mapper.TopicViewMapper
import br.com.jaquesprojetos.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {


    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getTopic(id: Long? = null): TopicView {
        val topic = topics.stream()
            .filter { it.id == id }
            .findFirst()
            .orElseThrow { NotFoundException("Topic not found") }
        return topicViewMapper.map(topic)
    }

    fun createTopic(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopic(form: UpdateTopicForm): TopicView {
        val topic = topics.stream()
            .filter { it.id == form.id }
            .findFirst()
            .orElseThrow { NotFoundException("Topic not found") }
        topic.title = form.title
        topic.message = form.message
        return topicViewMapper.map(topic)

    }

    fun deleteTopic(id: Long): TopicView {
        val topic = topics.stream()
            .filter { it.id == id }
            .findFirst()
            .orElseThrow { NotFoundException("Topic not found") }
        topics = topics.minus(topic)
        return topicViewMapper.map(topic)

    }
}

