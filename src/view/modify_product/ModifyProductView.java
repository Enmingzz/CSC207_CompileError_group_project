package view.modify_product;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.*;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.BuyerViewProductState;
import view.TopBarSampleView;
import view.profile.ProfileHelper.ModifyLabelTextPanel;
import view.view_product.ProductInfoLabelTextPanel;

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
    private final UploadImageController uploadImageController;
    private final MainPageController mainPageController;

    private final JTextField addressInputField = new JTextField(20);
    private final JTextField descriptionInputField = new JTextField(100);
    private final JTextField titleInputField = new JTextField(20);
    private final JTextField priceInputField = new JTextField(15);
    private final JTextField emailInputField = new JTextField(20);
    private JLabel imageLabel = new JLabel();

    ModifyProductTextPanel addressInfo = new ModifyProductTextPanel();
    ModifyProductTextPanel descriptionInfo = new ModifyProductTextPanel();
    ModifyProductTextPanel titleInfo = new ModifyProductTextPanel();
    ModifyProductTextPanel priceInfo = new ModifyProductTextPanel();
    ModifyProductTextPanel emailInfo = new ModifyProductTextPanel();

    private ProductInfoLabelTextPanel oldDescriptionInfo;
    private ProductInfoLabelTextPanel oldPriceInfo;
    private ProductInfoLabelTextPanel oldTitleInfo;
    private ProductInfoLabelTextPanel oldAddressInfo;
    private ProductInfoLabelTextPanel oldEmialInfo;

    private Image image = null;

    private final JButton changeProduct;
    private final JButton cancel;
    private final JButton uploadImageButton;
    private JPanel topBar;
//    private final JPanel contentPanel = new JPanel();
    private final JPanel productModification = new JPanel();

    private JPanel signleModfiyPanelAddress = new JPanel();
    private JPanel signleModfiyPanelDescription = new JPanel();
    private JPanel signleModfiyPanelTitle = new JPanel();
    private JPanel signleModfiyPanelPrice = new JPanel();
    private JPanel signleModfiyPanelEmail = new JPanel();

//    ImagePanel displayImage;

//    private final JTextField description = new JTextField();
//    private final JTextField price = new JTextField();
// =======
//     private JTextField description = new JTextField();
//     private JTextField price = new JTextField();
// >>>>>>> main

    public ModifyProductView( ViewModifyProductViewModel viewModifyProductViewModel,
                              ModifyProductController modifyProductController,
                              ManageProductController manageProductController,
                              MainPageController mainPageController,
                              GetSearchPageController getSearchPageController,
                              ViewSignupPageController viewSignupPageController,
                              ViewLoginPageController viewLoginPageController,
                              ShoppingCartController shoppingCartController,
                              LogOutController logOutController,
                              ViewProfileController viewProfileController,
                              UploadImageController uploadImageController
                              ) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
        viewModifyProductViewModel.addPropertyChangeListener(this);
        this.modifyProductController = modifyProductController;
        this.manageProductController = manageProductController;
        this.uploadImageController = uploadImageController;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        viewModifyProductViewModel.addPropertyChangeListener(this);


        this.setLayout(new BorderLayout());

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);
        this.add(topBar, BorderLayout.NORTH);

        //TODO check if this image works
//        displayImage = (viewModifyProductViewModel.getState().getProduct() == null)?
//                new ImagePanel( new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB)):
//                new ImagePanel(viewModifyProductViewModel.getState().getProduct().getImage());

        JLabel _title = new JLabel(viewModifyProductViewModel.TITLE_LABEL);
        _title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        changeProduct = new JButton(viewModifyProductViewModel.CHANGEPRODUCT_BUTTON_LABEL);
        cancel = new JButton(viewModifyProductViewModel.CANCEL_BUTTON_LABEL);
        uploadImageButton = new JButton(viewModifyProductViewModel.UPDATE_IMAGE_BUTTON_LABEL);

        buttons.add(uploadImageButton);
        buttons.add(changeProduct);
        buttons.add(cancel);

        //(1) show the product information while
        Product product = viewModifyProductViewModel.getState().getProduct();
        final JLabel description = new JLabel();
        final JLabel title = new JLabel();
        final JLabel email = new JLabel();
        final JLabel address = new JLabel();
        final JLabel price = new JLabel();

