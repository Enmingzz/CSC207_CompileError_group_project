package view.rate_product;

import javax.swing.*;

public class RateProductLabelTextPanel extends JPanel {
    RateProductLabelTextPanel(JLabel _title,JLabel image,JLabel price){
        this.add(_title);
        this.add(image);
        this.add(price);
    }
}
