package view.view_product;

import javax.swing.*;
import java.awt.*;

public class SellerQAInfoLabelTextPanel extends JPanel {
    SellerQAInfoLabelTextPanel(JLabel question, JLabel answer, JButton replyButton){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.removeAll();
        this.add(question);
        this.add(answer);
        this.add(replyButton);
    }
}
