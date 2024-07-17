package view.modify_product;

import entity.product.Product;
import entity.user.User;
import interface_adapter.modify_product.ModifyProductController;
import interface_adapter.modify_product.ViewModifyProductState;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;

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

public class ModifyProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "view modify product";

    private final ViewModifyProductViewModel viewModifyProductViewModel;

    private final JTextField Description = new JTextField(3);

    ModifyProductController modifyProductController;
    ManageProductController manageProductController;

    private final JButton changeProduct;
    private final JButton cancel;

    ModifyProductTextLabel productInformation;

    JPanel productModification;

    public ModifyProductView( ViewModifyProductViewModel viewModifyProductViewModel,
                              ModifyProductController modifyProductController, ManageProductController manageProductController
                              ) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
        viewModifyProductViewModel.addPropertyChangeListener(this);
        this.modifyProductController = modifyProductController;
        this.manageProductController = manageProductController;

        JLabel _title = new JLabel(viewModifyProductViewModel.TITLE_LABEL);
        _title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        changeProduct = new JButton(viewModifyProductViewModel.CHANGEPRODUCT_BUTTON_LABEL);
        cancel = new JButton(viewModifyProductViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(changeProduct);
        buttons.add(cancel);

        //(1) show the product information while
        Product product = viewModifyProductViewModel.getState().getProduct();
        LabelTextPanel title = new LabelTextPanel(
                new JLabel("Title"), titleInputField);
        final JLabel titleLabel =new JLabel(viewModifyProductViewModel.PRODUCT_TITLE_LABEL);
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

        productInformation = new ModifyProductTextLabel( titleLabel,  title,
                 descriptionLabel,  description,  priceLabel,  price,
                 eTransferEmailLabel,  eTransferEmail,  addressLabel,  address,
                 tagsLabel,  tags);


        //create all the different panels
        //TODO rethink loading image
        JFrame frame = new JFrame("Image Display Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        final JLabel image = new JLabel();
        frame.add(image, BorderLayout.CENTER);
        try {
            BufferedImage image = ImageIO.read(product.getImage()); // Replace with your image path
            ImageIcon icon = new ImageIcon(image);
            image.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }


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
                viewModifyProductViewModel.setState(state);            }

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
                                viewModifyProductViewModel.getState().getDescription(), viewModifyProductViewModel.getState().getPrice());
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewModifyProductState state = (ViewModifyProductState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(ViewModifyProductState state) {
        description
    }
}


