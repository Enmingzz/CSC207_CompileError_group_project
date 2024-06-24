package view;

import javax.swing.*;

/**
 * Panel for one product pending confirmation of reception
 */

public class ShoppingCartConfirmationPanel extends JPanel{
    ShoppingCartConfirmationPanel(JButton viewProductButton, JButton confirmButton){
        this.add(viewProductButton);
        this.add(confirmButton);
    }
}
