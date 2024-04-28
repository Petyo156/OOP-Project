package commands.files;

import interfaces.MenuItem;
import interfaces.Repository;
import interfaces.Student;

public abstract class FileManager implements MenuItem {
    private String filePath;
    private String fileContent;

    String getFilePath() {
        return filePath;
    }

    void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    String getFileContent() {
        return fileContent;
    }

    void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(String command) {

    }
}
