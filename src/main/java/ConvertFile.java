import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class ConvertFile<T> {

    private T file;

    private FileType type;

    private String fileName;

    public ConvertFile(String fileName, FileType type) {
        this.fileName = fileName;
        this.type = type;
        try {
            this.setFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public T getFile() {
        return file;
    }

    public void setFile(String fileName) throws IOException {
        switch (type) {
            case PDF: this.file = (T) PDDocument.load(new File(fileName)); break;
            default:
        }
    }
}
