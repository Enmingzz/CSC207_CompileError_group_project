package view.modify_product;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.create.CreateProductController;
import interface_adapter.modify_product.create.CreateProductState;
import interface_adapter.modify_product.upload_image.UploadImageController;
import interface_adapter.modify_product.create.ViewCreateProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import view.TopBarSampleView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
import java.util.ArrayList;
import java.util.Objects;

public class CreateProductView extends JPanel implements ActionListener, ListSelectionListener, PropertyChangeListener {

    public final String viewName = "view create product";

    private final CreateProductController createProductController;
    private final ViewCreateProductViewModel viewCreateProductViewModel;
    private final ManageProductController manageProductController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;
    private final UploadImageController uploadImageController;

    private final JButton createProduct;
    private final JButton cancel;
    private final JButton uploadImageButton;
    private JLabel imageLabel;
    private Image image = null;

    ArrayList<String> arrayListTags = new ArrayList<>();
    private final String[] items = {"Furniture", "Clothes", "Electronics"};

    private JList<String> listTags;

    private JPanel topBar;


    private final JTextField titleInputField = new JTextField(40);
    private final JTextField descriptionInputField = new JTextField(100);
    private final JTextField priceInputField = new JTextField(10);
    private final JTextField eTransferEmailInputField = new JTextField(30);
    private final JTextField addressInputField = new JTextField(30);

    public CreateProductView(CreateProductController createProductController,
                             ViewCreateProductViewModel viewCreateProductViewModel,
                             ManageProductController manageProductController,
                             MainPageController mainPageController,
                             GetSearchPageController getSearchPageController,
                             ViewSignupPageController viewSignupPageController,
                             ViewLoginPageController viewLoginPageController,
                             ShoppingCartController shoppingCartController,
                             LogOutController logOutController,
                             ViewProfileController viewProfileController, UploadImageController uploadImageController) {

        this.createProductController = createProductController;
        this.manageProductController = manageProductController;
        this.viewCreateProductViewModel = viewCreateProductViewModel;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;
        this.uploadImageController = uploadImageController;

        this.setLayout(new BorderLayout());

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);
        this.add(topBar, BorderLayout.NORTH);

        this.viewCreateProductViewModel.addPropertyChangeListener(this);

        JLabel _title = new JLabel("view create product");
        _title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        LabelTextPanel title = new LabelTextPanel(
                new JLabel(viewCreateProductViewModel.PRODUCT_TITLE_LABEL), titleInputField);
        LabelTextPanel description = new LabelTextPanel(
                new JLabel(viewCreateProductViewModel.PRODUCT_DESCRIPTION_LABEL), descriptionInputField);
        LabelTextPanel price = new LabelTextPanel(
                new JLabel(viewCreateProductViewModel.PRODUCT_PRICE_LABEL), priceInputField);
        LabelTextPanel eTransferEmail = new LabelTextPanel(
                new JLabel(viewCreateProductViewModel.PRODUCT_ETRANSFER_EMAIL_LABEL), eTransferEmailInputField);
        LabelTextPanel address = new LabelTextPanel(
                new JLabel(viewCreateProductViewModel.PRODUCT_ADDRESS_LABEL), addressInputField);

        JLabel listTagsLabel = new JLabel(viewCreateProductViewModel.PRODUCT_TAGS_LABEL);


