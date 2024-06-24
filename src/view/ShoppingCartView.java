package view;

import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.shopping_cart.ShoppingCartState;

// Import all controllers related to ShoppingCart
import interface_adapter.shopping_cart.PurchaseController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.schedule.BuyerSelectScheduleController;

// Import all Controllers related to the top bar

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
    private final ShoppingCartViewModel shoppingCartViewModel;

    // List and initialize all controllers as `private final`

    public ShoppingCartView(ShoppingCartViewModel shoppingCartViewModel) {
        // Initialize all controllers here

        shoppingCartViewModel.addPropertyChangeListener(this);
        this.shoppingCartViewModel = shoppingCartViewModel;

        JLabel title = new JLabel(shoppingCartViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
