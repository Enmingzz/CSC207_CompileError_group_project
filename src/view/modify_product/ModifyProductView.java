package view.modify_product;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.ModifyProductController;
import interface_adapter.modify_product.ViewModifyProductState;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.BuyerViewProductState;
import view.TopBarSampleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ModifyProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "view modify product";

    private final ViewModifyProductViewModel viewModifyProductViewModel;

    ModifyProductController modifyProductController;
    ManageProductController manageProductController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private final JButton changeProduct;
    private final JButton cancel;
    private JPanel topBar;
    JPanel contentPanel = new JPanel();

    JPanel productInformation = new JPanel();
    ImagePanel displayImage;
    JPanel productModification;

    private final JTextField description = new JTextField();
    private final JTextField price = new JTextField();

    public ModifyProductView( ViewModifyProductViewModel viewModifyProductViewModel,
                              ModifyProductController modifyProductController,
                              ManageProductController manageProductController,
                              MainPageController mainPageController,
                              GetSearchPageController getSearchPageController,
                              ViewSignupPageController viewSignupPageController,
                              ViewLoginPageController viewLoginPageController,
                              ShoppingCartController shoppingCartController,
                              LogOutController logOutController,
                              ViewProfileController viewProfileController
                              ) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
        viewModifyProductViewModel.addPropertyChangeListener(this);
        this.modifyProductController = modifyProductController;
        this.manageProductController = manageProductController;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        this.setLayout(new BorderLayout());

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);

        //TODO check if this image works
        displayImage = (viewModifyProductViewModel.getState().getProduct() == null)?
                new ImagePanel( new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB)):
                new ImagePanel(viewModifyProductViewModel.getState().getProduct().getImage());

        JLabel _title = new JLabel(viewModifyProductViewModel.TITLE_LABEL);
        _title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        changeProduct = new JButton(viewModifyProductViewModel.CHANGEPRODUCT_BUTTON_LABEL);
        cancel = new JButton(viewModifyProductViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(changeProduct);
        buttons.add(cancel);

        //(1) show the product information while
        Product product = viewModifyProductViewModel.getState().getProduct();
        final JLabel titleLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
        final JLabel title = (product == null)? new JLabel(""): new JLabel(product.getTitle());
        final JLabel descriptionLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
        if (product != null) {
            description.setText(product.getDescription());
        }
        final JLabel priceLabel = new JLabel(viewModifyProductViewModel.PRODUCT_PRICE_LABEL);
        if (product != null) {
            price.setText(String.valueOf(product.getPrice()));
        }
        final JLabel eTransferEmailLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ETRANSFER_EMAIL_LABEL);
        final JLabel eTransferEmail = (product == null)? new JLabel(""): new JLabel(product.geteTransferEmail());
        final JLabel addressLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ADDRESS);
        final JLabel address = (product == null)? new JLabel(""): new JLabel(product.getAddress());
        final JLabel tagsLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TAGS);
        String tagsString = (product == null)? "": String.join(", ", product.getListTags());
        final JLabel tags = new JLabel(tagsString);

