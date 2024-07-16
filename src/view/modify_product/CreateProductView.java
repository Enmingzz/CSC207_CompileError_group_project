package view.modify_product;

import interface_adapter.modify_product.ViewCreateProductViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "view create product";

    private final ViewCreateProductViewModel viewCreateProductViewModel;
    private final JTextField title = new JTextField(3);


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
