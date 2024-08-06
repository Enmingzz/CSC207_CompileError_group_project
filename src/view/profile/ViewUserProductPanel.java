package view.profile;

import entity.product.Product;
import entity.user.User;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
import interface_adapter.view_product.non_logged_in_view.ViewProductController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewUserProductPanel is a custom JPanel that displays a list of products for a user.
 * The products are arranged in a grid layout with each row containing three products.
 */
public class ViewUserProductPanel extends JPanel {

    /**
     * Constructs a ViewUserProductPanel with the specified list of products, view model, and product controller.
     * Each product is displayed with its image, title, price, rating, and a button to view details.
     *
     * @param allProducts             the list of products to display
     * @param viewUserProfileViewModel the view model for the user profile
     * @param viewProductController   the controller for viewing a product
     */
    ViewUserProductPanel(ArrayList<Product> allProducts,
                     ViewUserProfileViewModel viewUserProfileViewModel,
                     ViewProductController viewProductController) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        int _i = 0;
        List<JPanel> listProductPanels = new ArrayList<>();

        for (Product product : allProducts) {
            if (product != null) {
                JLabel ratingLabel = new JLabel("Rating: " + product.getRating().toString());
                JLabel paneledImage = new JLabel();
                paneledImage.setIcon(new ImageIcon(product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                JLabel productTitle = new JLabel(product.getTitle());

                JLabel productPrice = new JLabel(String.valueOf(product.getPrice()));

                JButton viewButton = new JButton(product.getTitle());
                // dimension set as this for now but will likely get changed later
                viewButton.setPreferredSize(new Dimension(100, 50));
                viewButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(viewButton)) {
                                    User user = viewUserProfileViewModel.getState().getBuyerUser();
                                    try {
                                        viewProductController.execute(product, user);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );

                UserProductPanel productPanel = new UserProductPanel(
                        paneledImage, productTitle, productPrice, ratingLabel, viewButton
                );

                // Above created one panel for image

                if (_i % 3 == 0) {
                    listProductPanels = new ArrayList<>();

                }
                listProductPanels.add(productPanel);

                if (_i % 3 == 2) {
                    UserHorizontalLayoutPanel horizontalLayoutPanel = new UserHorizontalLayoutPanel(
                            listProductPanels
                    );
                    this.add(horizontalLayoutPanel);
                } else if (_i + 1 == allProducts.size()) {
                    UserHorizontalLayoutPanel horizontalLayoutPanel = new UserHorizontalLayoutPanel(
                            listProductPanels
                    );
                    this.add(horizontalLayoutPanel);
                }

                _i++;

            }

        }
    }
}
