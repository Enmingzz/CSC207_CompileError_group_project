package view.profile;

import entity.product.Product;
import entity.user.User;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.DeleteProductController;
import interface_adapter.modify_product.ViewModifyProductController;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewUserProfileController;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
import interface_adapter.schedule.GetSellerSchedulePageController;
import interface_adapter.view_product.ViewProductController;
import view.main_page.HorizontalLayoutPanel;
import view.main_page.ProductPanel;
import view.profile.ProfileHelper.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ViewUserProductPanel extends JPanel {
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
