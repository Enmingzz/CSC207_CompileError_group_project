package view.shopping_cart;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for one product pending confirmation of reception
 */

public class ShoppingCartConfirmationPanel extends JPanel{
    private final Color color1 = new Color(251,249,238);
    ShoppingCartConfirmationPanel(JButton viewProductButton, JLabel priceLabel, JLabel scheculeLabel, JButton confirmButton){
        this.setBackground(color1);

        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(scheculeLabel);
        this.add(confirmButton);
    }
}
