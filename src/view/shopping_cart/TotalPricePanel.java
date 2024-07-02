package view.shopping_cart;

import javax.swing.*;

public class TotalPricePanel extends JPanel{

    TotalPricePanel(JLabel totalPriceLabel){
        JLabel priceIndicatorLabel = new JLabel("Total Price:");
        this.add(priceIndicatorLabel);
        this.add(totalPriceLabel);
    }
}
