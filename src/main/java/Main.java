import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");

        ConvertFile<PDDocument> file = new ConvertFile<PDDocument>("src/test/java/testFiles/test1.pdf", FileType.PDF);

        PdfConverter converter = new PdfConverter(file);

        try {
            converter.convertToHTML("output");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}