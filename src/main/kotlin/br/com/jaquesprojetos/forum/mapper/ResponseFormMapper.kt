package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.newResponseForm
import br.com.jaquesprojetos.forum.model.Response
import br.com.jaquesprojetos.forum.service.TopicService
import br.com.jaquesprojetos.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class ResponseFormMapper(
    private val usersService: UserService,
    private val topicService: TopicService

) : Mapper<newResponseForm, Response> {
    override fun map(t: newResponseForm): Response {
        return Response(
            message = t.message,
            author = usersService.getUser(t.authorId),
            topic = topicService.getTopic(t.topicId),
            solution = t.solution
        )
    }

}