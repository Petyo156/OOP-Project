package commands.files;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile extends FileManager {
    @Override
    public void execute() {
        if (getFilePath() == null || getFileContent() == null) {
            System.out.println("Error: No file is currently opened.");
            return;
        }
        try {
            FileWriter writer = new FileWriter(getFilePath());
            writer.write(getFileContent());
            writer.close();
            System.out.println("Successfully saved " + getFilePath());
        } catch (IOException e) {
            System.out.println("Error: Unable to save file.");
        }
    }
}