        JPanel buttons = new JPanel();
        createProduct = new JButton(viewCreateProductViewModel.CREATE_PRODUCT_BUTTON_LABEL);
        buttons.add(createProduct);
        cancel = new JButton(viewCreateProductViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        uploadImageButton = new JButton("Upload Image");
        buttons.add(uploadImageButton);
        uploadImageButton.addActionListener(this);


        createProduct.addActionListener(this);
        cancel.addActionListener(this);

//        JFrame frame = new JFrame("Multi-Select List Example");

        listTags = new JList<>(items);

        listTags.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

//        String listTagsString;

//        final List<String> selectedItems;

        listTags.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    arrayListTags.clear();
                    // Get selected items
                    arrayListTags.addAll(listTags.getSelectedValuesList());
                }
            }
        });

        class TitleInputFieldListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
                CreateProductState state = viewCreateProductViewModel.getState();
                state.setTitle(titleInputField.getText() + e.getKeyChar());
                viewCreateProductViewModel.setState(state);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        class DescriptionInputFieldListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
                CreateProductState state = viewCreateProductViewModel.getState();
                state.setDescription(descriptionInputField.getText() + e.getKeyChar());
                viewCreateProductViewModel.setState(state);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        class PriceInputFieldListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
                CreateProductState state = viewCreateProductViewModel.getState();
                state.setPrice(priceInputField.getText() + e.getKeyChar());
                viewCreateProductViewModel.setState(state);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        class ETransferEmailInputFieldListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
                CreateProductState state = viewCreateProductViewModel.getState();
                state.seteTransferEmail(eTransferEmailInputField.getText() + e.getKeyChar());
                viewCreateProductViewModel.setState(state);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        class AddressInputFieldListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
                CreateProductState state = viewCreateProductViewModel.getState();
                state.setAddress(addressInputField.getText() + e.getKeyChar());
                viewCreateProductViewModel.setState(state);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        class CancelButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(cancel)) {
                    try {
                        titleInputField.setText("");
                        descriptionInputField.setText("");
                        priceInputField.setText("");
                        eTransferEmailInputField.setText("");
                        addressInputField.setText("");

                        CreateProductState state = viewCreateProductViewModel.getState();
                        state.setImage(null); //erases the image
                        User user = state.getUser();
                        if (user != null) System.out.println("use is " + user);
                        else System.out.println("no user");
                        manageProductController.execute(user);
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

//        class uploadImageButtonListener implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                if (evt.getSource().equals(uploadImageButton)) {
//                    JFileChooser fileChooser = new JFileChooser();
//                    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                            "JPG & PNG Images", "jpg", "png");
//                    fileChooser.setFileFilter(filter);
////                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//                    int returnValue = fileChooser.showOpenDialog(null);
//                    if (returnValue == JFileChooser.APPROVE_OPTION) {
//                        File selectedFile = fileChooser.getSelectedFile();
//                        try {
//                            uploadedImage = ImageIO.read(selectedFile);
//                            imageLabel.setIcon(new ImageIcon(uploadedImage));
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }

        class uploadImageButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(uploadImageButton)) {
                    try {
                        uploadImageController.execute();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    ImageIcon imageIcon = new ImageIcon(viewCreateProductViewModel.getState().getPath());
                    image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                   imageLabel.setIcon(scaledIcon);
                   CreateProductState createProductState = viewCreateProductViewModel.getState();
                   createProductState.setImage(image);
                   viewCreateProductViewModel.setState(createProductState);
                }
            }
        }

        class CreateProductListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(createProduct)) {
                    try {

//                        CreateProductState state = new CreateProductState();
                        //TODO This is a helper
                        if (image instanceof BufferedImage) {
                            createProductController.execute(viewCreateProductViewModel.getState().getUser(), image,
                                    descriptionInputField.getText(), priceInputField.getText(), titleInputField.getText(),
                                    eTransferEmailInputField.getText(), addressInputField.getText(), arrayListTags);


                        }
                        else if (image == null) {
                            createProductController.execute(viewCreateProductViewModel.getState().getUser(), image,
                                    descriptionInputField.getText(), priceInputField.getText(), titleInputField.getText(),
                                    eTransferEmailInputField.getText(), addressInputField.getText(), arrayListTags);

                        }
                        else{
                            // Create a BufferedImage with the same width, height, and type as the original Image
                                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

                            // Draw the Image onto the BufferedImage
                            Graphics2D bGr = bufferedImage.createGraphics();
                            bGr.drawImage(image, 0, 0, null);
                            bGr.dispose();

                            createProductController.execute(viewCreateProductViewModel.getState().getUser(), (Image) bufferedImage,
                                    descriptionInputField.getText(), priceInputField.getText(), titleInputField.getText(),
                                    eTransferEmailInputField.getText(), addressInputField.getText(), arrayListTags);
                        }
                        titleInputField.setText("");
                        descriptionInputField.setText("");
                        priceInputField.setText("");
                        eTransferEmailInputField.setText("");
                        addressInputField.setText("");
                        //
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        createProduct.addActionListener(new CreateProductListener());
        cancel.addActionListener(new CancelButtonListener());
        uploadImageButton.addActionListener(new uploadImageButtonListener());
        title.addKeyListener(new TitleInputFieldListener());
        description.addKeyListener(new DescriptionInputFieldListener());
        price.addKeyListener(new PriceInputFieldListener());
        eTransferEmail.addKeyListener(new ETransferEmailInputFieldListener());
        address.addKeyListener(new AddressInputFieldListener());


        mainPanel.add(_title);
        mainPanel.add(title);
        mainPanel.add(description);
        mainPanel.add(price);
        mainPanel.add(eTransferEmail);
        mainPanel.add(address);
        mainPanel.add(listTagsLabel);
        mainPanel.add(new JScrollPane(listTags));
        mainPanel.add(buttons);

        imageLabel = new JLabel();
        mainPanel.add(imageLabel);

        this.setLayout(new BorderLayout(1, 1));

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(new JPanel(), BorderLayout.WEST);
        this.add(new JPanel(), BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        topBar.removeAll();
        topBar.add(new TopBarSampleView(viewCreateProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();

        CreateProductState newState = (CreateProductState) evt.getNewValue();

        if (newState.getCreateProductError() != null & !Objects.equals(newState.getCreateProductError(), "")) {
            JOptionPane.showMessageDialog(this, newState.getCreateProductError());
//            listTags = new JList<>(items);
//            listTags.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            }
        else {
            viewCreateProductViewModel.setState(newState);
        }

        if (newState.getUser() != null){
            viewCreateProductViewModel.setState(newState);
            this.remove(topBar);
            topBar = new TopBarSampleView(newState.getUser(),
                    getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
            this.add(topBar, BorderLayout.NORTH);

        }
        if (newState.getImage() == null){
            System.out.println("here");
            imageLabel.setIcon(null);
            imageLabel.revalidate();
            imageLabel.repaint();
        }

        //TODO reevaluate
        titleInputField.setText("");
        descriptionInputField.setText("");
        priceInputField.setText("");
        eTransferEmailInputField.setText("");
        addressInputField.setText("");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
