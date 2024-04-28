package student;

import interfaces.Repository;
import interfaces.Student;

import java.util.ArrayList;
import java.util.Collection;

public class StudentRepository implements Repository<Student> {
    private Collection<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public Collection<Student> getCollection() {
        return this.students;
    }

    @Override
    public void add(Student entity) {
        this.students.add(entity);
    }

    @Override
    public boolean remove(Student entity) {
        return this.students.remove(entity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }

    public Student findByFakNum(String fakNumber) {
        return students.stream().filter(student -> student.getFakNumber()
                .equals(fakNumber))
                .findFirst()
                .orElse(null);
    }
}
