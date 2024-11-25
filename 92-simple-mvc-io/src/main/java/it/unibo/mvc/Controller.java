package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;
    private static final String DEFAULT_FILENAME = "output.txt";
    private static final String PATH = System.getProperty("user.home") + System.getProperty("file.separator");

    /**
     * Controller constructor, set the default filepath.
     */
    public Controller() {
        this.currentFile = new File(PATH + DEFAULT_FILENAME);
    }

    /**
     * Set current file.
     * 
     * @param file to be set as current
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    /**
     * 
     * @return current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Get current file path.
     * 
     * @return String of the current file path
     */
    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Save on file the content passed.
     * 
     * @param content Content to save on file
     * @throws IOException
     */
    public void saveOnFile(final String content) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.println(content);
            ps.close();
        }

    }
}
