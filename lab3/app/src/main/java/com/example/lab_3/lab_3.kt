package com.example.lab_3

class Student(var subjects: List<String?>) {
    fun isSessionReady(): Boolean {
        return subjects.isNotEmpty()
    }
}

fun main() {
    val student1 = Student(listOf("Math", "Physics", "Chemistry"))
    val student2 = Student(emptyList())

    println("Student 1 is ready: ${student1.isSessionReady()}")
    println("Student 2 is ready: ${student2.isSessionReady()}")
}