import java.net.URL;
import java.util.Objects;

public class ImageHTMLOptions {
    /*URL
изображения, разрешения изображения и размер в килобайтах*/
    private String url;
    private String extension;
    private Double size;

    public ImageHTMLOptions(String url, String extension, Double size) {
        this.url = url;
        this.extension = extension;
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ImageHTMLOptions{ " +
                "url=" + url +
                ", extension='" + extension + '\'' +
                ", size=" + size +
                " }";
    }
}
