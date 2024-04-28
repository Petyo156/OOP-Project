package specialities.sit;

import interfaces.Speciality;
import interfaces.Student;
import specialities.Course;
import student.StudentImpl;
import student.discipline.Discipline;
import student.discipline.mandatory.English;
import student.discipline.mandatory.OK;
import student.discipline.mandatory.OOP;
import student.implementation.Group;
import student.implementation.Status;

import java.util.List;

public class FirstCourse extends SIT {
    public static final List<Discipline> SIT_DISCIPLINES_1 = List.of(new English(), new OK(), new OOP());

    public FirstCourse() {
        super.setDisciplines(SIT_DISCIPLINES_1);
        //setGrades(returnStudent());
    }

    //Student student = new StudentImpl(
     //       name, fakNumber, course, speciality, group, Status.ENROLLED);

    public static StudentImpl returnStudent(String name, String fn, Group group, Status status){
        return new StudentImpl(name, fn, new FirstCourse(), new SIT(), group, status);
    }
}
