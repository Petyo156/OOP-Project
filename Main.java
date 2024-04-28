import interfaces.Student;
import menu.Menu;
import specialities.kst.KST;
import specialities.sit.SIT;
import student.StudentRepository;
import student.discipline.Discipline;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        String choice;
        menu.showMenu();
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("exit")) {
                menu.executeOption(choice);
            }
        } while (!choice.equals("exit"));
        System.out.println("Exiting the program...");
        System.out.println(SIT.studentRepository1.getCollection());
        System.out.println(SIT.studentRepository2.getCollection());
        System.out.println(KST.studentRepository2.getCollection());
        scanner.close();
    }
}