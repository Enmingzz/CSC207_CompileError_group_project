package view.profile;

import entity.product.Product;
import entity.user.User;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.DeleteProductController;
import interface_adapter.modify_product.ViewModifyProductController;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.schedule.GetSellerSchedulePageController;
import interface_adapter.schedule.SellerSelectScheduleController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.ViewProductController;
import view.TopBarSampleView;
import view.profile.ProfileHelper.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MangeSingleProductView extends JPanel implements PropertyChangeListener {
    private final Product product;
    private final User user;
    private final ManageProductViewModel manageProductViewModel;
    private final ViewModifyProductController viewModifyProductController;
    private final ViewProductController viewProductController;
    private final DeleteProductController deleteProductController;
    private final GetSellerSchedulePageController getSellerSchedulePageController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private JLabel titleViewField = new JLabel();
    private JLabel ratingViewField = new JLabel();
    private JLabel stateViewField = new JLabel();
    private JLabel priceViewField = new JLabel();
    private JLabel imageViewField = new JLabel();

    private final JButton modifyProduct;
    private final JButton deleteProduct;
    private final JButton showDetil;
    private final JButton selectTime;

    public MangeSingleProductView(User user, Product product, ManageProductViewModel manageProductViewModel,
                                  ViewProductController viewProductController,
                                  ViewModifyProductController viewModifyProductController,
                                  DeleteProductController deleteProductController,
                                  GetSellerSchedulePageController getSellerSchedulePageController,
                                  GetSearchPageController getSearchPageController,
                                  ViewSignupPageController viewSignupPageController,
                                  ViewLoginPageController viewLoginPageController,
                                  ShoppingCartController shoppingCartController,
                                  LogOutController logOutController,
                                  ViewProfileController viewProfileController,
                                  MainPageController mainPageController) {
        this.setLayout(new BorderLayout());
        this.product = product;
        this.user = user;
        this.manageProductViewModel = manageProductViewModel;
        this.viewModifyProductController = viewModifyProductController;
        this.viewProductController = viewProductController;
        this.deleteProductController = deleteProductController;

        //top bar initialize
        this.getSellerSchedulePageController = getSellerSchedulePageController;
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        JPanel topBar = new TopBarSampleView(this.manageProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);

        titleViewField.setText(product.getTitle());
        ratingViewField.setText(String.valueOf(product.getRating()));
        imageViewField.setIcon(new ImageIcon(product.getImage()));
        priceViewField.setText(product.getPrice() + " $");

        if (product.getState() == 0){
            stateViewField.setText("product is being sold");
        } else if (product.getState() == 1) {
            stateViewField.setText("scheduling a meeting time with buyer");
        } else if (product.getState() == 2) {
            stateViewField.setText("your meeting time scheduled");
        } else if (product.getState() == 3) {
            stateViewField.setText("buyer has chosen a meeting time");
        } else if (product.getState() == 4) {
            stateViewField.setText("Buyer has confirmed that they have received the product");
        } else {
            stateViewField.setText("product has been sold and buyer has rated the product");
        }

        stateViewField.setText(String.valueOf(product.getState()));

        ProfileLabelTextPanel titleInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.PRODUCTTITLE_LABEL),
                titleViewField);
        ProfileLabelTextPanel ratingInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.RATING_LABEL),
                ratingViewField);
        ProfileLabelTextPanel stateInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.STATE_LABEL),
                stateViewField);
        ProfileLabelTextPanel imageInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.IMAGE_LABEL),
                imageViewField);
        ProfileLabelTextPanel priceInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.PRICE_LABEL),
                priceViewField);

        modifyProduct = new JButton(manageProductViewModel.MODIFY_BUTTON_LABEL);
        deleteProduct = new JButton(manageProductViewModel.DELETE_BUTTON_LABEL);
        showDetil = new JButton(manageProductViewModel.SHOW_BUTTON_LABEL);
        selectTime = new JButton(manageProductViewModel.SELECTTIME_BUTTON_LABEL);


        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(titleInfo);

        JPanel tagsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tagsPanel.add(stateInfo);

        JPanel infoPanel = new JPanel(new GridLayout(4, 2));
        infoPanel.add(ratingInfo);
        infoPanel.add(imageInfo);
        infoPanel.add(priceInfo);

        JPanel buttonPanel = new JPanel((new FlowLayout(FlowLayout.RIGHT)));

        if (product.getState() == 0){
            buttonPanel.add(modifyProduct);
            buttonPanel.add(deleteProduct);
        }

        if (product.getState() == 1){
            buttonPanel.add(selectTime);
        }

        buttonPanel.add(showDetil);

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(tagsPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        modifyProduct.addActionListener(new ModifyProductListener(this.viewModifyProductController, product, user));
        deleteProduct.addActionListener(new DeleteProductListener(this.deleteProductController, product, user));
        showDetil.addActionListener(new ShowProductListener(this.viewProductController, product, user));
        selectTime.addActionListener(new SelectTimeListener(this.getSellerSchedulePageController, product, user));

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ManageProductState state = (ManageProductState) evt.getNewValue();
        manageProductViewModel.setState(state);

        JPanel topBar = new TopBarSampleView(state.getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);
    }
}
