package files;

import common.Constants;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static main.Main.startProcess;

public final class FilesManagement {
    /**
     * This method create an output directory.
     */
    public void createOutputDirectory() throws Exception {
        Path path = Paths.get(Constants.RESULT);

        if (!java.nio.file.Files.exists(path)) {
            java.nio.file.Files.createDirectories(path);
        }
    }

    /**
     * This method clean the output directory.
     */
    public void cleanOutputDirectory() {
        File outputDirectory = new File(Constants.RESULT);

        for (File file : Objects.requireNonNull(outputDirectory.listFiles())) {
            if (!file.delete()) {
                System.out.println();
            }
        }
    }

    /**
     * This method create an output file and write data in it.
     */
    public void createOutputFiles() throws Exception {
        File directory = new File(Constants.INPUT_PATH);

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = Constants.OUTPUT_PATH
                    + file.getName().substring(Constants.INPUT_FILE_SUBSTRING);

            File out = new File(filepath);
            boolean isCreated = out.createNewFile();

            if (isCreated) {
                startProcess(file.getAbsolutePath(), filepath);
            }
        }
    }
}
