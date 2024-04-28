package specialities;

import interfaces.Speciality;
import student.StudentImpl;
import student.StudentRepository;
import student.discipline.Discipline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class SpecialityKind extends Course implements Speciality {

    private List<Discipline> disciplines;

    public SpecialityKind() {
        disciplines = new ArrayList<>();
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines.addAll(disciplines);
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setGrades(StudentImpl student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set student grades for the current course: ");
        for (Discipline discipline : getDisciplines()) {
            System.out.print(discipline.getName() + " grade - ");
            try {
                int grade = Integer.parseInt(scanner.nextLine());
                try {
                    discipline.setEarnedGrade(grade);
                    // Add discipline with grade to the student
                    student.addDiscipline(discipline);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    setGrades(student);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                setGrades(student);
            }
        }
    }

    public void setGrades() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set student grades for the current course: ");
        for (Discipline discipline : getDisciplines()) {
            System.out.print(discipline.getName() + " grade - ");
            try {
                int grade = Integer.parseInt(scanner.nextLine());
                try {
                    discipline.setEarnedGrade(grade);
                    //todo
                    //parameter -> student.addDiscipline(student);
                    //vmomenta ne se dobavqt kum lista na konkretniq student disciplinite i ne moje da se proveri dali sa vzeti ili ne
                    //za celta dobavi parametur
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    setGrades();
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                setGrades();
            }
        }
    }
}