//        final JLabel titleLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
//        final JLabel title = (product == null)? new JLabel(""): new JLabel(product.getTitle());
//        final JLabel descriptionLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
//        if (product != null) {
//            description.setText(product.getDescription());
//        }
//        final JLabel priceLabel = new JLabel(viewModifyProductViewModel.PRODUCT_PRICE_LABEL);
//        if (product != null) {
//            price.setText(String.valueOf(product.getPrice()));
//        }
//        final JLabel eTransferEmailLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ETRANSFER_EMAIL_LABEL);
//        final JLabel eTransferEmail = (product == null)? new JLabel(""): new JLabel(product.geteTransferEmail());
//        final JLabel addressLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ADDRESS);
//        final JLabel address = (product == null)? new JLabel(""): new JLabel(product.getAddress());
//        final JLabel tagsLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TAGS);
//        String tagsString = (product == null)? "": String.join(", ", product.getListTags());
//        final JLabel tags = new JLabel(tagsString);

//        productInformation = new ModifyProductTextPanel( titleLabel,  title,
//                 descriptionLabel,  description,  priceLabel,  price,
//                 eTransferEmailLabel,  eTransferEmail,  addressLabel,  address,
//                 tagsLabel, tags);

        oldDescriptionInfo = new ProductInfoLabelTextPanel(new JLabel(viewModifyProductViewModel.OLD_DESCRIPTION_LABEL), description);
        oldAddressInfo = new ProductInfoLabelTextPanel(new JLabel(viewModifyProductViewModel.OLD_ADDRESS_LABEL), address);
        oldTitleInfo = new ProductInfoLabelTextPanel(new JLabel(viewModifyProductViewModel.OLD_TITLE_LABEL), title);
        oldPriceInfo = new ProductInfoLabelTextPanel(new JLabel(viewModifyProductViewModel.OLD_PRICE_LABEL), price);
        oldEmialInfo = new ProductInfoLabelTextPanel(new JLabel(viewModifyProductViewModel.OLD_EMAIL_LABEL), email);

        addressInfo.setText(new JLabel(viewModifyProductViewModel.PRODUCT_ADDRESS), addressInputField);
        descriptionInfo.setText(new JLabel(viewModifyProductViewModel.PRODUCT_DESCRIPTION_LABEL), descriptionInputField);
        titleInfo.setText(new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL), titleInputField);
        priceInfo.setText(new JLabel(viewModifyProductViewModel.PRODUCT_PRICE_LABEL), priceInputField);
        emailInfo.setText(new JLabel(viewModifyProductViewModel.PRODUCT_ETRANSFER_EMAIL_LABEL), emailInputField);

        productModification.setLayout(new BoxLayout(productModification, BoxLayout.Y_AXIS));
        productModification.add(_title);

        signleModfiyPanelAddress.setLayout(new BoxLayout(signleModfiyPanelAddress, BoxLayout.Y_AXIS));
        signleModfiyPanelAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        signleModfiyPanelDescription.setLayout(new BoxLayout(signleModfiyPanelDescription, BoxLayout.Y_AXIS));
        signleModfiyPanelDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        signleModfiyPanelTitle.setLayout(new BoxLayout(signleModfiyPanelTitle, BoxLayout.Y_AXIS));
        signleModfiyPanelTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        signleModfiyPanelPrice.setLayout(new BoxLayout(signleModfiyPanelPrice, BoxLayout.Y_AXIS));
        signleModfiyPanelPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        signleModfiyPanelEmail.setLayout(new BoxLayout(signleModfiyPanelEmail, BoxLayout.Y_AXIS));
        signleModfiyPanelEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        signleModfiyPanelTitle.add(oldTitleInfo);
        signleModfiyPanelTitle.add(titleInfo);
        productModification.add(signleModfiyPanelTitle);

        signleModfiyPanelDescription.add(oldDescriptionInfo);
        signleModfiyPanelDescription.add(descriptionInfo);
        productModification.add(signleModfiyPanelDescription);

        signleModfiyPanelAddress.add(oldAddressInfo);
        signleModfiyPanelAddress.add(addressInfo);
        productModification.add(signleModfiyPanelAddress);

        signleModfiyPanelPrice.add(oldPriceInfo);
        signleModfiyPanelPrice.add(priceInfo);
        productModification.add(signleModfiyPanelPrice);

        signleModfiyPanelEmail.add(oldEmialInfo);
        signleModfiyPanelEmail.add(emailInfo);
        productModification.add(signleModfiyPanelEmail);

        productModification.add(imageLabel);

        //create all the different panels
