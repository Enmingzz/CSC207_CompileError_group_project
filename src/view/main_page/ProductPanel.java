package view.main_page;

import javax.swing.*;

public class ProductPanel extends JPanel {
    ProductPanel(JLabel paneledImage, JLabel productTitle, JLabel productPrice, JButton viewButton) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(paneledImage);
        this.add(productTitle);
        this.add(productPrice);
        this.add(viewButton);
    }
}
