package menu;

import commands.Help;
import commands.MoreHelp;
import commands.files.CloseFile;
import commands.logic.*;
import interfaces.MenuItem;
import commands.files.OpenFile;
import commands.files.SaveFile;
import student.StudentRepository;

import java.util.*;

public class Menu {
    private Map<String, MenuItem> menuItems = new LinkedHashMap<>();

    public Menu() {
        menuItems.put("open", new OpenFile());
        menuItems.put("save", new SaveFile());
        menuItems.put("close", new CloseFile());
        menuItems.put("help", new Help());
        menuItems.put("morehelp", new MoreHelp());
        menuItems.put("enroll", new Enroll());
        menuItems.put("advance", new Advance());
        menuItems.put("change", new Change());
        menuItems.put("graduate", new Graduate());
        menuItems.put("interrupt", new Interrupt());
        // Добавете още опции към менюто
    }

    public void showMenu() {
        System.out.println("Welcome to Student Management System");
        List<String> options = new ArrayList<>(menuItems.keySet());
        String availableOptions = String.join(", ", options);
        System.out.println("Available options: " + availableOptions);
    }

    public void executeOption(String text) {
        String[] option = text.split(" ");
        MenuItem menuItem = menuItems.get(option[0]);
        if (menuItem != null && option.length > 1) {
            menuItem.execute(text);
        } else if (menuItem != null) {
            menuItem.execute();
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
}