//
//        class TitleInputFieldListener implements KeyListener {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                ViewModifyProductState state = viewModifyProductViewModel.getState();
//                state.setTitle(titleInputField.getText() + e.getKeyChar());
//                viewModifyProductViewModel.setState(state);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        }
//        ;
//        class DescriptionInputFieldListener implements KeyListener {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                ViewModifyProductState state = viewModifyProductViewModel.getState();
//                state.setDescription(descriptionInputField.getText() + e.getKeyChar());
//                viewModifyProductViewModel.setState(state);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        }
//        ;
//        class PriceInputFieldListener implements KeyListener {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                ViewModifyProductState state = viewModifyProductViewModel.getState();
//                state.setPrice(priceInputField.getText() + e.getKeyChar());
//                viewModifyProductViewModel.setState(state);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        };
//        class ETransferEmailInputFieldListener implements KeyListener {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                ViewModifyProductState state = viewModifyProductViewModel.getState();
//                state.setEmail(emailInputField.getText() + e.getKeyChar());
//                viewModifyProductViewModel.setState(state);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        };
//        class AddressInputFieldListener implements KeyListener {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                ViewModifyProductState state = viewModifyProductViewModel.getState();
//                state.setAddress(addressInputField.getText() + e.getKeyChar());
//                viewModifyProductViewModel.setState(state);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        };

        class ChangeProductListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(changeProduct)) {
                    try {
                        if (image instanceof BufferedImage || image == null) {
                            modifyProductController.execute(
                                    viewModifyProductViewModel.getState().getUser(),
                                    viewModifyProductViewModel.getState().getProduct(),
                                    descriptionInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().getDescription():
                                            descriptionInputField.getText(),
                                    priceInputField.getText().isEmpty()?
                                            String.valueOf(viewModifyProductViewModel.getState().getProduct().getPrice()):
                                            priceInputField.getText(),
                                    addressInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().getAddress():
                                            addressInputField.getText(),
                                    titleInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().getTitle():
                                            titleInputField.getText(),
                                    emailInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().geteTransferEmail():
                                            emailInputField.getText(),
                                    image);
                        }
                        else {
                            // Create a BufferedImage with the same width, height, and type as the original Image
                            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
                                    image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

                            // Draw the Image onto the BufferedImage
                            Graphics2D bGr = bufferedImage.createGraphics();
                            bGr.drawImage(image, 0, 0, null);
                            bGr.dispose();

                            modifyProductController.execute(
                                    viewModifyProductViewModel.getState().getUser(),
                                    viewModifyProductViewModel.getState().getProduct(),
                                    descriptionInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().getDescription():
                                            descriptionInputField.getText(),
                                    priceInputField.getText().isEmpty()?
                                            String.valueOf(viewModifyProductViewModel.getState().getProduct().getPrice()):
                                            priceInputField.getText(),
                                    addressInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().getAddress():
                                            addressInputField.getText(),
                                    titleInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().getTitle():
                                            titleInputField.getText(),
                                    emailInputField.getText().isEmpty()?
                                            viewModifyProductViewModel.getState().getProduct().geteTransferEmail():
                                            emailInputField.getText(),
                                    (Image) bufferedImage);
                        }
                        descriptionInputField.setText("");
                        titleInputField.setText("");
                        addressInputField.setText("");
                        priceInputField.setText("");
                        emailInputField.setText("");

// =======
//                         //TODO delete later this is to test if the input data is correct for the change product used case
//                         System.out.println("description: " + description.getText());
//                         System.out.println("price: " + viewModifyProductViewModel.getState().getPrice());

//                         modifyProductController.execute(viewModifyProductViewModel.getState().getUser(), viewModifyProductViewModel.getState().getProduct(),
//                                 viewModifyProductViewModel.getState().getDescription(), viewModifyProductViewModel.getState().getPrice());
// >>>>>>> main
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
                        descriptionInputField.setText("");
                        titleInputField.setText("");
                        addressInputField.setText("");
                        priceInputField.setText("");
                        emailInputField.setText("");
                        manageProductController.execute(user);

                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        class uploadImageButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(uploadImageButton)) {
                    uploadImageController.execute();
                    ImageIcon imageIcon = new ImageIcon(viewModifyProductViewModel.getState().getPath());
                    image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    imageLabel.setIcon(scaledIcon);
                    ViewModifyProductState viewModifyProductState = viewModifyProductViewModel.getState();
                    viewModifyProductState.setImage(image);
                    viewModifyProductViewModel.setState(viewModifyProductState);
                }
            }
        }

        changeProduct.addActionListener(new ChangeProductListener());
        cancel.addActionListener(new CancelButtonListener());
        uploadImageButton.addActionListener(new uploadImageButtonListener());

//        descriptionInputField.addKeyListener(new DescriptionInputFieldListener());
//        titleInputField.addKeyListener(new TitleInputFieldListener());
//        addressInputField.addKeyListener(new AddressInputFieldListener());
//        priceInputField.addKeyListener(new PriceInputFieldListener());
//        emailInputField.addKeyListener(new ETransferEmailInputFieldListener());

        //TODO think about the input fields and display fields

