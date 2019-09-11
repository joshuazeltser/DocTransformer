import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class PdfTests {

    @org.junit.Test
    public void convertPdfToHtmlTest() {
        ConvertFile<PDDocument> file = new ConvertFile<PDDocument>("src/test/java/testFiles/input/input1.pdf", FileType.PDF);

        PdfConverter converter = new PdfConverter(file);

        try {
            converter.convertToHTML("output1");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File newFile = new File("src/test/java/testFiles/output/output1.html");

        assertTrue(newFile.exists());
        newFile.deleteOnExit();
    }
}
