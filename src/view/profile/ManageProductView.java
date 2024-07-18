package view.profile;

import entity.product.Product;
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

public class ManageProductView extends JFrame implements ActionListener, PropertyChangeListener {
    public final String viewName = "Product View";
    private final MainPageController mainPageController;
    private final ViewCreateProductController viewCreateProductController;
    private final ViewModifyProductController viewModifyProductController;
    private final ViewProductController viewProductController;
    private final DeleteProductController deleteProductController;
    private final GetSellerSchedulePageController getSellerSchedulePageController;
    private final ManageProductViewModel manageProductViewModel;
    private final JPanel mainPanel = new JPanel();

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;

    private final JButton addProduct;

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

        JPanel topBar = new TopBarSampleView(this.manageProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);

        manageProductViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(manageProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        updateMainPanel();

        this.add(new JScrollPane(mainPanel), BorderLayout.CENTER);

        JPanel buttons = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
        addProduct = new JButton(manageProductViewModel.ADD_BUTTON_LABEL);
        buttons.add(addProduct);

        addProduct.addActionListener(this);

        this.add(buttons, BorderLayout.NORTH);

    }

    public void updateMainPanel(){
        mainPanel.removeAll();

        for (Product product: manageProductViewModel.getState().getProduct()) {
            MangeSingleProductView panel = new MangeSingleProductView(manageProductViewModel.getState().getUser(),
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
        updateMainPanel();

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updateMainPanel();
        ManageProductState newState = (ManageProductState) evt.getNewValue();

        JPanel topBar = new TopBarSampleView(newState.getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);
    }
}
