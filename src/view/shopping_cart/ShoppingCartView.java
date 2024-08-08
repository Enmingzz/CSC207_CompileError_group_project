package view.shopping_cart;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;

import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;

// Import all controllers related to shopping_cart
import interface_adapter.shopping_cart.purchase.PurchaseController;
import interface_adapter.schedule.buyer_select_schedule.GetBuyerSchedulePageController;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import interface_adapter.view_product.non_logged_in_view.ViewProductController;
import interface_adapter.shopping_cart.delete.DeleteShoppingCartProductController;
import interface_adapter.shopping_cart.confirm.ConfirmController;
import interface_adapter.rating.GetRatePageController;

// Import all Controllers related to the top bar
import interface_adapter.logout.LogOutController;
import interface_adapter.profile.view_profile.ViewProfileController;
// import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.main_page.MainPageController;
import view.TopBarSampleView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
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
        title.setAlignmentY(Component.TOP_ALIGNMENT);

        ArrayList<Product> listProducts = shoppingCartViewModel.getState().getListProducts();

//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout(1, 1));

        this.setAlignmentY(Component.TOP_ALIGNMENT);



        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        this.add(title);

        topBar.setAlignmentY(TOP_ALIGNMENT);

        allProductsPanel = new AllProductsPanel(listProducts,
                shoppingCartViewModel,
                viewProductController,
                purchaseController,
                deleteShoppingCartProductController,
                getBuyerSchedulePageController,
                confirmController,
                getRatePageController);

        this.add(new JScrollPane(allProductsPanel));
        allProductsPanel.setAlignmentY(Component.TOP_ALIGNMENT);
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
                mainPageController), BorderLayout.NORTH);
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
                ), BorderLayout.NORTH);
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
