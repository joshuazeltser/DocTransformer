import java.io.IOException;

public abstract class Converter {

    protected ConvertFile file;

    protected String outputPath;

    public Converter(ConvertFile file, String outputPath) {
        this.file = file;
        this.outputPath = outputPath;
    }

    public abstract void convertToHTML() throws IOException;

    public abstract void convertToDocx();

    public abstract void convertToJpeg() throws IOException;

    public abstract void convertToText();

    public abstract void convertToPdf();

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
