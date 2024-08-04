package view.shopping_cart;

import javax.swing.*;

public class ShoppingCartRatingPanel extends JPanel {
    ShoppingCartRatingPanel(JButton viewProductButton, JLabel priceLabel, JButton ratingButton){


        this.add(viewProductButton);
        this.add(priceLabel);
        this.add(ratingButton);
    }
}
