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

    private JLabel textField;

    public ProductInfoLabelTextPanel(JLabel label, JLabel textField) {
        this.add(label);
        this.add(textField);
        this.textField = textField;
    }

    public void setText(JLabel textField){
        this.remove(this.textField);
        this.add(textField);
    }
}
