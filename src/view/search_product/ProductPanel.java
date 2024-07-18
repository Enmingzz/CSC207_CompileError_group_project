package view.search_product;

import javax.swing.*;

/**
 * The ProductPanel class represents a panel displaying product information.
 * It includes an image, title, price, and a button to view the product.
 */
public class ProductPanel extends JPanel {
    /**
     * Constructs a ProductPanel.
     *
     * @param paneledImage the label containing the product image
     * @param productTitle the label containing the product title
     * @param productPrice the label containing the product price
     * @param viewButton the button to view the product
     */
    ProductPanel(JLabel paneledImage, JLabel productTitle, JLabel productPrice, JButton viewButton) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(paneledImage);
        this.add(productTitle);
        this.add(productPrice);
        this.add(viewButton);
    }
}