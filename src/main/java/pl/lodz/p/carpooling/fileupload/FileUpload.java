package pl.lodz.p.carpooling.fileupload;

import javax.persistence.*;

/**
 * @author Adrian Szwajkowski.
 */
@Entity
public class FileUpload
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String filename;

    private String mimeType;

    public FileUpload() {}

    public FileUpload(String filename, String mimeType) {
        this.filename = filename;
        this.mimeType = mimeType;
    }

    public long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return "FileUpload{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}
