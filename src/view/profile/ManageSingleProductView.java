package view.profile;

import entity.product.Product;
import entity.user.User;
import interface_adapter.modify_product.delete.DeleteProductController;
import interface_adapter.modify_product.modify.ViewModifyProductController;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.schedule.seller_select_schedule.GetSellerSchedulePageController;
import interface_adapter.view_product.non_logged_in_view.ViewProductController;
import view.profile.ProfileHelper.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.format.DateTimeFormatter;

/**
 * A view component for managing a single product.
 * This class extends JPanel and implements PropertyChangeListener to respond to property changes in the view model.
 */
public class ManageSingleProductView extends JPanel implements PropertyChangeListener {
    private final Product product;
    private final User user;
    private final ManageProductViewModel manageProductViewModel;
    private final ViewModifyProductController viewModifyProductController;
    private final ViewProductController viewProductController;
    private final DeleteProductController deleteProductController;
    private final GetSellerSchedulePageController getSellerSchedulePageController;

    private JLabel titleViewField = new JLabel();
    private JLabel ratingViewField = new JLabel();
    private JLabel stateViewField = new JLabel();
    private JLabel priceViewField = new JLabel();
    private JLabel imageViewField = new JLabel();

    private final JPanel buttonPanel = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
    private final JButton modifyProduct;
    private final JButton deleteProduct;
    private final JButton showDetil;
    private JButton selectTime;

    /**
     * Constructs a ManageSingleProductView with the specified user, product, view model, and controllers.
     *
     * @param user                          the user managing the product
     * @param product                       the product being managed
     * @param manageProductViewModel        the view model for managing products
     * @param viewProductController         the controller for viewing a product
     * @param viewModifyProductController   the controller for modifying a product
     * @param deleteProductController       the controller for deleting a product
     * @param getSellerSchedulePageController the controller for getting the seller's schedule page
     */
    public ManageSingleProductView(User user, Product product, ManageProductViewModel manageProductViewModel,
                                   ViewProductController viewProductController,
                                   ViewModifyProductController viewModifyProductController,
                                   DeleteProductController deleteProductController,
                                   GetSellerSchedulePageController getSellerSchedulePageController) {
        this.setLayout(new BorderLayout());
        this.setSize(100, 100);
        this.product = product;
        this.user = user;
        this.manageProductViewModel = manageProductViewModel;
        this.viewModifyProductController = viewModifyProductController;
        this.viewProductController = viewProductController;
        this.deleteProductController = deleteProductController;
        this.getSellerSchedulePageController = getSellerSchedulePageController;


        titleViewField.setText(product.getTitle());
        if (product.getRating() == null){
            ratingViewField.setText("No One has been evaluated this product yet!");
        } else{
            ratingViewField.setText(String.valueOf(product.getRating()));
        }

        if (product.getImage() != null){
            imageViewField.setIcon(new ImageIcon(product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }

        priceViewField.setText(product.getPrice() + " $");

        if (product.getState() == 0){
            stateViewField.setText("product is being sold");
        } else if (product.getState() == 1) {
            stateViewField.setText("Please select available times for meeting the buyer.");
        } else if (product.getState() == 2) {
            stateViewField.setText("Pending for buyer to select a meeting time.");
        } else if (product.getState() == 3) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm");
            String formattedDateTime = product.getSchedule().getBuyerTime().format(formatter);
            stateViewField.setText("The scheduled meeting time: " + formattedDateTime);
        } else if (product.getState() == 4) {
            stateViewField.setText("Buyer has confirmed receipt of the product. Pending buyer's rating.");
        } else {
            stateViewField.setText("product has been sold and buyer has rated the product");
        }

        ProductLabelTextPanel titleInfo = new ProductLabelTextPanel(new JLabel(manageProductViewModel.PRODUCTTITLE_LABEL),
                titleViewField);
        ProductLabelTextPanel ratingInfo = new ProductLabelTextPanel(new JLabel(manageProductViewModel.RATING_LABEL),
                ratingViewField);
        ProductLabelTextPanel stateInfo = new ProductLabelTextPanel(new JLabel(manageProductViewModel.STATE_LABEL),
                stateViewField);
        ProductLabelTextPanel imageInfo = new ProductLabelTextPanel(new JLabel(manageProductViewModel.IMAGE_LABEL),
                imageViewField);
        ProductLabelTextPanel priceInfo = new ProductLabelTextPanel(new JLabel(manageProductViewModel.PRICE_LABEL),
                priceViewField);

        modifyProduct = new JButton(manageProductViewModel.MODIFY_BUTTON_LABEL);
        deleteProduct = new JButton(manageProductViewModel.DELETE_BUTTON_LABEL);
        showDetil = new JButton(manageProductViewModel.SHOW_BUTTON_LABEL);
        selectTime = new JButton(manageProductViewModel.SELECTTIME_BUTTON_LABEL);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.lightGray));

