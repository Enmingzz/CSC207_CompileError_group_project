package view.profile.ProfileHelper;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * RemoveBackground is a utility class that processes an image to remove a specified background color.
 * It creates a new image with the background color replaced by transparency.
 */
public class RemoveBackground {
    private final BufferedImage newImage;

    /**
     * Constructs a RemoveBackground object and processes the provided image to remove the specified background color.
     *
     * @param image           the original BufferedImage to be processed
     * @param backgroundColor the background color to be removed
     */
    public RemoveBackground(BufferedImage image, Color backgroundColor) {
        int width = image.getWidth();
        int height = image.getHeight();
        this.newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                if (isColorClose(rgb, backgroundColor.getRGB())) {
                    newImage.setRGB(x, y, 0x00000000); // Set transparent
                } else {
                    newImage.setRGB(x, y, rgb); // Retain original pixel
                }
            }
        }
    }

    /**
     * Checks if two colors are close to each other within a specified tolerance.
     *
     * @param rgb1 the first color in RGB format
     * @param rgb2 the second color in RGB format
     * @return true if the colors are close to each other, false otherwise
     */
    private boolean isColorClose(int rgb1, int rgb2) {
        int tolerance = 10; // Tolerance level for color matching
        int r1 = (rgb1 >> 16) & 0xFF;
        int g1 = (rgb1 >> 8) & 0xFF;
        int b1 = rgb1 & 0xFF;

        int r2 = (rgb2 >> 16) & 0xFF;
        int g2 = (rgb2 >> 8) & 0xFF;
        int b2 = rgb2 & 0xFF;

        return Math.abs(r1 - r2) < tolerance && Math.abs(g1 - g2) < tolerance && Math.abs(b1 - b2) < tolerance;
    }

    /**
     * Returns the new image with the background removed.
     *
     * @return the new BufferedImage with the background removed
     */
    public BufferedImage getNewImage() {
        return newImage;
    }
}