//        contentPanel.setLayout(new BorderLayout());
//
//        // Create product information panel
//
//        // Add product modification controls
//        JPanel controlPanel = new JPanel();
//        controlPanel.setLayout(new FlowLayout());
//        controlPanel.add(changeProduct);
//        controlPanel.add(cancel);


        // Assemble the UI
//        contentPanel.add(displayImage, BorderLayout.WEST);
//        contentPanel.add(productInformation, BorderLayout.CENTER);
//        contentPanel.add(controlPanel, BorderLayout.SOUTH);

//        this.setLayout(new BorderLayout());
//        this.add(contentPanel, BorderLayout.CENTER);
//        this.add(topBar, BorderLayout.NORTH);
        this.setLayout(new BorderLayout());

        this.add(productModification, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
        this.add(new JPanel(), BorderLayout.WEST);
        this.add(new JPanel(), BorderLayout.EAST);
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
//        viewModifyProductViewModel.setState(state);

        if (Objects.equals(state.getMessage(), "You didn't Change any thing!")) {
            JOptionPane.showMessageDialog(this, state.getMessage());
        }
        state.setMessage("");

        Product product = state.getProduct();
//        displayImage = new ImagePanel(viewModifyProductViewModel.getState().getProduct().getImage());

//        final JLabel titleLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
        final JLabel title = new JLabel(product.getTitle());
//        final JLabel descriptionLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
//        final JTextField description = new JTextField(product.getDescription());
//        final JLabel priceLabel = new JLabel(viewModifyProductViewModel.PRODUCT_PRICE_LABEL);
//        final JTextField price = new JTextField(String.valueOf(product.getPrice()));
//        final JLabel eTransferEmailLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ETRANSFER_EMAIL_LABEL);
// =======
//         final JLabel descriptionLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
//         description.setText(product.getDescription());
// //        final JTextField description = new JTextField(product.getDescription());
//         final JLabel priceLabel = new JLabel(viewModifyProductViewModel.PRODUCT_PRICE_LABEL);
// //        final JTextField price = new JTextField(String.valueOf(product.getPrice()));
//         price.setText(String.valueOf(product.getPrice()));
//         final JLabel eTransferEmailLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ETRANSFER_EMAIL_LABEL);
// >>>>>>> main
        final JLabel eTransferEmail = new JLabel(product.geteTransferEmail());
//        final JLabel addressLabel = new JLabel(viewModifyProductViewModel.PRODUCT_ADDRESS);
        final JLabel address = new JLabel(product.getAddress());
        final JLabel description = new JLabel(product.getDescription());
        final JLabel price = new JLabel(String.valueOf(product.getPrice()));
//        final JLabel tagsLabel = new JLabel(viewModifyProductViewModel.PRODUCT_TAGS);
//        String tagsString = String.join(", ", product.getListTags());
//        final JLabel tags = new JLabel(tagsString);

//        if (image == state.getImage()){
//            descriptionInputField.setText("");
//            titleInputField.setText("");
//            addressInputField.setText("");
//            priceInputField.setText("");
//            emailInputField.setText("");
//        }

        oldDescriptionInfo.setText(description);
        oldAddressInfo.setText(address);
        oldTitleInfo.setText(title);
        oldPriceInfo.setText(price);
        oldEmialInfo.setText(eTransferEmail);
        if (product.getImage() != null){
            imageLabel.setIcon(new ImageIcon(product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }


//        productInformation = new ModifyProductTextPanel( titleLabel,  title,
//                descriptionLabel,  description,  priceLabel,  price,
//                eTransferEmailLabel,  eTransferEmail,  addressLabel,  address,
//                tagsLabel,  tags);

//
//        contentPanel.add(displayImage, BorderLayout.WEST);

//        contentPanel.repaint();
//        contentPanel.revalidate();
// =======
//         productInformation.add(titleLabel);
//         productInformation.add(title);
//         productInformation.add(descriptionLabel);
//         productInformation.add(description);
//         productInformation.add(priceLabel);
//         productInformation.add(price);
//         productInformation.add(eTransferEmailLabel);
//         productInformation.add(eTransferEmail);
//         productInformation.add(addressLabel);
//         productInformation.add(address);
//         productInformation.add(tagsLabel);
//         productInformation.add(tags);
//         productInformation.repaint();
//         productInformation.revalidate();


//         contentPanel.add(displayImage, BorderLayout.WEST);

//         contentPanel.repaint();
//         contentPanel.revalidate();
// >>>>>>> main

//        JOptionPane.showMessageDialog(this, state.getDescription());


//        setFields(state);

    }

//    private void setFields(ViewModifyProductState state) {
//        description
//    }
}


