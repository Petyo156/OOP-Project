package student;

import interfaces.Student;
import specialities.Course;
import specialities.SpecialityKind;
import student.discipline.*;
import student.discipline.mandatory.English;
import student.discipline.mandatory.OK;
import student.discipline.mandatory.OOP;
import student.discipline.mandatory.WEBDesign;
import student.implementation.Group;
import student.implementation.Status;

import java.util.*;

public class StudentImpl implements Student {
    private List<Discipline> disciplineList;

    private String name;
    private String fakNumber;


    private Course course;
    private SpecialityKind speciality;
    private Group group;
    private Status status;


    private double avgScore;

    public StudentImpl(String name, String fakNumber,
                       Course courseStudent, SpecialityKind speciality, Group group, Status status) {
        this.disciplineList = new ArrayList<>();

        this.name = name;
        this.fakNumber = fakNumber;

        this.avgScore = 0;
        this.course = courseStudent;
        this.speciality = speciality;
        this.group = group;
        this.status = status;
    }

    //todo
    private double calculateAvgScore() {
        double allScore = this.disciplineList.stream().mapToDouble(Discipline::getEarnedGrade).sum();
        return allScore / disciplineList.size();
    }

    @Override
    public void addGrade(String disciplineName) {
        Discipline discipline = findByName(disciplineName);
        if (discipline != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter grade for " + disciplineName + ": ");
            int grade = scanner.nextInt();
            if (grade >= 2 && grade <= 6) {
                discipline.setEarnedGrade(grade);
                System.out.println("Grade for " + disciplineName + " added successfully.");
            } else {
                System.out.println("Invalid grade. Grade should be between 2 and 6.");
            }
        } else {
            System.out.println("Discipline not found.");
        }
    }

    private Discipline findByName(String disciplineName) {
        for (Discipline discipline : disciplineList) {
            if (discipline.getClass().getSimpleName().equalsIgnoreCase(disciplineName)) {
                return discipline;
            }
        }
        return null;
    }

    @Override
    public void addDiscipline(String disciplineName) {
        Discipline discipline = null;
        switch (disciplineName.toLowerCase()) {
            case "english":
                discipline = new English();
                break;
            case "ok":
                discipline = new OK();
                break;
            case "oop":
                discipline = new OOP();
                break;
            case "webdesign":
                discipline = new WEBDesign();
                break;
        }
        if (null == discipline) {
            System.out.println("Discipline does not exist.");
            return;
        }
        this.disciplineList.add(discipline);
    }

    public void addDiscipline(Discipline discipline) {
        this.disciplineList.add(discipline);
    }

    @Override
    public void printProtocols() {

    }

    @Override
    public void printStats() {

    }

    @Override
    public String getFakNumber() {
        return fakNumber;
    }

    @Override
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public Course getCourse() {
        return this.course;
    }

    @Override
    public List<Discipline> getDisciplines() {
        return this.disciplineList;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public void setGrades(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set student grades for the current course: ");
        for (Discipline discipline : getDisciplines()) {
            System.out.print(discipline.getName() + " grade - ");
            try {
                int grade = Integer.parseInt(scanner.nextLine());
                try {
                    discipline.setEarnedGrade(grade);
                    // Add discipline with grade to the student
                    student.addDiscipline(discipline.getName());
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
//enroll 22621624 SIT 2B Petar

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "StudentImpl{" +
                "disciplineList =" + disciplineList.toString() +
                ", name='" + name + '\'' +
                ", fakNumber='" + fakNumber + '\'' +
                ", course=" + course +
                ", speciality=" + speciality +
                ", group=" + group +
                ", status=" + status +
                ", avgScore=" + avgScore +
                '}';
    }
}
