package view.shopping_cart;

import javax.swing.*;
import java.awt.*;

public class TotalPricePanel extends JPanel{
    private final Color color1 = new Color(251,249,238);
    TotalPricePanel(JLabel totalPriceLabel){
        this.setBackground(color1);
        JLabel priceIndicatorLabel = new JLabel("Total Price:");
        this.add(priceIndicatorLabel);
        this.add(totalPriceLabel);
    }
}
