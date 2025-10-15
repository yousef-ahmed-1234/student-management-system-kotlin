data class Student(val name: String, val age: Int, val grade: Double)

class StudentManager {
    private val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
        println("${student.name} added successfully.")
    }

    fun removeStudent(name: String) {
        val removed = students.removeIf { it.name.equals(name, ignoreCase = true) }
        if (removed) {
            println("$name removed successfully.")
        } else {
            println("Student not found.")
        }
    }

    fun listStudents() {
        if (students.isEmpty()) {
            println("No students found.")
        } else {
            println("All Students:")
            for (s in students) {
                println("${s.name}, Age: ${s.age}, Grade: ${s.grade}")
            }
        }
    }

    fun topStudent() {
        if (students.isEmpty()) {
            println("No students to evaluate.")
        } else {
            val top = students.maxByOrNull { it.grade }
            println("Top student: ${top?.name} with grade ${top?.grade}")
        }
    }

    fun averageGrade() {
        if (students.isEmpty()) {
            println("No students to calculate average.")
        } else {
            val avg = students.map { it.grade }.average()
            println("Average grade: $avg")
        }
    }
}

fun main() {
    val manager = StudentManager()

    manager.addStudent(Student("Sara", 20, 92))
    manager.addStudent(Student("Ali", 22, 85))
    manager.addStudent(Student("Mona", 19, 87))

    manager.listStudents()
    manager.topStudent()
    manager.averageGrade()

    manager.removeStudent("Ali")
    manager.listStudents()
}
