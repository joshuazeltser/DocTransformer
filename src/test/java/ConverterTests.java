import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ConverterTests {

    private ConvertFile<PDDocument> file1;
    private Converter converter;

    @BeforeEach
    public void init() throws IOException, InvalidFileTypeException {
        file1 = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input1.pdf");
        converter = new PdfConverter(file1, "src/test/java/testFiles");
    }

    @AfterEach
    public void close() {
        file1 = null;
        converter = null;
    }

    @Test
    public void getterTests() {
        assertTrue(converter.getFile().equals(file1));
        assertTrue(converter.getOutputPath().equals("src/test/java/testFiles"));
    }

    @Test
    public void setterTests() {
        try {
            ConvertFile<PDDocument> file2 = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input2.pdf");
            converter.setFile(file2);
            converter.setOutputPath("src/test");
            assertTrue(converter.file.equals(file2));
            assertTrue(converter.outputPath.equals("src/test"));
        } catch (IOException | InvalidFileTypeException e) {
            e.printStackTrace();
            fail();
        }
    }
}
