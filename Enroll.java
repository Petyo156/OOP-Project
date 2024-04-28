package commands.logic;

import interfaces.Student;
import menu.Menu;
import specialities.Course;
import specialities.SpecialityKind;
import student.implementation.Group;
import student.implementation.Status;
import student.StudentImpl;
import specialities.kst.KST;
import specialities.sit.SIT;

public class Enroll extends CommandsManager {
    @Override
    public void execute(String command) {
        String[] arr = command.split(" ");
        if(arr.length<5){
            System.out.println("Enter valid number of arguments!");
            return;
        }

        String name = arr[4];

        arr = command.toLowerCase().split(" ");
        String fakNumber = arr[1];

        Group group;
        switch (arr[3]) {
            case "1a" -> group = Group.GROUP1A;
            case "1b" -> group = Group.GROUP1B;
            case "2a" -> group = Group.GROUP2A;
            case "2b" -> group = Group.GROUP2B;
            case "3a" -> group = Group.GROUP3A;
            case "3b" -> group = Group.GROUP3B;
            default -> {
                System.out.println("Invalid group! Failed to add student.");
                return;
            }
        }

        SpecialityKind speciality;
        Course course;
        switch (arr[2]) {
            case "sit" -> {
                speciality = new SIT();
                course = new specialities.sit.FirstCourse();
            }
            case "kst" -> {
                speciality = new KST();
                course = new specialities.kst.FirstCourse();
            }
            default -> {
                System.out.println("Invalid speciality! Failed to add student.");
                return;
            }
        }

        Student student = new StudentImpl(
                name, fakNumber, course, speciality, group, Status.ENROLLED);

        switch (arr[2]){
            case "sit" -> SIT.studentRepository1.add(student);
            case "kst" -> KST.studentRepository1.add(student);
        }

        System.out.println("Student added successfully to FirstCourse!");
    }
}