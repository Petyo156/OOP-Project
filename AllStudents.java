package student;

import interfaces.Student;
import student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class AllStudents {
    public static List<StudentRepository> ALL_STUDENTS = new ArrayList<>();

    public static void addStudentRepository(StudentRepository studentRepository) {
        ALL_STUDENTS.add(studentRepository);
    }

    public static List<Student> allStudents = new ArrayList<>();

    //GET ALL STUDENTS
    public static List<Student> getAllStudents() {
        for (StudentRepository studentRepository : ALL_STUDENTS) {
            allStudents.addAll(studentRepository.getCollection());
        }
        return allStudents;
    }
}
