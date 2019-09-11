import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PdfTests {

    @Test
    public void convertPdfToHtmlTest() {
        ConvertFile<PDDocument> file = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input1.pdf", FileType.PDF);

        Converter converter = new PdfConverter(file, "src/test/java/testFiles/output/output1");

        try {
            converter.convertToHTML();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File newFile = new File("src/test/java/testFiles/output/output1.html");

        assertTrue(newFile.exists());

        try {
            assertEquals(FileUtils.readLines(newFile), FileUtils.readLines(new File("src/test/java/testFiles/expectedOutput/output1.html")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        newFile.deleteOnExit();
    }
}
