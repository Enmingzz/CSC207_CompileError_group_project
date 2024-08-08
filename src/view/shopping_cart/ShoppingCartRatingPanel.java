package view.shopping_cart;

import javax.swing.*;
import java.awt.*;

public class ShoppingCartRatingPanel extends JPanel {
    private final Color color1 = new Color(251,249,238);
    ShoppingCartRatingPanel(JButton viewProductButton, JLabel priceLabel, JButton ratingButton){
        this.setBackground(color1);

        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(ratingButton);
    }
}
