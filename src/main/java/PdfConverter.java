import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.fit.pdfdom.PDFDomTree;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class PdfConverter extends Converter{

    public PdfConverter(ConvertFile convertFile, String outputPath) {
        super(convertFile, outputPath);
    }

//    TODO: add finally to always close file
    public void convertToHTML() throws IOException {
        Writer output = new PrintWriter(  super.outputPath + ".html", "utf-8");
        try {
            new PDFDomTree().writeText((PDDocument) super.file.getFile(), output);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        output.close();
    }

    public void convertToDocx() {

    }

    public void convertToJpeg() throws IOException {
        PDDocument doc = (PDDocument) super.file.getFile();
        PDFRenderer pdfRenderer = new PDFRenderer(doc);
        for (int page = 0; page < doc.getNumberOfPages(); page++ ) {
            BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
            ImageIOUtil.writeImage(bufferedImage, String.format(outputPath + "-%d.jpeg", page + 1), 300);
        }
        doc.close();
    }

    public void convertToText() {
    }

    public void convertToPdf() {}


}
