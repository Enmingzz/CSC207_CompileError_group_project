package view.view_product;

import javax.swing.*;

/**
 * This class represents a panel that displays a product information label and its corresponding text field.
 * It extends {@link JPanel} and is designed to hold two {@link JLabel} components:
 * one for the label and one for the text field displaying the information.
 * <p>
 * This is particularly useful in UIs where displaying structured product information in a clear format is needed.
 * </p>
 */

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

    /**
     * Constructs a new panel containing a product information label and its corresponding text field.
     *
     * @param label the {@link JLabel} that contains the label text.
     * @param textField the {@link JLabel} that contains the information text.
     */

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
