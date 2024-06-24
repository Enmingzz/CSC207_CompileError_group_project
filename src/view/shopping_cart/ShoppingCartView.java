package view.shopping_cart;

import entity.product.Product;
import entity.user.User;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.shopping_cart.ShoppingCartState;

// Import all controllers related to ShoppingCart
import interface_adapter.shopping_cart.PurchaseController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.view_product.ViewProductController;
import interface_adapter.shopping_cart.DeleteShoppingCartProductController;

// Import all Controllers related to the top bar

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.SQLException;

public class ShoppingCartView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "shopping cart";
    private final ShoppingCartViewModel shoppingCartViewModel;

    // Check necessity of this part of initialization
    private ArrayList<JButton> viewButtons = new ArrayList<>();
    private ArrayList<JButton> primaryActionButtons = new ArrayList<>();
    private ArrayList<JButton> secondaryActionButtons = new ArrayList<>();

    // List and initialize all controllers as `private final`
    private final ViewProductController viewProductController;
    private final PurchaseController purchaseController;
    private final DeleteShoppingCartProductController deleteShoppingCartProductController;

    public ShoppingCartView(ShoppingCartViewModel shoppingCartViewModel,
                            ViewProductController viewProductController,
                            PurchaseController purchaseController,
                            DeleteShoppingCartProductController deleteShoppingCartProductController) {
        // Initialize all controllers here
        this.viewProductController = viewProductController;
        this.purchaseController = purchaseController;
        this.deleteShoppingCartProductController = deleteShoppingCartProductController;

        this.shoppingCartViewModel = shoppingCartViewModel;
        shoppingCartViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(shoppingCartViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        ArrayList<Product> listProducts = shoppingCartViewModel.getState().getListProducts();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (Product product : listProducts) {

            JButton viewButton = new JButton(product.getTitle());
            // dimension set as this for now but will likely get changed later
            viewButton.setPreferredSize(new Dimension(250, 50));
            viewButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            if (event.getSource().equals(viewButton)) {
                                User user = shoppingCartViewModel.getState().getUser();
                                try {
                                    viewProductController.execute(product, user) ;
                                } catch (SQLException e) {
                                    throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                }

                            }
                        }
                    }
            );
            viewButtons.add(viewButton);

            if (product.getState() == 0) {
                JButton checkoutButton = new JButton(shoppingCartViewModel.CHECKOUT_BUTTON_LABEL);
                // dimension set as this for now but will likely get changed later
                checkoutButton.setPreferredSize(new Dimension(100, 50));
                checkoutButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(checkoutButton)) {
                                    User user = shoppingCartViewModel.getState().getUser();
                                    try {
                                        purchaseController.execute(user, product) ;
                                    } catch (SQLException | IOException e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );
                primaryActionButtons.add(checkoutButton);

                JButton deleteButton = new JButton(shoppingCartViewModel.DELETE_BUTTON_LABEL);
                // dimension set as this for now but will likely get changed later
                deleteButton.setPreferredSize(new Dimension(100, 50));
                deleteButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(deleteButton)) {
                                    User user = shoppingCartViewModel.getState().getUser();
                                    try {
                                        deleteShoppingCartProductController.execute(user, product) ;
                                    } catch (SQLException | IOException e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );
                secondaryActionButtons.add(deleteButton);

                ShoppingCartSellingPanel productSellingPanel = new ShoppingCartSellingPanel(
                        viewButton, checkoutButton, deleteButton
                );
                this.add(productSellingPanel);

            }
            else if (product.getState() == 1) {
                JLabel pendingScheduleLabel = new JLabel(shoppingCartViewModel.PENDING_SELLER_SCHEDULE_LABEL);
                ShoppingCartSellerSelectPanel sellerSelectPanel = new ShoppingCartSellerSelectPanel(
                        viewButton, pendingScheduleLabel
                );
                this.add(sellerSelectPanel);

            }

            //TODO: FINISH IMPLEMENTING REST OF CASES
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
