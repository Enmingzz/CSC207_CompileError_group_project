package view.profile.ProfileHelper;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * SetButtonHelper is a utility class that sets an icon with a transparent background on a JButton.
 * It resizes the image, removes the background color, and configures the button.
 */
public class SetButtonHelper {
    private final JButton jButton;
    private final RemoveBackground removeBackground;

    /**
     * Constructs a SetButtonHelper with the specified image path and button.
     * It loads the image, resizes it, and removes its background.
     *
     * @param pathName the path to the image file
     * @param jButton  the JButton to set the icon on
     * @throws IOException if an error occurs during image loading
     */
    public SetButtonHelper(String pathName, JButton jButton) throws IOException {
        BufferedImage image = ImageIO.read(Objects.requireNonNull(SetButtonHelper.class.getResource(pathName)));

        this.removeBackground = new RemoveBackground(resizeBufferedImage(image, 50, 50), Color.WHITE);
        this.jButton = jButton;
    }

    /**
     * Sets the processed image as the icon of the button and adjusts the button's text and image alignment.
     */
    public void setButton(){
        jButton.setIcon(new ImageIcon(removeBackground.getNewImage()));
        jButton.setVerticalTextPosition(JButton.BOTTOM);
        jButton.setHorizontalTextPosition(JButton.CENTER);
        jButton.setVerticalAlignment(JButton.CENTER);
        jButton.setHorizontalAlignment(JButton.CENTER);
    }

    /**
     * Resizes the provided BufferedImage to the specified width and height.
     *
     * @param originalImage the original BufferedImage to be resized
     * @param width         the target width
     * @param height        the target height
     * @return the resized BufferedImage
     */
    private BufferedImage resizeBufferedImage(BufferedImage originalImage, int width, int height) {
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }
}
