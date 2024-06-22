package view;

// Import all controllers related to ShoppingCart
import interface_adapter.shopping_cart.PurchaseController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class ShoppingCartView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "shopping cart";

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
