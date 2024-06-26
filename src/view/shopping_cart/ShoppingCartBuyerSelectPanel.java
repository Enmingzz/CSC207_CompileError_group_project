package view.shopping_cart;

import javax.swing.*;

public class ShoppingCartBuyerSelectPanel extends JPanel{
    ShoppingCartBuyerSelectPanel(JButton viewProductButton, JLabel priceLabel, JButton selectButton) {

        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(selectButton);
    }
}
