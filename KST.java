package specialities.kst;

import specialities.SpecialityKind;
import student.AllStudents;
import student.StudentRepository;

import static student.AllStudents.addStudentRepository;

public class KST extends SpecialityKind {
    public static StudentRepository studentRepository1 = new StudentRepository();
    public static StudentRepository studentRepository2 = new StudentRepository();
    public static StudentRepository studentRepository3 = new StudentRepository();
    public static StudentRepository studentRepository4 = new StudentRepository();

    static{
        addStudentRepository(studentRepository1);
        addStudentRepository(studentRepository2);
        addStudentRepository(studentRepository3);
        addStudentRepository(studentRepository4);
    }
}
