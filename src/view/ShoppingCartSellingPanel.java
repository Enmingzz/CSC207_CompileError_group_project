package view;

import javax.swing.*;

/**
 * Panel for a product that can be checked out
 */

// image not included in this version

public class ShoppingCartSellingPanel extends JPanel{
    ShoppingCartSellingPanel(JButton viewProductButton, JButton checkoutButton, JButton deleteButton) {
        this.add(viewProductButton);
        this.add(checkoutButton);
        this.add(deleteButton);
    }
}
