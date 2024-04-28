package commands.logic;

import interfaces.Student;
import specialities.Course;
import specialities.SpecialityKind;
import specialities.kst.FirstCourse;
import specialities.kst.FourthCourse;
import specialities.kst.KST;
import specialities.kst.ThirdCourse;
import specialities.sit.SIT;
import specialities.sit.SecondCourse;
import student.AllStudents;
import student.StudentRepository;
import student.discipline.Discipline;
import student.implementation.Group;

import java.util.ArrayList;
import java.util.List;

public class Change extends CommandsManager {
    @Override
    public void execute(String command) {
        String[] arr = command.toLowerCase().split(" ");

        if (arr.length < 4) {
            System.out.println("Enter valid number of arguments!");
            return;
        }

        String fn = arr[1];
        String option = arr[2];
        String value = arr[3];

        if (isInterrupted(fn)) {
            System.out.println("Student " + fn + " is interrupted.");
            return;
        }

        Student student = findByFakNum(fn);
        if (null == student) {
            System.out.println("There is no student with FN " + fn + ".");
            return;
        }

        switch (option) {
            case "program":
                List<Discipline> studentDisciplines = student.getDisciplines();
                SpecialityKind course;
                switch (value) {
                    case "sit" -> {
                        course = new SIT();
                        changeProgram(course, student, studentDisciplines);
                    }
                    case "kst" -> {
                        course = new KST();
                        changeProgram(course, student, studentDisciplines);
                    }
                    default -> {
                        System.out.println("Invalid program.");
                        return;
                    }
                }
                System.out.println("Program changed to " + value.toUpperCase() + " successfully!");
                break;
            case "group":
                switch (value) {
                    case "1a" -> findByFakNum(fn).setGroup(Group.GROUP1A);
                    case "1b" -> findByFakNum(fn).setGroup(Group.GROUP1B);
                    case "2a" -> findByFakNum(fn).setGroup(Group.GROUP2A);
                    case "2b" -> findByFakNum(fn).setGroup(Group.GROUP2B);
                    case "3a" -> findByFakNum(fn).setGroup(Group.GROUP3A);
                    case "3b" -> findByFakNum(fn).setGroup(Group.GROUP3B);
                    default -> {
                        System.out.println("Invalid group.");
                        return;
                    }
                }
                System.out.println("Group set successfully!");
                break;
            case "year":
                // enroll 22621624 sit 2b petar
                //change 22621624 year secondcourse
                Advance advance = new Advance();

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
                            + String.join(", ", disciplinesWithLowScore) + " and can't be advanced.");
                    return;
                }

                String currentCourseSimpleName = student.getCourse().getClass().getSimpleName();
                boolean shouldAdvance;

                switch (value) {
                    case "secondcourse" -> shouldAdvance = currentCourseSimpleName.equals("FirstCourse");
                    case "thirdcourse" -> shouldAdvance = currentCourseSimpleName.equals("SecondCourse");
                    case "fourthcourse" -> shouldAdvance = currentCourseSimpleName.equals("ThirdCourse");
                    default -> {
                        System.out.println("Invalid course.");
                        return;
                    }
                }

                if (shouldAdvance) {
                    advance.execute("advance " + student.getFakNumber());
                } else {
                    System.out.println("You can't change student's course to " + value + ".");
                }
                break;
            default:
                System.out.println("Invalid option parameter.");
        }
    }

    /*
        private void changeProgram(SpecialityKind course, Student student) {
        // Check if the student has passed all mandatory subjects from previous courses
        boolean canTransfer = canTransferToNextCourse(student);

        if (canTransfer) {
            // Set the course for the student
            student.setCourse((Course) course);

            // Set grades for the new program
            course.setGrades(student);

            System.out.println("Student transferred to the next course successfully!");
        } else {
            System.out.println("Student cannot be transferred to new program due to incomplete subjects.");
        }
    }

    private boolean canTransferToNextCourse(Student student) {
        int failedCoursesCount = 0;

        // Count the number of failed courses
        for (Discipline d : student.getDisciplines()) {
            if (d.getEarnedGrade() == 2) { // Assuming grade of 2 means failure
                failedCoursesCount++;
            }
        }

        // Check if the number of failed courses exceeds the maximum allowance
        return failedCoursesCount <= 2;
    }

    */
    //FOR CHANGE PROGRAM
    private void changeProgram(SpecialityKind course, Student student, List<Discipline> studentDisciplines) {
        int sum = 0;
        for (Discipline d : course.getDisciplines()) {
            for (Discipline sd : studentDisciplines) {
                if (d.equals(sd) && sd.getEarnedGrade() > 2) {
                    sum++;
                }
            }
        }
        if (sum == 3) {
            String courseName = student.getCourse().getClass().getSimpleName();

            String programName = student.getCourse().getClass().getPackageName();

            //MOJE DA NE RABOTI
            String[] arr = programName.split("\\.");
            programName = arr[arr.length - 2];

            switch (programName) {
                case "kst" -> courseSetterKST(courseName, student);
                case "sit" -> courseSetterSIT(courseName, student);
            }
        }
    }

    private void courseSetterKST(String courseName, Student student) {
        Course course = switch (courseName) {
            case "FirstCourse" -> new specialities.kst.FirstCourse();
            case "SecondCourse" -> new specialities.kst.SecondCourse();
            case "ThirdCourse" -> new specialities.kst.ThirdCourse();
            case "FourthCourse" -> new specialities.kst.FourthCourse();
            default -> null;
        };
        student.setCourse(course);
    }

    private void courseSetterSIT(String courseName, Student student) {
        Course course = switch (courseName) {
            case "FirstCourse" -> new specialities.sit.FirstCourse();
            case "SecondCourse" -> new specialities.sit.SecondCourse();
            case "ThirdCourse" -> new specialities.sit.ThirdCourse();
            case "FourthCourse" -> new specialities.sit.FourthCourse();
            default -> null;
        };
        student.setCourse(course);
    }

    //---------------------------------------------------------------------
}
