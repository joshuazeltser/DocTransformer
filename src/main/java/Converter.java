import java.io.IOException;

public abstract class Converter {

    protected ConvertFile file;

    protected String outputPath;

    public Converter(ConvertFile file, String outputPath) {
        this.file = file;
        this.outputPath = outputPath;
    }

    public abstract boolean convertToHTML() throws IOException;

    public abstract boolean convertToDocx(String outputName);

    public abstract boolean convertToJpeg(String outputName);

    public abstract boolean convertToText(String outputName);


    public ConvertFile getFile() {
        return file;
    }

    public void setFile(ConvertFile file) {
        this.file = file;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
