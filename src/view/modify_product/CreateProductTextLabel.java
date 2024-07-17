package view.modify_product;

import javax.swing.*;

public class CreateProductTextLabel extends JPanel {
    CreateProductTextLabel(JLabel titleLabel,
                           JLabel descriptionLabel, JLabel priceLabel,
                           JLabel eTransferEmailLabel, JLabel addressLabel, JLabel address,
                           JLabel tagsLabel) {
        this.add(titleLabel);
        this.add(descriptionLabel);
        this.add(priceLabel);
        this.add(eTransferEmailLabel);
        this.add(addressLabel);
        this.add(address);
        this.add(tagsLabel);
    }
}
