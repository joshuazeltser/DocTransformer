import java.io.IOException;

public class WordConvert extends Converter {

    public WordConvert(ConvertFile file, String outputPath) {
        super(file, outputPath);
    }

    public boolean convertToHTML() throws IOException {
        return false;
    }

    public boolean convertToDocx(String outputName) {
        return false;
    }

    public boolean convertToJpeg(String outputName) {
        return false;
    }

    public boolean convertToText(String outputName) {
        return false;
    }
}
