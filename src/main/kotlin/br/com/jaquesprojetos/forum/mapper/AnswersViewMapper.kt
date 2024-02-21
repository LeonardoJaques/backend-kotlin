package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.AnswersView
import br.com.jaquesprojetos.forum.model.Answer
import org.springframework.stereotype.Component

@Component
class AnswersViewMapper : Mapper<Answer, AnswersView> {
    override fun map(t: Answer): AnswersView {
        return AnswersView(
            id = t.id,
            message = t.message,
            dateCreated = t.dateCreate,
            solution = t.solution,
        )
    }
}

