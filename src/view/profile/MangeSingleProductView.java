package view.profile;

import entity.product.Product;
import interface_adapter.modify_product.DeleteProductController;
import interface_adapter.modify_product.ModifyProductController;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import view.profile.ProfileListener.DeleteProductListener;
import view.profile.ProfileListener.ModifyProductListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MangeSingleProductView extends JPanel implements PropertyChangeListener {
    private final Product product;
    private final ManageProductViewModel manageProductViewModel;
    private final ModifyProductController modifyProductController;
    private final DeleteProductController deleteProductController;

    private JLabel titleViewField = new JLabel();
    private JLabel descriptionViewField = new JLabel();
    private JLabel emailViewField = new JLabel();
    private JLabel ratingViewField = new JLabel();
    private JLabel stateViewField = new JLabel();
    private JLabel priceViewField = new JLabel();
    private JLabel addressViewField = new JLabel();
    private JList<String> tagsViewField;
    private JLabel imageViewField = new JLabel();
    private JList<String> sellerTimesViewField;
    private String[] sellerTimes;
    private ArrayList<LocalDateTime> listSellerTimes;
    private JLabel buyerTimeViewField = new JLabel();

    private final JButton modifyProduct;
    private final JButton deleteProduct;

    public MangeSingleProductView(Product product, ManageProductViewModel manageProductViewModel,
                                  ModifyProductController modifyProductController, DeleteProductController deleteProductController) {
        this.setLayout(new BorderLayout());
        this.product = product;
        this.manageProductViewModel = manageProductViewModel;
        this.modifyProductController = modifyProductController;
        this.deleteProductController = deleteProductController;

        titleViewField.setText(product.getTitle());
        descriptionViewField.setText(product.getDescription());
        emailViewField.setText(product.geteTransferEmail());
        ratingViewField.setText(String.valueOf(product.getRating()));
        stateViewField.setText(String.valueOf(product.getState()));
        addressViewField.setText(product.getAddress());
        tagsViewField = new JList<String>(product.getListTags().toArray(new String[0]));
        imageViewField.setIcon(new ImageIcon(product.getImage()));
        priceViewField.setText(String.valueOf(product.getPrice()) + " $");

        listSellerTimes = product.getSchedule().getSellerTime();
        sellerTimes = new String[listSellerTimes.size()];
        for(int i = 0; i < listSellerTimes.size(); i++){
            sellerTimes[i] = listSellerTimes.get(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        sellerTimesViewField = new JList<String>(sellerTimes);

        buyerTimeViewField.setText(product.getSchedule().getBuyerTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        ProfileLabelTextPanel titleInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.PRODUCTTITLE_LABEL),
                titleViewField);
        ProfileLabelTextPanel descriptionInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.DESCRIPTION_LABEL),
                descriptionViewField);
        ProfileLabelTextPanel emailInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.EMAIL_LABEL),
                emailViewField);
        ProfileLabelTextPanel ratingInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.RATING_LABEL),
                ratingViewField);
        ProfileLabelTextPanel stateInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.STATE_LABEL),
                stateViewField);
        ProfileLabelTextPanel addressInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.ADDRESS_LABEL),
                addressViewField);
        ProfileLabelTextPanel tagsInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.TAGS_LABEL),
                tagsViewField);
        ProfileLabelTextPanel imageInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.IMAGE_LABEL),
                imageViewField);
        ProfileLabelTextPanel priceInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.PRICE_LABEL),
                priceViewField);
        ProfileLabelTextPanel sellerTimesInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.SELLERTIMES_LABEL),
                sellerTimesViewField);
        ProfileLabelTextPanel buyerTimeInfo = new ProfileLabelTextPanel(new JLabel(manageProductViewModel.BUYERTIME_LABEL),
                buyerTimeViewField);

        modifyProduct = new JButton(manageProductViewModel.MODIFY_BUTTON_LABEL);
        deleteProduct = new JButton(manageProductViewModel.DELETE_BUTTON_LABEL);


        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(titleInfo);

        JPanel tagsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tagsPanel.add(tagsInfo);
        tagsPanel.add(stateInfo);

        JPanel infoPanel = new JPanel(new GridLayout(4, 2));
        infoPanel.add(descriptionInfo);
        infoPanel.add(emailInfo);
        infoPanel.add(ratingInfo);
        infoPanel.add(addressInfo);
        infoPanel.add(imageInfo);
        infoPanel.add(priceInfo);
        infoPanel.add(sellerTimesInfo);
        infoPanel.add(buyerTimeInfo);

        JPanel buttonPanel = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
        buttonPanel.add(modifyProduct);
        buttonPanel.add(deleteProduct);

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(tagsPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        modifyProduct.addActionListener(new ModifyProductListener(modifyProductController, product));
        deleteProduct.addActionListener(new DeleteProductListener(deleteProductController, product));

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ManageProductState state = (ManageProductState) evt.getNewValue();
        manageProductViewModel.setState(state);
    }
}
