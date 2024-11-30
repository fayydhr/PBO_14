import java.awt.image.BufferedImage;

class OFImage extends BufferedImage {
    public OFImage(BufferedImage image) {
        super(image.getWidth(), image.getHeight(), image.getType());
        this.getGraphics().drawImage(image, 0, 0, null);
    }

    public void darker() {
        // Implement logic to darken the image.
    }

    public void lighter() {
        // Implement logic to lighten the image.
    }

    public void threshold() {
        // Implement logic for threshold filter.
    }
}
