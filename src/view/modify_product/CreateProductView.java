package view.modify_product;

import entity.user.User;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.CreateProductController;
import interface_adapter.modify_product.CreateProductState;
import interface_adapter.modify_product.ViewCreateProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import view.TopBarSampleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateProductView extends JPanel implements ActionListener, PropertyChangeListener {

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

    private final JButton createProduct;
    private final JButton cancel;
    private final JButton uploadImageButton;
    private JLabel imageLabel;
    private Image uploadedImage;

    ArrayList<String> arrayListTags = new ArrayList<>();


    private final JTextField titleInputField = new JTextField(40);
    private final JTextField descriptionInputField = new JTextField(200);
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
                             ViewProfileController viewProfileController) {

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

        JPanel topBar = new TopBarSampleView(this.viewCreateProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.SOUTH);

        this.viewCreateProductViewModel.addPropertyChangeListener(this);

        JLabel _title = new JLabel("view create product");
        _title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //TODO initiate image
        Image image;

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

        JFrame frame = new JFrame("Multi-Select List Example");
        String[] items = {"Furniture", "Clothes", "Electronics"};

        JList<String> listTags = new JList<>(items);

        listTags.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        String listTagsString;

        List<String> selectedItems;
        selectedItems = listTags.getSelectedValuesList();
        arrayListTags.addAll(selectedItems);


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
        }
        ;
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
        }
        ;
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
        }
        ;

        class CancelButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(cancel)) {
                    try {
                        CreateProductState state = viewCreateProductViewModel.getState();
                        User user = state.getUser();
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
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        try {
                            uploadedImage = ImageIO.read(selectedFile);
                            imageLabel.setIcon(new ImageIcon(uploadedImage));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        class CreateProductListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(createProduct)) {
                    try {
                        CreateProductState state = new CreateProductState();
                        createProductController.execute(state.getUser(), uploadedImage, descriptionInputField.getText(),
                                priceInputField.getText(), titleInputField.getText(), eTransferEmailInputField.getText(),
                                addressInputField.getText(), arrayListTags);
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(_title);
        this.add(title);
        this.add(description);
        this.add(price);
        this.add(eTransferEmail);
        this.add(address);
        this.add(listTagsLabel);
        this.add(new JScrollPane(listTags));
        this.add(buttons);

        imageLabel = new JLabel();
        this.add(imageLabel);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        CreateProductState newState = (CreateProductState) evt.getSource();

//        JPanel topBar = new TopBarSampleView(newState.getUser(),
//                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
//        this.add(topBar);

    }
}
