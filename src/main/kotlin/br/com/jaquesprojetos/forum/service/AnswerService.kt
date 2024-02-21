package br.com.jaquesprojetos.forum.service

import br.com.jaquesprojetos.forum.dto.AnswersView
import br.com.jaquesprojetos.forum.dto.NewAnswersForm
import br.com.jaquesprojetos.forum.exception.NotFoundException
import br.com.jaquesprojetos.forum.mapper.AnswersFormMapper
import br.com.jaquesprojetos.forum.mapper.AnswersViewMapper
import br.com.jaquesprojetos.forum.model.Answer
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AnswerService(
    private var answers: List<Answer>,
    private val answersViewMapper: AnswersViewMapper,
    private val answersFormMapper: AnswersFormMapper
) {

    fun list(): List<AnswersView> {
        return answers.stream().map { t ->
            answersViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getResponse(id: Long): AnswersView {
        val response = answers.stream().filter { it.id == id }.findFirst().get()
        return answersViewMapper.map(response)
    }

    fun createResponse(form: NewAnswersForm): Unit {
        val answer = answersFormMapper.map(form)
        answer.id = answers.size.toLong() + 1
        answers = answers.plus(answer)
    }

    fun updateResponse(id: Long, form: NewAnswersForm) {
        val answer = answers.stream().filter { it.id == id }.findFirst().get()
        answer.message = form.message
    }

    fun deleteAnswers(id: Long) {
        val answer = answers.stream()
            .filter { it.id == id }
            .findFirst()
            .orElseThrow { NotFoundException("Topic not found") }
        answers = answers.minus(answer)
    }
}