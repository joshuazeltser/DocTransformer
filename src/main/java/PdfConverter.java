import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class PdfConverter {

    private ConvertFile<PDDocument> convertFile;

    public PdfConverter(ConvertFile<PDDocument> convertFile) {
        this.convertFile = convertFile;
    }

    public boolean convertToHTML(String outputName) throws IOException {
        Writer output = new PrintWriter("src/test/java/testFiles/output/" + outputName + ".html", "utf-8");

        try {
            new PDFDomTree().writeText(this.convertFile.getFile(), output);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        }
        output.close();
        return true;
    }
}
