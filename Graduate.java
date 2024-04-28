package commands.logic;

import interfaces.Student;
import student.discipline.Discipline;
import student.implementation.Status;

import java.util.ArrayList;
import java.util.List;

public class Graduate extends CommandsManager{
    @Override
    public void execute(String command) {
        String[] arr = command.split(" ");
        if(arr.length == 0){
            System.out.println("Enter valid number of arguments!");
            return;
        }
        String fn = arr[1];

        if (isInterrupted(fn)) {
            System.out.println("Student " + fn + " is interrupted.");
            return;
        }

        Student student = findByFakNum(fn);
        if(null == student){
            System.out.println("Student " + fn + " not found.");
            return;
        }
        if(checkIfGoodScore(student)){
            findByFakNum(fn).setStatus(Status.GRADUATED);
            System.out.println("Student graduated successfully!");
        }
    }
}
