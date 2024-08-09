package view.shopping_cart;

import javax.swing.*;
import java.awt.*;

public class ShoppingCartBuyerSelectPanel extends JPanel{
    private final Color color1 = new Color(251,249,238);
    ShoppingCartBuyerSelectPanel(JButton viewProductButton, JLabel priceLabel, JButton selectButton) {
        this.setBackground(color1);

        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(selectButton);

    }
}
