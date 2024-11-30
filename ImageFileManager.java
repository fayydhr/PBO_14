import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

class ImageFileManager {
    public OFImage loadImage(File file) {
        try {
            BufferedImage img = ImageIO.read(file);
            return new OFImage(img);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
