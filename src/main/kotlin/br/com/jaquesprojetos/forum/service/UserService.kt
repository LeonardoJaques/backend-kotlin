package br.com.jaquesprojetos.forum.service

import br.com.jaquesprojetos.forum.model.User
import org.springframework.stereotype.Service

@Service
data class UserService(final var users: List<User> = listOf()) {
    init {
        val user = User(
            id = 1,
            name = "Jaqueline",
            email = "jaqueline@email.com"
        )
        val user2 = User(
            id = 2,
            name = "João",
            email = "joao@email.com"
        )
        val user3 = User(
            id = 3,
            name = "Maria",
            email = "maria@email.com"
        )
        users = listOf(user, user2, user3)
    }

    fun list(): List<User> {
        return users
    }

    fun getUser(id: Long? = null): User {
        return users.stream().filter { it.id == id }.findFirst().get()
    }
}

