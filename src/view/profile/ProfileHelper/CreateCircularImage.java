package view.profile.ProfileHelper;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * CreateCircularImage is a helper class that creates a circular version of a given BufferedImage.
 */
public class CreateCircularImage {
    private final BufferedImage circularImage;

    /**
     * Constructs a CreateCircularImage object and generates a circular version of the provided image.
     *
     * @param image the original BufferedImage to be converted into a circular image
     */
    public CreateCircularImage(BufferedImage image) {
        int diameter = Math.min(image.getWidth(), image.getHeight());
        BufferedImage mask = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mask.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter, diameter);
        g2d.dispose();

        this.circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = circularImage.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.drawImage(image, 0, 0, diameter, diameter, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(mask, 0, 0, null);
        g2d.dispose();
    }

    /**
     * Applies high-quality rendering hints to the provided Graphics2D object.
     *
     * @param g2d the Graphics2D object to which rendering hints will be applied
     */
    private void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    /**
     * Returns the circular version of the provided image.
     *
     * @return the circular BufferedImage
     */
    public BufferedImage getCircularImage() {
        return this.circularImage;
    }
}
