import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.fit.pdfdom.PDFDomTree;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.*;

public class PdfConverter extends Converter{

    public PdfConverter(ConvertFile convertFile, String outputPath) {
        super(convertFile, outputPath);
    }

    public void convertToHTML() throws IOException {
        Writer output = new PrintWriter(  outputPath + ".html", "utf-8");
        try {
            new PDFDomTree().writeText((PDDocument) file.getFile(), output);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
    }

//    TODO: add formatting changes too
    public void convertToDocx() throws IOException {
        XWPFDocument document = new XWPFDocument();
        PdfReader reader = new PdfReader(file.getFilePath());
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            TextExtractionStrategy strategy = parser.processContent(i, new LocationTextExtractionStrategy());
            String text = strategy.getResultantText();
            XWPFParagraph p = document.createParagraph();
            XWPFRun run = p.createRun();
            run.setText(text);
            run.addBreak(BreakType.PAGE);
        }
        FileOutputStream out = new FileOutputStream(outputPath + ".docx");
        document.write(out);
        out.close();
        document.close();
    }

    public void convertToJpeg() throws IOException {
        PDDocument doc = (PDDocument) file.getFile();
        PDFRenderer pdfRenderer = new PDFRenderer(doc);
        for (int page = 0; page < doc.getNumberOfPages(); page++ ) {
            BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
            ImageIOUtil.writeImage(bufferedImage, String.format(outputPath + "-%d.jpeg", page + 1), 300);
        }
        doc.close();
    }

    public void convertToTxt() throws IOException {
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String parsedText = pdfTextStripper.getText((PDDocument) file.getFile());
        PrintWriter pw = new PrintWriter(outputPath + ".txt");
        pw.print(parsedText);
        pw.close();
    }

    public void convertToPdf() {}
}
