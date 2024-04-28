package commands.logic;

import interfaces.Student;
import student.implementation.Status;

public class Interrupt extends CommandsManager{
    @Override
    public void execute(String command) {
        String[] arr = command.split(" ");
        if(arr.length == 0){
            System.out.println("Enter valid number of arguments!");
            return;
        }
        String fn = arr[1];
        Student student = findByFakNum(fn);
        if(null == student){
            System.out.println("Student " + fn + " not found.");
            return;
        }
        findByFakNum(fn).setStatus(Status.INTERRUPTED);
        System.out.println("Student " + fn + " interrupted successfully!");
    }
}
