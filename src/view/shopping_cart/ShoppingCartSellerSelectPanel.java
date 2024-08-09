package view.shopping_cart;

import javax.swing.*;
import java.awt.*;

public class ShoppingCartSellerSelectPanel extends JPanel{
    private final Color color1 = new Color(251,249,238);
    ShoppingCartSellerSelectPanel(JButton viewProductButton, JLabel priceLabel, JLabel pendingSelectionLabel) {
        this.setBackground(color1);

        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(pendingSelectionLabel);
    }
}
