package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.AnswersView
import br.com.jaquesprojetos.forum.model.Answers
import org.springframework.stereotype.Component

@Component
class AnswersViewMapper : Mapper<Answers, AnswersView> {
    override fun map(t: Answers): AnswersView {
        return AnswersView(
            id = t.id,
            message = t.message,
            dateCreated = t.dateCreate,
            solution = t.solution,
        )
    }
}

