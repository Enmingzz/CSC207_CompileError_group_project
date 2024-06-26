package view.shopping_cart;

import javax.swing.*;

/**
 * Panel for one product pending confirmation of reception
 */

public class ShoppingCartConfirmationPanel extends JPanel{
    ShoppingCartConfirmationPanel(JButton viewProductButton, JLabel priceLabel, JButton confirmButton){

        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(confirmButton);
    }
}
