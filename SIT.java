package specialities.sit;

import specialities.SpecialityKind;
import student.AllStudents;
import student.StudentRepository;

import static student.AllStudents.addStudentRepository;

public class SIT extends SpecialityKind {
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
