package view.shopping_cart;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;

import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;

// Import all controllers related to shopping_cart
import interface_adapter.shopping_cart.PurchaseController;
import interface_adapter.schedule.GetBuyerSchedulePageController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.ViewProductController;
import interface_adapter.shopping_cart.DeleteShoppingCartProductController;
import interface_adapter.shopping_cart.ConfirmController;
import interface_adapter.rating.GetRatePageController;

// Import all Controllers related to the top bar
import interface_adapter.logout.LogOutController;
import interface_adapter.profile.view_profile.ViewProfileController;
// import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.main_page.MainPageController;
import view.TopBarSampleView;


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
import java.util.Objects;

public class ShoppingCartView extends JPanel implements ActionListener, PropertyChangeListener {

    /**
     * The ShoppingCartView class is responsible for the layout of the shopping cart of each user.
     */

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
    private final GetBuyerSchedulePageController getBuyerSchedulePageController;
    private final ConfirmController confirmController;
    private final GetRatePageController getRatePageController;

    private final ShoppingCartController shoppingCartController;
    private final ViewProfileController viewProfileController;
    private final GetSearchPageController getSearchPageController;
    private final LogOutController logOutController;
    private final MainPageController mainPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private JPanel topBar;

    AllProductsPanel allProductsPanel;

