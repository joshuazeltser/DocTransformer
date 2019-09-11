import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class PdfConverter extends Converter{

    public PdfConverter(ConvertFile convertFile, String outputPath) {
        super(convertFile, outputPath);
    }

    public boolean convertToHTML() throws IOException {
        Writer output = new PrintWriter(  super.outputPath + ".html", "utf-8");

        try {
            new PDFDomTree().writeText((PDDocument) super.file.getFile(), output);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        }
        output.close();
        return true;
    }

    public boolean convertToDocx(String outputName) {
        return true;
    }

    public boolean convertToJpeg(String outputName) {
        return true;
    }

    public boolean convertToText(String outputName) {
        return true;
    }


}
