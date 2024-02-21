package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.NewAnswersForm
import br.com.jaquesprojetos.forum.model.Answers
import br.com.jaquesprojetos.forum.service.TopicService
import br.com.jaquesprojetos.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class AnswersFormMapper(
    private val usersService: UserService,
    private val topicService: TopicService

) : Mapper<NewAnswersForm, Answers> {
    override fun map(t: NewAnswersForm): Answers {
        return Answers(
            message = t.message,
            author = usersService.getUser(t.authorId),
            topic = topicService.getTopic(t.topicId),
            solution = t.solution
        )
    }

}