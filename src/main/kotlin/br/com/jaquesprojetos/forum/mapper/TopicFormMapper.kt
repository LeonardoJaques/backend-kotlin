package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.NewTopicForm
import br.com.jaquesprojetos.forum.model.Topic
import br.com.jaquesprojetos.forum.service.CourseService
import br.com.jaquesprojetos.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val coursesService: CourseService,
    private val usersService: UserService
) : Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = coursesService.getCourse(t.courseId),
            author = usersService.getUser(t.authorId)
        )
    }

}