//        productInformation = new ModifyProductTextPanel( titleLabel,  title,
//                 descriptionLabel,  description,  priceLabel,  price,
//                 eTransferEmailLabel,  eTransferEmail,  addressLabel,  address,
//                 tagsLabel, tags);

        productInformation.setLayout(new BoxLayout(productInformation, BoxLayout.Y_AXIS));
        productInformation.add(titleLabel);
        productInformation.add(title);
        productInformation.add(descriptionLabel);
        productInformation.add(description);
        productInformation.add(priceLabel);
        productInformation.add(price);
        productInformation.add(eTransferEmailLabel);
        productInformation.add(eTransferEmail);
        productInformation.add(addressLabel);
        productInformation.add(address);
        productInformation.add(tagsLabel);
        productInformation.add(tags);

        //create all the different panels

        class DescriptionInputFieldListener implements KeyListener{
            @Override
            public void keyTyped(KeyEvent e) {
                ViewModifyProductState state = viewModifyProductViewModel.getState();
                state.setDescription(description.getText() + e.getKeyChar());
                viewModifyProductViewModel.setState(state);            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        }

        class PriceInputFieldListener implements KeyListener{
            @Override
            public void keyTyped(KeyEvent e) {
                ViewModifyProductState state = viewModifyProductViewModel.getState();
                state.setPrice(price.getText() + e.getKeyChar());
                viewModifyProductViewModel.setState(state);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        }

        class ChangeProductListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(changeProduct)) {
                    try {
                        modifyProductController.execute(viewModifyProductViewModel.getState().getUser(), viewModifyProductViewModel.getState().getProduct(),
                                description.getText(), price.getText());
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        class CancelButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(cancel)) {
                    try {
                        ViewModifyProductState state = viewModifyProductViewModel.getState();
                        User user = state.getUser();
                        manageProductController.execute(user);
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        changeProduct.addActionListener(new ChangeProductListener());
        cancel.addActionListener(new CancelButtonListener());
        description.addKeyListener(new DescriptionInputFieldListener());
        price.addKeyListener(new PriceInputFieldListener());

        //TODO think about the input fields and display fields

        contentPanel.setLayout(new BorderLayout());

        // Create product information panel

        // Add product modification controls
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(changeProduct);
        controlPanel.add(cancel);


        // Assemble the UI
        contentPanel.add(displayImage, BorderLayout.WEST);
        contentPanel.add(productInformation, BorderLayout.CENTER);
        contentPanel.add(controlPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(contentPanel, BorderLayout.CENTER);
        this.add(topBar, BorderLayout.NORTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        topBar.removeAll();
        topBar.add(new TopBarSampleView(viewModifyProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();

        ViewModifyProductState state = (ViewModifyProductState) evt.getNewValue();
        viewModifyProductViewModel.setState(state);

        Product product = state.getProduct();
        productInformation.removeAll();
        contentPanel.remove(displayImage);
        displayImage = new ImagePanel(viewModifyProductViewModel.getState().getProduct().getImage());

        final JLabel titleLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
        final JLabel title = new JLabel(product.getTitle());
        final JLabel descriptionLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
        final JTextField description = new JTextField(product.getDescription());
        final JLabel priceLabel = new JLabel(viewModifyProductViewModel.PRODUCT_PRICE_LABEL);
        final JTextField price = new JTextField(String.valueOf(product.getPrice()));
        final JLabel eTransferEmailLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ETRANSFER_EMAIL_LABEL);
        final JLabel eTransferEmail = new JLabel(product.geteTransferEmail());
        final JLabel addressLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ADDRESS);
        final JLabel address = new JLabel(product.getAddress());
        final JLabel tagsLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TAGS);
        String tagsString = String.join(", ", product.getListTags());
        final JLabel tags = new JLabel(tagsString);

//        productInformation = new ModifyProductTextPanel( titleLabel,  title,
//                descriptionLabel,  description,  priceLabel,  price,
//                eTransferEmailLabel,  eTransferEmail,  addressLabel,  address,
//                tagsLabel,  tags);

        productInformation.add(titleLabel);
        productInformation.add(title);
        productInformation.add(descriptionLabel);
        productInformation.add(description);
        productInformation.add(priceLabel);
        productInformation.add(price);
        productInformation.add(eTransferEmailLabel);
        productInformation.add(eTransferEmail);
        productInformation.add(addressLabel);
        productInformation.add(address);
        productInformation.add(tagsLabel);
        productInformation.add(tags);

        contentPanel.add(displayImage, BorderLayout.WEST);

        contentPanel.repaint();
        contentPanel.revalidate();

//        if (state.getModifyProductMessage() != "" || state.getModifyProductMessage() == null) {
//            JOptionPane.showMessageDialog(this, state.getModifyProductMessage());
//        }
//        JOptionPane.showMessageDialog(this, state.getDescription());


//        setFields(state);

    }

//    private void setFields(ViewModifyProductState state) {
//        description
//    }
}


