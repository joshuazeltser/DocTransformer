import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PdfTests {

    private ConvertFile<PDDocument> file1;
    private ConvertFile<PDDocument> file2;

    @BeforeEach
    public void init() throws IOException, InvalidFileTypeException {
        file1 = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input1.pdf");
        file2 = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input2.pdf");
    }

    @AfterEach
    public void close() {
        file1 = null;
        file2 = null;
        File dir = new File("src/test/java/testFiles/output/");
        for (File f : dir.listFiles()) {
            f.delete();
        }
    }

    @Test
    public void convertPdfToHtmlTest1() {
        Converter converter = new PdfConverter(file1, "src/test/java/testFiles/output/output1");

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
            fail();
        }
    }

    @Test
    public void convertPdfToHtmlTest2() {
        Converter converter = new PdfConverter(file2, "src/test/java/testFiles/output/output2");

        try {
            converter.convertToHTML();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File newFile = new File("src/test/java/testFiles/output/output2.html");

        assertTrue(newFile.exists());

        try {
            assertEquals(FileUtils.readLines(newFile), FileUtils.readLines(
                    new File("src/test/java/testFiles/expectedOutput/output2.html")));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void convertPdfToJpeg1() {
        Converter converter = new PdfConverter(file1, "src/test/java/testFiles/output/output2");

        try {
            converter.convertToJpeg();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
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
            fail();
        }
    }

    @Test
    public void convertPdfToJpeg2() {
        Converter converter = new PdfConverter(file2, "src/test/java/testFiles/output/output3");

        try {
            converter.convertToJpeg();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        File newFile = new File("src/test/java/testFiles/output/output3-1.jpeg");

        assertTrue(newFile.exists());

        try {
            assertEquals(FileUtils.readLines(newFile), FileUtils.readLines(
                    new File("src/test/java/testFiles/expectedOutput/output3-1.jpeg")));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void convertPdfToDocxTest1() {
        Converter converter = new PdfConverter(file1, "src/test/java/testFiles/output/output4");

        try {
            converter.convertToDocx();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }

        File newFile = new File("src/test/java/testFiles/output/output4.docx");

        assertTrue(newFile.exists());

        try {
            assertFalse(FileUtils.readLines(newFile).isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void convertPdfToDocxTest2() {
        Converter converter = new PdfConverter(file2, "src/test/java/testFiles/output/output5");

        try {
            converter.convertToDocx();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }

        File newFile = new File("src/test/java/testFiles/output/output5.docx");

        assertTrue(newFile.exists());
        try {
            assertFalse(FileUtils.readLines(newFile).isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void convertPdfToTxtTest1() {
        Converter converter = new PdfConverter(file1, "src/test/java/testFiles/output/output6");

        try {
            converter.convertToTxt();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        File newFile = new File("src/test/java/testFiles/output/output6.txt");
        assertTrue(newFile.exists());

        try {
            assertEquals(FileUtils.readLines(newFile), FileUtils.readLines(
                    new File("src/test/java/testFiles/expectedOutput/output6.txt")));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void convertPdfToTxtTest2() {
        Converter converter = new PdfConverter(file2, "src/test/java/testFiles/output/output7");

        try {
            converter.convertToTxt();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        File newFile = new File("src/test/java/testFiles/output/output7.txt");
        assertTrue(newFile.exists());

        try {
            assertEquals(FileUtils.readLines(newFile), FileUtils.readLines(
                    new File("src/test/java/testFiles/expectedOutput/output7.txt")));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }

    }
}
