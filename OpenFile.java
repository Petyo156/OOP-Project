package commands.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenFile extends FileManager {
    public void execute(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            StringBuilder contentBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                contentBuilder.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            setFilePath(filePath);
            setFileContent(contentBuilder.toString());
            System.out.println("Successfully opened " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give the file path: ");
        String filePath = scanner.nextLine();
        execute(filePath);
    }
}