        infoPanel.add(titleInfo);
        infoPanel.add(stateInfo);
        infoPanel.add(ratingInfo);
        infoPanel.add(priceInfo);
        infoPanel.add(imageInfo);

        buttonPanel.add(showDetil);

        if (product.getState() == 0){
            buttonPanel.add(modifyProduct);
            buttonPanel.add(deleteProduct);
        }

        if (product.getState() == 1){
            buttonPanel.add(selectTime);
        }

        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        modifyProduct.addActionListener(new ModifyProductListener(this.viewModifyProductController, product, user));
        deleteProduct.addActionListener(new DeleteProductListener(this.deleteProductController, product, user));
        showDetil.addActionListener(new ShowProductListener(this.viewProductController, product, user));
        selectTime.addActionListener(new SelectTimeListener(this.getSellerSchedulePageController, product, user));

        this.setVisible(true);
    }

    /**
     * Responds to property changes in the view model.
     * Notice that this is no more used.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        ManageProductState state = (ManageProductState) evt.getNewValue();
//        manageProductViewModel.setState(state);
//
//        titleViewField.setText(manageProductViewModel.getState().getSingleProduct().getTitle());
//        ratingViewField.setText(String.valueOf(manageProductViewModel.getState().getSingleProduct().getRating()));
//        imageViewField.setIcon(new ImageIcon(manageProductViewModel.getState().getSingleProduct().getImage()));
//        priceViewField.setText(manageProductViewModel.getState().getSingleProduct().getPrice() + " $");
//
//        if (manageProductViewModel.getState().getSingleProduct().getState() == 0){
//            stateViewField.setText("product is being sold");
//        } else if (manageProductViewModel.getState().getSingleProduct().getState() == 1) {
//            stateViewField.setText("scheduling a meeting time with buyer");
//        } else if (manageProductViewModel.getState().getSingleProduct().getState() == 2) {
//            stateViewField.setText("your meeting time scheduled");
//        } else if (manageProductViewModel.getState().getSingleProduct().getState() == 3) {
//            stateViewField.setText("buyer has chosen a meeting time");
//        } else if (manageProductViewModel.getState().getSingleProduct().getState() == 4) {
//            stateViewField.setText("Buyer has confirmed that they have received the product");
//        } else {
//            stateViewField.setText("product has been sold and buyer has rated the product");
//        }
//
//        if (manageProductViewModel.getState().getSingleProduct().getState() != 0){
//            buttonPanel.remove(modifyProduct);
//            buttonPanel.remove(deleteProduct);
//        }
//
//        if (manageProductViewModel.getState().getSingleProduct().getState() == 1){
//            selectTime = new JButton(manageProductViewModel.SELECTTIME_BUTTON_LABEL);
//            buttonPanel.add(selectTime);
//            selectTime.addActionListener(new SelectTimeListener(this.getSellerSchedulePageController, product, user));
//        }
//
//        this.revalidate();
//        this.repaint();
//        this.setVisible(true);

    }
}
