package main;

import checker.Checker;

import database.Database;

import files.reader.Reader;
import files.writer.Writer;
import files.FilesManagement;


/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score.
     *
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) throws Exception {
        FilesManagement filesManagement = new FilesManagement();

        filesManagement.createOutputDirectory();
        filesManagement.cleanOutputDirectory();
        filesManagement.createOutputFiles();

        Checker.calculateScore();
    }

    /**
     * This method is used to start the program.
     *
     * @param filePath1 input file name
     * @param filePath2 output file name
     */
    public static void startProcess(final String filePath1,
                                    final String filePath2) {
        Database.getInstance().entryPoint(
                new Reader(filePath1).readData(),
                new Writer(filePath2));
    }
}
