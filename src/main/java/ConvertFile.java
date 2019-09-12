import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class ConvertFile<T> {

    private T file;

    private FileType type;

    private String filePath;

    public ConvertFile(String filePath) throws IOException, InvalidFileTypeException{
        this.filePath = filePath;
        this.setType();
        this.setFile(filePath);
    }

    public FileType getType() {
        return type;
    }

    public void setType() throws InvalidFileTypeException {
        String fileType = filePath.split("\\.")[1];

        switch (fileType) {
            case "pdf": this.type = FileType.PDF; break;
            case "docx": this.type = FileType.DOCX; break;
            case "txt": this.type = FileType.TXT; break;
            case "html": this.type = FileType.HTML; break;
            case "jpeg": this.type = FileType.JPEG; break;
            default:
                throw new InvalidFileTypeException("Incorrect filetype: " + fileType);
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public T getFile() {
        return file;
    }

    public void setFile(String fileName) throws IOException {
        switch (type) {
            case PDF: this.file = (T) PDDocument.load(new File(fileName)); break;
            case DOCX:
                break;
            case TXT:
                break;
            case HTML:
                break;
            default: break;
        }
    }

    @Override
    public String toString() {
        return this.filePath;
    }
}
