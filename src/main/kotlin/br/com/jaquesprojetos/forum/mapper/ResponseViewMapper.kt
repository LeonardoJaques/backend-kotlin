package br.com.jaquesprojetos.forum.mapper

import br.com.jaquesprojetos.forum.dto.ResponseView
import br.com.jaquesprojetos.forum.model.Response
import org.springframework.stereotype.Component

@Component
class ResponseViewMapper : Mapper<Response, ResponseView> {
    override fun map(t: Response): ResponseView {
        return ResponseView(
            id = t.id,
            message = t.message,
            dateCreated = t.dateCreate,
            solution = t.solution,
        )
    }
}

