package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.TopicView
import br.com.jaquesprojetos.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            dateCreated = t.dateCreated,
            status = t.status
        )
    }
}