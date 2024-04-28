package commands.files;

public class CloseFile extends FileManager {
    @Override
    public void execute() {
        if (null == getFilePath() || null == getFileContent()) {
            System.out.println("Error: No file is currently opened.");
            return;
        }
        setFilePath(null);
        setFileContent(null);
        System.out.println("Successfully closed the file.");
    }
}
