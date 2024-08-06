package view.profile.ProfileHelper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * ProfileTitleLabel is a custom JLabel that displays a title along with a circular image.
 * It sets up the label with specific font, alignment, and an image icon.
 */
public class ProfileTitleLabel extends JLabel {

    /**
     * Constructs a ProfileTitleLabel with the specified title text.
     * It sets the text, font, alignment, and a circular image icon.
     *
     * @param titleLabel the text to be displayed as the title
     * @throws IOException if an error occurs during image loading
     */
    public ProfileTitleLabel(String titleLabel) throws IOException {
        this.setText(titleLabel);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setVerticalTextPosition(SwingConstants.TOP);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        this.setIconTextGap(10);

        BufferedImage image = ImageIO.read(Objects.requireNonNull(ProfileTitleLabel.class.getResource("/pic/profile.jpg")));
        CreateCircularImage circularImage = new CreateCircularImage(image);
        ImageIcon originalIcon = new ImageIcon(circularImage.getCircularImage());
        this.setIcon(new ImageIcon(originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }
}
