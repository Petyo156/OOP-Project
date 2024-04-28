package interfaces;

import specialities.Course;
import student.discipline.Discipline;
import student.implementation.Group;
import student.implementation.Status;

import java.util.List;

public interface Student {
    void addGrade(String disciplineName);
    void addDiscipline(String disciplineName);
    void printProtocols();
    void printStats();
    String getFakNumber();
    void setCourse(Course course);
    Course getCourse();
    List<Discipline> getDisciplines();
    Group getGroup();
    void setGroup(Group group);
    void setStatus(Status status);
    Status getStatus();
    void setGrades(Student student);
}
