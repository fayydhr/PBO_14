import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageViewer {
    private JFrame frame;
    private ImagePanel imagePanel;
    private OFImage currentImage;
    private ImageFileManager fileManager;

    public ImageViewer() {
        frame = new JFrame("ImageViewer V-1");
        imagePanel = new ImagePanel();
        fileManager = new ImageFileManager();
        setupGUI();
    }

    private void setupGUI() {
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem quitItem = new JMenuItem("Quit");

        openItem.addActionListener(e -> openImage());
        closeItem.addActionListener(e -> closeImage());
        quitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.addSeparator();
        fileMenu.add(quitItem);

        // Filter Menu
        JMenu filterMenu = new JMenu("Filter");
        JMenuItem darkerItem = new JMenuItem("Darker");
        JMenuItem lighterItem = new JMenuItem("Lighter");
        JMenuItem thresholdItem = new JMenuItem("Threshold");

        darkerItem.addActionListener(e -> applyFilter("darker"));
        lighterItem.addActionListener(e -> applyFilter("lighter"));
        thresholdItem.addActionListener(e -> applyFilter("threshold"));

        filterMenu.add(darkerItem);
        filterMenu.add(lighterItem);
        filterMenu.add(thresholdItem);

        menuBar.add(fileMenu);
        menuBar.add(filterMenu);

        frame.setJMenuBar(menuBar);
        frame.add(imagePanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            currentImage = fileManager.loadImage(file);
            imagePanel.setImage(currentImage);
        }
    }

    private void closeImage() {
        imagePanel.clearImage();
        currentImage = null;
    }

    private void applyFilter(String filter) {
        if (currentImage != null) {
            switch (filter) {
                case "darker" -> currentImage.darker();
                case "lighter" -> currentImage.lighter();
                case "threshold" -> currentImage.threshold();
            }
            imagePanel.repaint();
        }
    }

    public static void main(String[] args) {
        new ImageViewer();
    }
}
