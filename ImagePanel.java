import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {
    private OFImage image;

    public void setImage(OFImage img) {
        this.image = img;
        repaint();
    }

    public void clearImage() {
        this.image = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}
