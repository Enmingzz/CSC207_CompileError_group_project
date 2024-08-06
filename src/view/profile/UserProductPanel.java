package view.profile;

import javax.swing.*;

/**
 * UserProductPanel is a custom JPanel that displays product information in a vertical layout.
 * It includes an image, product title, price, rating, and a view button.
 */
public class UserProductPanel extends JPanel {

    /**
     * Constructs a UserProductPanel with the specified components.
     *
     * @param paneledImage the JLabel containing the product image
     * @param productTitle the JLabel containing the product title
     * @param productPrice the JLabel containing the product price
     * @param rating       the JLabel containing the product rating
     * @param viewButton   the JButton for viewing the product details
     */
    UserProductPanel(JLabel paneledImage, JLabel productTitle, JLabel productPrice, JLabel rating, JButton viewButton) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(paneledImage);
        this.add(productTitle);
        this.add(productPrice);
        this.add(rating);
        this.add(viewButton);
    }
}
