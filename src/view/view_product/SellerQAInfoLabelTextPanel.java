package view.view_product;

import javax.swing.*;

public class SellerQAInfoLabelTextPanel extends JPanel {
    SellerQAInfoLabelTextPanel(JLabel question, JLabel answer, JButton replyButton){
        this.add(question);
        this.add(answer);
        this.add(replyButton);
    }
}
