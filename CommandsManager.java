package commands.logic;

import interfaces.MenuItem;
import interfaces.Repository;
import interfaces.Student;
import student.AllStudents;
import student.discipline.Discipline;
import student.implementation.Status;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandsManager implements MenuItem {
    @Override
    public void execute() {

    }

    @Override
    public void execute(String command) {

    }

    public Student findByFakNum(String fn) {
        List<Student> studentList = AllStudents.getAllStudents();
        return studentList.stream()
                .filter(student1 -> student1.getFakNumber().equals(fn))
                .findFirst()
                .orElse(null);
    }

    public boolean checkIfGoodScore(Student student){
        boolean canBeAdvanced = true;
        List<String> disciplinesWithLowScore = new ArrayList<>();
        for (Discipline d : student.getDisciplines()) {
            if (d.getEarnedGrade() == 2) {
                disciplinesWithLowScore.add(d.getName());
                canBeAdvanced = false;
            }
        }
        if (!canBeAdvanced) {
            System.out.println("Student " + student.getFakNumber() + " has not succeeded in "
                    + String.join(", ", disciplinesWithLowScore) + " and graduate.");
            return false;
        }
        return true;
    }

    public boolean isInterrupted(String fn){
        if(checkIfStudentIsNull(fn)){
            System.out.println("No student " + fn + " found.");
            return false;
        } else {
            return findByFakNum(fn).getStatus().equals(Status.INTERRUPTED);
        }
    }

    public boolean checkIfStudentIsNull(String fakNum){
        if(findByFakNum(fakNum) == null){
            return true;
        }
        return false;
    }
}
