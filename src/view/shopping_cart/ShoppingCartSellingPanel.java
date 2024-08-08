package view.shopping_cart;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for a product that can be checked out
 */

// image not included in this version

public class ShoppingCartSellingPanel extends JPanel{
    private final Color color1 = new Color(251,249,238);
    ShoppingCartSellingPanel(JButton viewProductButton, JLabel priceLabel, JButton checkoutButton, JButton deleteButton) {
        this.setBackground(color1);
        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(checkoutButton);
        this.add(deleteButton);
    }
}
