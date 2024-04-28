package commands.logic;

import interfaces.Student;
import specialities.Course;
import specialities.kst.FourthCourse;
import specialities.kst.KST;
import specialities.kst.SecondCourse;
import specialities.kst.ThirdCourse;
import specialities.sit.SIT;
import student.StudentRepository;

public class Advance extends CommandsManager {

    @Override
    public void execute(String command) {
        String[] arr = command.split(" ");
        if (arr.length < 2) {
            System.out.println("Enter a valid number of arguments!");
            return;
        }

        String fn = arr[1];

        if (isInterrupted(fn)) {
            System.out.println("Student " + fn + " is interrupted.");
            return;
        }
        boolean isFound = advanceStudentInSpeciality(SIT.studentRepository1, SIT.studentRepository2, fn);
        isFound = isFound || advanceStudentInSpeciality(SIT.studentRepository2, SIT.studentRepository3, fn);
        isFound = isFound || advanceStudentInSpeciality(SIT.studentRepository3, SIT.studentRepository4, fn);

        isFound = isFound || advanceStudentInSpeciality(KST.studentRepository1, KST.studentRepository2, fn);
        isFound = isFound || advanceStudentInSpeciality(KST.studentRepository2, KST.studentRepository3, fn);
        isFound = isFound || advanceStudentInSpeciality(KST.studentRepository3, KST.studentRepository4, fn);

        if (!isFound) {
            //System.out.println("Couldn't find student " + fn + ".");
        }
    }

    private boolean advanceStudentInSpeciality(StudentRepository from, StudentRepository to, String fakNum) {
        Student student = from.findByFakNum(fakNum);
        if (student != null) {
            from.remove(student);
            to.add(student);

            Course course = null;
            if (to.equals(SIT.studentRepository2)) {
                course = new specialities.sit.SecondCourse();
            } else if (to.equals(SIT.studentRepository3)) {
                course = new specialities.sit.ThirdCourse();
            } else if (to.equals(SIT.studentRepository4)) {
                course = new specialities.sit.FourthCourse();
            } else if (to.equals(KST.studentRepository2)) {
                course = new specialities.kst.SecondCourse();
            } else if (to.equals(KST.studentRepository3)) {
                course = new specialities.kst.ThirdCourse();
            } else if (to.equals(KST.studentRepository4)) {
                course = new specialities.kst.FourthCourse();
            }

            if (course != null) {
                student.setCourse(course);
                System.out.println("Successfully advanced student " + fakNum + " to " + course.getClass().getSimpleName() + "!");
                return true;
            }
        }
        return false;
    }
}


/*
import interfaces.Student;
import specialities.Course;
import specialities.kst.FourthCourse;
import specialities.kst.KST;
import specialities.kst.SecondCourse;
import specialities.kst.ThirdCourse;
import specialities.sit.SIT;
import student.StudentRepository;

public class Advance extends CommandsManager {
    private boolean isFound = false;

    final StudentRepository repositorySIT2 = SIT.studentRepository2;
    final StudentRepository repositorySIT3 = SIT.studentRepository3;
    final StudentRepository repositorySIT4 = SIT.studentRepository4;

    final StudentRepository repositoryKST2 = KST.studentRepository2;
    final StudentRepository repositoryKST3 = KST.studentRepository3;
    final StudentRepository repositoryKST4 = KST.studentRepository4;


    @Override
    public void execute(String command) {

        String[] arr = command.split(" ");
        if (arr.length < 2) {
            System.out.println("Enter valid number of arguments!");
            return;
        }

        String fakNum = arr[1];

        //SIT
        moveStudent(SIT.studentRepository1, SIT.studentRepository2, fakNum);
        moveStudent(SIT.studentRepository2, SIT.studentRepository3, fakNum);
        moveStudent(SIT.studentRepository3, SIT.studentRepository4, fakNum);

        //KST
        moveStudent(KST.studentRepository1, KST.studentRepository2, fakNum);
        moveStudent(KST.studentRepository2, KST.studentRepository3, fakNum);
        moveStudent(KST.studentRepository3, KST.studentRepository4, fakNum);

        if (!isFound) System.out.println("Couldn't find student " + fakNum + ".");
    }

    private void moveStudent(StudentRepository from, StudentRepository to, String fakNum) {
        if (isFound) {
            return;
        }
        Student student = from.findByFakNum(fakNum);
        if (null != student) {
            from.remove(student);
            to.add(student);

            //SIT
            Course course = null;
            if (to.equals(repositorySIT2)) {
                course = new specialities.sit.SecondCourse();
                student.setCourse(course);
            } else if (to.equals(repositorySIT3)) {
                course = new specialities.sit.ThirdCourse();
                student.setCourse(course);
            } else if (to.equals(repositorySIT4)) {
                course = new specialities.sit.FourthCourse();
                student.setCourse(course);
            }
            //KST
            else if (to.equals(repositoryKST2)) {
                course = new specialities.kst.SecondCourse();
                student.setCourse(course);
            } else if (to.equals(repositoryKST3)) {
                course = new specialities.kst.ThirdCourse();
                student.setCourse(course);
            } else if (to.equals(repositoryKST4)) {
                course = new specialities.kst.FourthCourse();
                student.setCourse(course);
            }

            String courseName = course.getClass().getSimpleName();
            System.out.println("Successfully advanced student " + fakNum + " to " + courseName + "!");
            isFound = true;
        }
    }
}

 */
