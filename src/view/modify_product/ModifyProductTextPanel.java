package view.modify_product;

import javax.swing.*;

public class ModifyProductTextPanel extends JPanel {
//    ModifyProductTextPanel(JLabel titleLabel, JLabel title,
//                           JLabel descriptionLabel, JTextField description, JLabel priceLabel, JTextField price,
//                           JLabel eTransferEmailLabel, JLabel eTransferEmail, JLabel addressLabel, JLabel address,
//                           JLabel tagsLabel, JLabel tags) {
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(titleLabel);
//        this.add(title);
//        this.add(descriptionLabel);
//        this.add(description);
//        this.add(priceLabel);
//        this.add(price);
//        this.add(eTransferEmailLabel);
//        this.add(eTransferEmail);
//        this.add(addressLabel);
//        this.add(address);
//        this.add(tagsLabel);
//        this.add(tags);
//
//    }

    public ModifyProductTextPanel() {}

    public void setText(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
