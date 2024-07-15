package view.profile;

import entity.product.Product;
import entity.user.User;
import interface_adapter.modify_product.DeleteProductController;
import interface_adapter.modify_product.ModifyProductController;
import interface_adapter.modify_product.ViewModifyProductController;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.view_product.ViewProductController;
import view.profile.ProfileListener.DeleteProductListener;
import view.profile.ProfileListener.ModifyProductListener;
import view.profile.ProfileListener.ProfileLabelTextPanel;
import view.profile.ProfileListener.ShowProductListener;
import view.view_product.SellerViewProductView;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MangeSingleProductView extends JPanel implements PropertyChangeListener {
    private final Product product;
    private final User user;
    private final ManageProductViewModel manageProductViewModel;
    private final ViewModifyProductController viewModifyProductController;
    private final ViewProductController viewProductController;
    private final DeleteProductController deleteProductController;

    private JLabel titleViewField = new JLabel();
    private JLabel ratingViewField = new JLabel();
    private JLabel stateViewField = new JLabel();
    private JLabel priceViewField = new JLabel();
    private JLabel imageViewField = new JLabel();

    private final JButton modifyProduct;
    private final JButton deleteProduct;
    private final JButton showDetil;

    public MangeSingleProductView(User user, Product product, ManageProductViewModel manageProductViewModel,
                                  ViewProductController viewProductController,
                                  ViewModifyProductController viewModifyProductController,
                                  DeleteProductController deleteProductController) {
        this.setLayout(new BorderLayout());
        this.product = product;
        this.user = user;
        this.manageProductViewModel = manageProductViewModel;
        this.viewModifyProductController = viewModifyProductController;
        this.viewProductController = viewProductController;
        this.deleteProductController = deleteProductController;

        titleViewField.setText(product.getTitle());
        ratingViewField.setText(String.valueOf(product.getRating()));
        stateViewField.setText(String.valueOf(product.getState()));
        imageViewField.setIcon(new ImageIcon(product.getImage()));
        priceViewField.setText(product.getPrice() + " $");

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


        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(titleInfo);

        JPanel tagsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tagsPanel.add(stateInfo);

        JPanel infoPanel = new JPanel(new GridLayout(4, 2));
        infoPanel.add(ratingInfo);
        infoPanel.add(imageInfo);
        infoPanel.add(priceInfo);

        JPanel buttonPanel = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
        buttonPanel.add(modifyProduct);
        buttonPanel.add(deleteProduct);

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(tagsPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        modifyProduct.addActionListener(new ModifyProductListener(viewModifyProductController, product, user));
        deleteProduct.addActionListener(new DeleteProductListener(deleteProductController, product, user));
        showDetil.addActionListener(new ShowProductListener(viewProductController, product, user));

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ManageProductState state = (ManageProductState) evt.getNewValue();
        manageProductViewModel.setState(state);
    }
}
