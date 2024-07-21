package view.profile;

import javax.swing.*;

public class UserProductPanel extends JPanel {
    UserProductPanel(JLabel paneledImage, JLabel productTitle, JLabel productPrice, JLabel rating, JButton viewButton) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(paneledImage);
        this.add(productTitle);
        this.add(productPrice);
        this.add(rating);
        this.add(viewButton);
    }
}
