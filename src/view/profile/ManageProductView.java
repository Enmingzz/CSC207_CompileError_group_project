package view.profile;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.*;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.schedule.GetSellerSchedulePageController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.ViewProductController;
import view.TopBarSampleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * A view for managing products, which extends JFrame and implements ActionListener and PropertyChangeListener.
 */
public class ManageProductView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Manage Product View";
    private final MainPageController mainPageController;
    private final ViewCreateProductController viewCreateProductController;
    private final ViewModifyProductController viewModifyProductController;
    private final ViewProductController viewProductController;
    private final DeleteProductController deleteProductController;
    private final GetSellerSchedulePageController getSellerSchedulePageController;
    private final ManageProductViewModel manageProductViewModel;
    private final JPanel mainPanel = new JPanel();
    private JLabel message = new JLabel("");

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;

    private final JButton addProduct;
    private JPanel topBar;

    /**
     * Constructs a ManageProductView with the specified controllers and view models.
     *
     * @param mainPageController              the main page controller
     * @param viewCreateProductController     the controller for creating a product
     * @param deleteProductController         the controller for deleting a product
     * @param viewModifyProductController     the controller for modifying a product
     * @param manageProductViewModel          the view model for managing products
     * @param viewProductController           the controller for viewing a product
     * @param getSellerSchedulePageController the controller for getting the seller's schedule page
     * @param getSearchPageController         the controller for getting the search page
     * @param viewSignupPageController        the controller for viewing the signup page
     * @param viewLoginPageController         the controller for viewing the login page
     * @param shoppingCartController          the controller for managing the shopping cart
     * @param logOutController                the controller for logging out
     * @param viewProfileController           the controller for viewing the profile
     */

    public ManageProductView(MainPageController mainPageController, ViewCreateProductController viewCreateProductController,
                             DeleteProductController deleteProductController, ViewModifyProductController viewModifyProductController,
                             ManageProductViewModel manageProductViewModel, ViewProductController viewProductController,
                             GetSellerSchedulePageController getSellerSchedulePageController,
                             GetSearchPageController getSearchPageController,
                             ViewSignupPageController viewSignupPageController,
                             ViewLoginPageController viewLoginPageController,
                             ShoppingCartController shoppingCartController,
                             LogOutController logOutController,
                             ViewProfileController viewProfileController){
        this.mainPageController = mainPageController;
        this.viewCreateProductController = viewCreateProductController;
        this.viewProductController = viewProductController;
        this.deleteProductController = deleteProductController;
        this.viewModifyProductController = viewModifyProductController;
        this.getSellerSchedulePageController = getSellerSchedulePageController;
        this.manageProductViewModel = manageProductViewModel;

        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;

        this.setLayout(new BorderLayout());

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);
        this.add(topBar, BorderLayout.NORTH);

        manageProductViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(manageProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        updateMainPanel();

        this.add(new JScrollPane(mainPanel), BorderLayout.CENTER);
        this.add(message, BorderLayout.SOUTH);

        JPanel buttons = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
        addProduct = new JButton(manageProductViewModel.ADD_BUTTON_LABEL);
        buttons.add(addProduct);

        addProduct.addActionListener(this);

        this.add(buttons, BorderLayout.EAST);
    }

    /**
     * Updates the main panel to reflect the current state of the manageProductViewModel.
     */

    public void updateMainPanel(){
        mainPanel.removeAll();

        for (Product product: manageProductViewModel.getState().getProduct()) {
            ManageSingleProductView panel = new ManageSingleProductView(manageProductViewModel.getState().getUser(),
                    product, manageProductViewModel, viewProductController,
                    viewModifyProductController, deleteProductController, getSellerSchedulePageController);
            mainPanel.add(panel);
            mainPanel.add(Box.createVerticalStrut(10));
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            viewCreateProductController.execute(manageProductViewModel.getState().getUser());
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ManageProductState newState = (ManageProductState) evt.getNewValue();
        manageProductViewModel.setState(newState);

        updateMainPanel();
        this.remove(topBar);
        topBar = new TopBarSampleView(this.manageProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        message.setText(manageProductViewModel.getState().getModifyProductMessage());

        if (newState.getModifyProductMessage() != null) {
            JOptionPane.showMessageDialog(this, newState.getModifyProductMessage());
        }
        newState.setModifyProductMessage(null);
        manageProductViewModel.setState(newState);
    }
}