    /**
     * Constructor for the ShoppingCartView class.
     *
     * @param shoppingCartViewModel the view model for the shopping cart view
     * @param viewProductController the controller for viewing products
     * @param purchaseController the controller for handling purchases
     * @param deleteShoppingCartProductController the controller for deleting products from the shopping cart
     * @param getBuyerSchedulePageController the controller for navigating to the buyer's schedule page
     * @param confirmController the controller for confirming actions
     * @param getRatePageController the controller for navigating to the rate page
     * @param shoppingCartController the controller for managing the shopping cart
     * @param viewProfileController the controller for viewing the profile page
     * @param getSearchPageController the controller for navigating to the search page
     * @param logOutController the controller for logging out
     * @param mainPageController the controller for navigating to the main page
     * @param viewSignupPageController the controller for navigating to the signup page
     * @param viewLoginPageController the controller for navigating to the login page
     */
    public ShoppingCartView(ShoppingCartViewModel shoppingCartViewModel,
                            ViewProductController viewProductController,
                            PurchaseController purchaseController,
                            DeleteShoppingCartProductController deleteShoppingCartProductController,
                            GetBuyerSchedulePageController getBuyerSchedulePageController,
                            ConfirmController confirmController,
                            GetRatePageController getRatePageController,
                            ShoppingCartController shoppingCartController,
                            ViewProfileController viewProfileController,
                            GetSearchPageController getSearchPageController,
                            LogOutController logOutController,
                            MainPageController mainPageController,
                            ViewSignupPageController viewSignupPageController,
                            ViewLoginPageController viewLoginPageController) {

        // Initialize all controllers here
        this.viewProductController = viewProductController;
        this.purchaseController = purchaseController;
        this.deleteShoppingCartProductController = deleteShoppingCartProductController;
        this.getBuyerSchedulePageController = getBuyerSchedulePageController;
        this.confirmController = confirmController;
        this.getRatePageController = getRatePageController;

        this.viewProfileController = viewProfileController;
        this.shoppingCartController = shoppingCartController;
        this.getSearchPageController = getSearchPageController;
        this.logOutController = logOutController;
        this.mainPageController = mainPageController;

        this.viewSignupPageController = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;

        this.shoppingCartViewModel = shoppingCartViewModel;
        shoppingCartViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(shoppingCartViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        ArrayList<Product> listProducts = shoppingCartViewModel.getState().getListProducts();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);

        allProductsPanel = new AllProductsPanel(listProducts,
                shoppingCartViewModel,
                viewProductController,
                purchaseController,
                deleteShoppingCartProductController,
                getBuyerSchedulePageController,
                confirmController,
                getRatePageController);

        this.add(allProductsPanel);


//        This is used originally for ShoppingCartView, but needed to be edited, kept as reference
//        for (Product product : listProducts) {
//
//            JButton viewButton = new JButton(product.getTitle());
//            // dimension set as this for now but will likely get changed later
//            viewButton.setPreferredSize(new Dimension(250, 50));
//            viewButton.addActionListener(
//                    new ActionListener() {
//                        public void actionPerformed(ActionEvent event) {
//                            if (event.getSource().equals(viewButton)) {
//                                User user = shoppingCartViewModel.getState().getUser();
//                                try {
//                                    viewProductController.execute(product, user) ;
//                                } catch (SQLException e) {
//                                    throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
//                                }
//
//                            }
//                        }
//                    }
//            );
//            viewButtons.add(viewButton);
//
//            String priceAsString = String.valueOf(product.getPrice());
//
//            JLabel priceLabel = new JLabel("$" + priceAsString);
//
//            if (product.getState() == 0) {
//                JButton checkoutButton = new JButton(shoppingCartViewModel.CHECKOUT_BUTTON_LABEL);
//                // dimension set as this for now but will likely get changed later
//                checkoutButton.setPreferredSize(new Dimension(100, 50));
//                checkoutButton.addActionListener(
//                        new ActionListener() {
//                            public void actionPerformed(ActionEvent event) {
//                                if (event.getSource().equals(checkoutButton)) {
//                                    User user = shoppingCartViewModel.getState().getUser();
//                                    try {
//                                        purchaseController.execute(user, product) ;
//                                    } catch (SQLException | IOException e) {
//                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
//                                    }
//
//                                }
//                            }
//                        }
//                );
//                primaryActionButtons.add(checkoutButton);
//
//                JButton deleteButton = new JButton(shoppingCartViewModel.DELETE_BUTTON_LABEL);
//                // dimension set as this for now but will likely get changed later
//                deleteButton.setPreferredSize(new Dimension(100, 50));
//                deleteButton.addActionListener(
//                        new ActionListener() {
//                            public void actionPerformed(ActionEvent event) {
//                                if (event.getSource().equals(deleteButton)) {
//                                    User user = shoppingCartViewModel.getState().getUser();
//                                    try {
//                                        deleteShoppingCartProductController.execute(user, product) ;
//                                    } catch (SQLException | IOException e) {
//                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
//                                    }
//
//                                }
//                            }
//                        }
//                );
//                secondaryActionButtons.add(deleteButton);
//
//                ShoppingCartSellingPanel productSellingPanel = new ShoppingCartSellingPanel(
//                        viewButton, priceLabel, checkoutButton, deleteButton
//                );
//                this.add(productSellingPanel);
//
//            }
//            else if (product.getState() == 1) {
//                JLabel pendingScheduleLabel = new JLabel(shoppingCartViewModel.PENDING_SELLER_SCHEDULE_LABEL);
//                ShoppingCartSellerSelectPanel sellerSelectPanel = new ShoppingCartSellerSelectPanel(
//                        viewButton, priceLabel, pendingScheduleLabel
//                );
//                this.add(sellerSelectPanel);
//
//            }
//
//            else if (product.getState() == 2) {
//                JButton scheduleButton = new JButton(shoppingCartViewModel.BUYER_SCHEDULES_BUTTON_LABEL);
//                // dimension set as this for now but will likely get changed later
//                scheduleButton.setPreferredSize(new Dimension(200, 50));
//                scheduleButton.addActionListener(
//                        new ActionListener() {
//                            public void actionPerformed(ActionEvent event) {
//                                if (event.getSource().equals(scheduleButton)) {
//                                    User user = shoppingCartViewModel.getState().getUser();
//
//                                    // TODO: IMPLEMENT THIS METHOD FOR BUYER SELECT SCHEDULE USE CASE
//                                    System.out.println("BuyerSelectSchedule to be executed; not implemented yet");
////                                    try {
////                                        buyerSelectScheduleController.execute(user, product);
////                                    } catch (SQLException | IOException e) {
////                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
////                                    }
//
//                                }
//                            }
//                        }
//                );
//                primaryActionButtons.add(scheduleButton);
//
//                ShoppingCartBuyerSelectPanel buyerSelectPanel = new ShoppingCartBuyerSelectPanel(
//                        viewButton, priceLabel, scheduleButton
//                );
//                this.add(buyerSelectPanel);
//
//            }
//
//            else if (product.getState() == 3) {
//                JButton confirmButton = new JButton(shoppingCartViewModel.RECEIVED_PRODUCT_BUTTON_LABEL);
//                // dimension set as this for now but will likely get changed later
//                confirmButton.setPreferredSize(new Dimension(200, 50));
//                confirmButton.addActionListener(
//                        new ActionListener() {
//                            public void actionPerformed(ActionEvent event) {
//                                if (event.getSource().equals(confirmButton)) {
//                                    User user = shoppingCartViewModel.getState().getUser();
//
//                                    // TODO: IMPLEMENT THIS METHOD FOR CONFIRMATION USE CASE
//                                    System.out.println("Confirmation to be executed; not implemented yet");
////                                    try {
////                                        confirmController.execute(user, product);
////                                    } catch (SQLException | IOException e) {
////                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
////                                    }
//
//                                }
//                            }
//                        }
//                );
//                primaryActionButtons.add(confirmButton);
//
//
//                ShoppingCartConfirmationPanel confirmationPanel = new ShoppingCartConfirmationPanel(
//                        viewButton, priceLabel, confirmButton
//                );
//                this.add(confirmationPanel);
//            }
//
//            else if (product.getState() == 4) {
//
//                JButton ratingButton = new JButton(shoppingCartViewModel.RATE_PRODUCT_BUTTON_LABEL);
//                // dimension set as this for now but will likely get changed later
//                ratingButton.setPreferredSize(new Dimension(200, 50));
//                ratingButton.addActionListener(
//                        new ActionListener() {
//                            public void actionPerformed(ActionEvent event) {
//                                if (event.getSource().equals(ratingButton)) {
//                                    User user = shoppingCartViewModel.getState().getUser();
//
//                                    // TODO: IMPLEMENT THIS METHOD FOR RATE PRODUCT SCHEDULE USE CASE
//                                    System.out.println("RateProduct to be executed; not implemented yet");
////                                    try {
////                                        ratingController.execute(user, product);
////                                    } catch (SQLException | IOException e) {
////                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
////                                    }
//
//                                }
//                            }
//                        }
//                );
//                primaryActionButtons.add(ratingButton);
//
//                ShoppingCartRatingPanel ratingPanel = new ShoppingCartRatingPanel(
//                        viewButton, priceLabel, ratingButton
//                );
//                this.add(ratingPanel);
//            }
//
//        }
//
//        String totalPriceAsString = String.valueOf(shoppingCartViewModel.getState().getTotalPrice());
//
//        JLabel totalPriceLabel = new JLabel("$" + totalPriceAsString);
//
//        TotalPricePanel totalPricePanel = new TotalPricePanel(
//            totalPriceLabel
//        );
//
//        this.add(totalPricePanel);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ShoppingCartState state = (ShoppingCartState) evt.getNewValue();

        ArrayList<Product> listProducts = state.getListProducts();

        topBar.removeAll();
        topBar.add(new TopBarSampleView(shoppingCartViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();


        allProductsPanel.removeAll();
        allProductsPanel.add(new view.shopping_cart.AllProductsPanel(listProducts, shoppingCartViewModel,
                viewProductController,
                purchaseController,
                deleteShoppingCartProductController,
                getBuyerSchedulePageController,
                confirmController,
                getRatePageController
                ));
        allProductsPanel.repaint();
        allProductsPanel.revalidate();

        if (!Objects.equals(state.getErrorMessage(), "")) {
            JOptionPane.showMessageDialog(this, state.getErrorMessage());
        }

//
//        JPanel topBar = new TopBarSampleView(state.getUser(),
//                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
//        this.add(topBar);
    }


}
