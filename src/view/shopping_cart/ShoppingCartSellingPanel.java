package view.shopping_cart;

import javax.swing.*;

/**
 * Panel for a product that can be checked out
 */

// image not included in this version

public class ShoppingCartSellingPanel extends JPanel{
    ShoppingCartSellingPanel(JButton viewProductButton, JLabel priceLabel, JButton checkoutButton, JButton deleteButton) {

        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(checkoutButton);
        this.add(deleteButton);
    }
}
