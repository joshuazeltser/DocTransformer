import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inputPath = args[0];
        String outputPath = args[1];

        ConvertFile<PDDocument> file = null;
        try {
            file = new ConvertFile<>(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (InvalidFileTypeException e) {
            e.printStackTrace();
            return;
        }

        Converter converter = null;

        switch (file.getType()) {
            case PDF: converter = new PdfConverter(file, outputPath); break;
            case DOCX:
                break;
            case TXT:
                break;
            case HTML:
                break;
            case JPEG:
                break;
        }

        System.out.println("What filetype would you like to convert your file to (lowercase)?");
        Scanner scanner = new Scanner(System.in);

        String newType = scanner.nextLine();

        switch (newType) {
            case "pdf": converter.convertToPdf(); break;
            case "docx":
                try {
                    converter.convertToDocx();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case "txt":
                try {
                    converter.convertToTxt();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case "html":
                try {
                    converter.convertToHTML();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case "jpeg":
                try {
                    converter.convertToJpeg();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                break;
            default:
                try {
                    throw new InvalidFileTypeException("We do not support that file type!");
                } catch (InvalidFileTypeException e) {
                    e.printStackTrace();
                    return;
                }
        }
    }
}