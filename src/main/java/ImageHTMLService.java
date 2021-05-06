import jdk.nashorn.internal.runtime.Context;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageHTMLService {

    /*Задание: Метод принимает на вход ссылку -> выводит
список изображений из HTML по ссылке -> элемент списка состоит из URL
изображения, разрешения изображения и размер в килобайтах.*/

    /*Размен выводится неверно!*/

    public static List<ImageHTMLOptions> getImagesOptionsFromPage(String url) {

        List<ImageHTMLOptions> iho = new ArrayList<>();
        try {
            Document pageCode = Jsoup.connect(url).get();
            Element body = pageCode.body();
            Elements images = body.getElementsByTag("img");

            for (Element im : images) {
                ImageHTMLOptions options = new ImageHTMLOptions("", "", 3.0);
                String src = im.absUrl(("src"));

                if (src != "") {
                    options.setUrl(src);

                    int dotIndex;
                    dotIndex = src.lastIndexOf(".");
                    options.setExtension(src.substring(dotIndex + 1));

                    /*BufferedImage image = ImageIO.read((new URL(src).openStream()));
                    int width = image.getWidth(null);
                    int height = image.getHeight(null);
                    ArrayList<Color> colors = new ArrayList<Color>();
                    int w = image.getWidth(null);
                    int h = image.getHeight(null);
                   int colColors = image.getColorModel().getColorSpace().getNumComponents();
                   System.out.println("width " + w + " height: " + h +"color col "+ colColors);
                    */

                    options.setSize(((double)(new URL(src)).openConnection().getContentLength()));
                    iho.add(options);
                }
               /* if (width == -1) {
                    System.out.println(im.attr("class"));
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iho;
    }
}
