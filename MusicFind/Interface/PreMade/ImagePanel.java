package MusicFind.Interface.PreMade;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(String imagePath) {
        try {
            image = ImageIO.read(new File("Images\\musicFindW.png")); // Load the image from file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int x = 0; // X coordinate remains 0
            int y = (getHeight() - image.getHeight()) / 2; // Calculate Y coordinate to center vertically
            g.drawImage(image, x, y, this); // Draw the image
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (image != null) {
            return new Dimension(image.getWidth(), image.getHeight()); // Set preferred size based on image dimensions
        } else {
            return super.getPreferredSize();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel imagePanel = new ImagePanel("image.jpg"); // Replace "image.jpg" with your image file path
        frame.getContentPane().add(imagePanel);

        frame.pack(); // Resize frame to fit image
        frame.setVisible(true);
    }
}
