package view.shopping_cart;

import javax.swing.*;

public class ShoppingCartSellerSelectPanel extends JPanel{
    ShoppingCartSellerSelectPanel(JButton viewProductButton, JLabel pendingSelectionLabel) {
        this.add(viewProductButton);
        this.add(pendingSelectionLabel);
    }
}
