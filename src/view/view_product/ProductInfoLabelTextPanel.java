package view.view_product;

import javax.swing.*;

public class ProductInfoLabelTextPanel extends JPanel {
//    ProductInfoLabelTextPanel(JLabel _title,JLabel image,JLabel description,JLabel price,JLabel rating,JLabel state,
//                              JLabel address, JLabel lstTags,JLabel productID){
//        this.add(_title);
//        this.add(image);
//        this.add(description);
//        this.add(price);
//        this.add(rating);
//        this.add(state);
//        this.add(address);
//        this.add(lstTags);
//        this.add(productID);
//    }

    private JLabel label;

    public ProductInfoLabelTextPanel(JLabel label, JLabel textField) {
        this.removeAll();
        this.add(label);
        this.add(textField);
        this.label = label;
    }

    public void setText(JLabel textField){
        this.removeAll();
        this.add(this.label);
        this.add(textField);
    }
}
