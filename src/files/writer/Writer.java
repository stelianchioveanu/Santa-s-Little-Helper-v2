package files.writer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class Writer {
    private final File file;

    public Writer(final String path) {
        this.file = new File(path);
    }

    /**
     * This method write data in the output file.
     */
    public void writeFile(final AnnualChildrenWriter writerOutput) {
        ObjectMapper om = new ObjectMapper();
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(this.file, writerOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
