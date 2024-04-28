package commands;

import interfaces.MenuItem;
import interfaces.Repository;
import interfaces.Student;

public class Help implements MenuItem {
    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("The following commands are supported:\n");
        sb.append("open <file>   opens <file>\n");
        sb.append("close         closes currently opened file\n");
        sb.append("save          saves the currently open file\n");
        sb.append("saveas <file> saves the currently open file in <file>\n");
        sb.append("help          prints this information\n");
        sb.append("exit          exists the program");
        System.out.println(sb);
    }

    @Override
    public void execute(String command) {

    }
}
