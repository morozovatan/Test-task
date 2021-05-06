import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ImageHTMLOptions> iho = ImageHTMLService.getImagesOptionsFromPage("http://forum.awd.ru/viewtopic.php?f=1011&t=165935");
        for (ImageHTMLOptions i : iho) {
            System.out.println(i);
        }
    }
}
