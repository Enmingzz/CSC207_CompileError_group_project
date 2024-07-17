package view.search_product;

import entity.product.Product;
import entity.user.User;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.view_product.ViewProductController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllProductsPanel extends JPanel  {
    AllProductsPanel(ArrayList<Product> allProducts,
                     SearchProductViewModel searchProductViewModel,
                     ViewProductController viewProductController) {

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        int _i = 0;
        List<JPanel> listProductPanels = new ArrayList<>();

        for (Product product : allProducts) {

            Image image = product.getImage();
            JLabel paneledImage = new JLabel(new ImageIcon(image));
            JLabel productTitle = new JLabel(product.getTitle());

            JLabel productPrice = new JLabel(String.valueOf(product.getPrice()));

            JButton viewButton = new JButton(product.getTitle());
            // dimension set as this for now but will likely get changed later
            viewButton.setPreferredSize(new Dimension(100, 50));
            viewButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            if (event.getSource().equals(viewButton)) {
                                User user = searchProductViewModel.getState().getUser();
                                try {
                                    viewProductController.execute(product, user);
                                } catch (SQLException e) {
                                    throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                }

                            }
                        }
                    }
            );

            view.search_product.ProductPanel productPanel = new view.search_product.ProductPanel(
                    paneledImage, productTitle, productPrice, viewButton
            );

            // Above created one panel for image

            if (_i % 3 == 0) {
                listProductPanels = new ArrayList<>();

            }
            listProductPanels.add(productPanel);

            if (_i % 3 == 2) {
                view.search_product.HorizontalLayoutPanel horizontalLayoutPanel = new view.search_product.HorizontalLayoutPanel(
                        listProductPanels
                );
                this.add(horizontalLayoutPanel);
            } else if (_i + 1 == allProducts.size()) {
                view.search_product.HorizontalLayoutPanel horizontalLayoutPanel = new view.search_product.HorizontalLayoutPanel(
                        listProductPanels
                );
                this.add(horizontalLayoutPanel);
            }

            _i++;


        }

    }
}
