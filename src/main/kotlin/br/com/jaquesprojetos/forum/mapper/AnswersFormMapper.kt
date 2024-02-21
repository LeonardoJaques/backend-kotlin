package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.NewAnswersForm
import br.com.jaquesprojetos.forum.model.Answer
import br.com.jaquesprojetos.forum.service.TopicService
import br.com.jaquesprojetos.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class AnswersFormMapper(
    private val usersService: UserService,
    private val topicService: TopicService

) : Mapper<NewAnswersForm, Answer> {
    override fun map(t: NewAnswersForm): Answer {
        return Answer(
            message = t.message,
            author = usersService.getUser(t.authorId),
            topic = topicService.getTopic(t.topicId),
            solution = t.solution
        )
    }

}