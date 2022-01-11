package files.reader;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class Reader {
    /**
     * The path to the input file.
     */
    private final String inputPath;

    public Reader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * This method read data from the input file.
     */
    public Input readData() {
        Input input = new Input();

        try {
            input = new ObjectMapper().readerFor(Input.class).readValue(new File(this.inputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
