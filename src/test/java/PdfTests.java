import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PdfTests {

    private ConvertFile<PDDocument> file;

    @BeforeEach
    public void init() {
        file = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input1.pdf", FileType.PDF);
    }

    @AfterEach
    public void close() {
        file = null;
        File dir = new File("src/test/java/testFiles/output/");
        for (File f : dir.listFiles()) {
            f.delete();
        }
    }

    @Test
    public void convertPdfToHtmlTest() {
        Converter converter = new PdfConverter(file, "src/test/java/testFiles/output/output1");

        try {
            converter.convertToHTML();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File newFile = new File("src/test/java/testFiles/output/output1.html");

        assertTrue(newFile.exists());

        try {
            assertEquals(FileUtils.readLines(newFile), FileUtils.readLines(
                    new File("src/test/java/testFiles/expectedOutput/output1.html")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        newFile.deleteOnExit();
    }

    @Test
    public void convertPdfToJpeg() {
        Converter converter = new PdfConverter(file, "src/test/java/testFiles/output/output2");

        try {
            converter.convertToJpeg();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File newFile = new File("src/test/java/testFiles/output/output2-1.jpeg");
        File newFile13 = new File("src/test/java/testFiles/output/output2-13.jpeg");

        assertTrue(newFile.exists());
        assertTrue(newFile13.exists());

        try {
            assertEquals(FileUtils.readLines(newFile), FileUtils.readLines(
                    new File("src/test/java/testFiles/expectedOutput/output2-1.jpeg")));
            assertEquals(FileUtils.readLines(newFile13), FileUtils.readLines(
                    new File("src/test/java/testFiles/expectedOutput/output2-13.jpeg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
