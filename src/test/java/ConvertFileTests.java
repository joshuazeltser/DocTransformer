import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ConvertFileTests {

    private ConvertFile<PDDocument> file1;

    @BeforeEach
    public void init() throws IOException, InvalidFileTypeException {
        file1 = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input1.pdf");
    }

    @AfterEach
    public void close() {
        file1 = null;
    }

    @Test
    public void getterTests() {
        assertTrue(file1.getType().equals(FileType.PDF));
        assertTrue(file1.getFilePath().equals("src/test/java/testFiles/input/input1.pdf"));
        assertTrue(file1.getFile().getNumberOfPages() == 13);
    }

    @Test
    public void setTypeTests() {
//    TODO
    }
}
