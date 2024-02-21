package br.com.jaquesprojetos.forum.service

import br.com.jaquesprojetos.forum.exception.NotFoundException
import br.com.jaquesprojetos.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course> = listOf()) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programming"
        )
        val course2 = Course(
            id = 2,
            name = "Java",
            category = "Programming"
        )
        val course3 = Course(
            id = 3,
            name = "Spring",
            category = "Framework"
        )

        courses = listOf(course, course2, course3)
    }

    fun list(): List<Course> {
        return courses
    }

    fun getCourse(id: Long): Course {
        return courses.stream().filter { it.id == id }.findFirst().orElseThrow {
            NotFoundException("Course not found")
        }


    }

    fun createCourse(course: Course): Unit {
        courses.plus(course)
    }

    fun updateCourse(id: Long, course: Course) {
        val course = courses.stream().filter { it.id == id }.findFirst().orElseThrow {
            NotFoundException("Course not found")
        }
        course.name = course.name
        course.category = course.category

    }

    fun deleteCourse(id: Long) {
        val course = courses.stream().filter { it.id == id }.findFirst().orElseThrow {
            NotFoundException("Course not found")
        }
        courses.minus(course)
    }
}
