package view.modify_product;

import javax.swing.*;
import java.awt.*;

/**
 * ImagePanel is a custom JPanel for displaying an Image.
 * It overrides the paintComponent method to draw the image on the panel.
 */
public class ImagePanel extends JPanel {
    private Image image;

    /**
     * Constructs an ImagePanel with the specified image.
     * @param image the image to be displayed in the panel
     */
    public ImagePanel(Image image) {
        this.image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        // Set the preferred size of the panel to the size of the image
        this.setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
    }

    /**
     * Overrides the paintComponent method of JPanel to draw the image.
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    /**
     * The main method to demonstrate the ImagePanel usage.
     * It loads an image using Toolkit and displays it in a JFrame.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Load an image using Toolkit (for demonstration purposes)
        Image image = Toolkit.getDefaultToolkit().getImage("path/to/your/image.jpg");

        // Create a JFrame
        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of ImagePanel with the loaded image
        ImagePanel imagePanel = new ImagePanel(image);

        // Add the panel to the frame
        frame.add(imagePanel);

        // Pack the frame to fit the preferred size of the panel
        frame.pack();

        // Make the frame visible
        frame.setVisible(true);
    }
}