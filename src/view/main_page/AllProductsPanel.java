package view.main_page;

//import entity.product.Product;
//import entity.user.User;
//import interface_adapter.main_page.MainPageViewModel;
//import interface_adapter.view_product.non_logged_in_view.ViewProductController;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AllProductsPanel extends JPanel {
//    AllProductsPanel(ArrayList<Product> allProducts,
//                     MainPageViewModel mainPageViewModel,
//                     ViewProductController viewProductController) {
//
//        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
//        this.setAlignmentY(Component.TOP_ALIGNMENT);
//
//        int _i = 0;
//        List<JPanel> listProductPanels = new ArrayList<>();
//
//        for (Product product : allProducts) {
//            if (product != null) {
//                JLabel paneledImage = new JLabel();
//                paneledImage.setIcon(new ImageIcon(product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
//                JLabel productTitle = new JLabel(product.getTitle());
//
//                JLabel productPrice = new JLabel(String.valueOf(product.getPrice()));
//
//                JButton viewButton = new JButton(product.getTitle());
//                // dimension set as this for now but will likely get changed later
//                viewButton.setPreferredSize(new Dimension(100, 50));
//                viewButton.addActionListener(
//                        new ActionListener() {
//                            public void actionPerformed(ActionEvent event) {
//                                if (event.getSource().equals(viewButton)) {
//                                    User user = mainPageViewModel.getState().getUser();
//                                    try {
//                                        viewProductController.execute(product, user);
//                                    } catch (SQLException e) {
//                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
//                                    }
//
//                                }
//                            }
//                        }
//                );
//
//                ProductPanel productPanel = new ProductPanel(
//                        paneledImage, productTitle, productPrice, viewButton
//                );
//
//                // Above created one panel for image
//
//                if (_i % 3 == 0) {
//                    listProductPanels = new ArrayList<>();
//
//                }
//                listProductPanels.add(productPanel);
//
//                if (_i % 3 == 2) {
//                    HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
//                            listProductPanels
//                    );
//                    this.add(horizontalLayoutPanel);
//                    horizontalLayoutPanel.setAlignmentY(Component.TOP_ALIGNMENT);
//                } else if (_i + 1 == allProducts.size()) {
//                    HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
//                            listProductPanels
//                    );
//                    this.add(horizontalLayoutPanel);
//                    horizontalLayoutPanel.setAlignmentY(Component.TOP_ALIGNMENT);
//                }
//
//                _i++;
//
//            }
//
//        }
//
//    }
//
//}

import entity.product.Product;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.view_product.non_logged_in_view.ViewProductController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The AllProductsPanel class represents a panel that displays all products in a grid layout.
 * It dynamically adjusts the number of columns based on the available width.
 */
public class AllProductsPanel extends JPanel {
    private ArrayList<Product> allProducts;
    private MainPageViewModel mainPageViewModel;
    private ViewProductController viewProductController;
    private int panelWidth;
    private final Color color1 = new Color(251,249,238);

    /**
     * Constructs an AllProductsPanel with the specified list of products, view model, product controller, and panel width.
     *
     * @param allProducts the list of all products to be displayed
     * @param mainPageViewModel the view model for main page
     * @param viewProductController the controller for viewing products
     * @param panelWidth the width of the panel
     */
    public AllProductsPanel(ArrayList<Product> allProducts, MainPageViewModel mainPageViewModel,
                            ViewProductController viewProductController, int panelWidth) {
        this.allProducts = allProducts;
        this.mainPageViewModel = mainPageViewModel;
        this.viewProductController = viewProductController;
        this.panelWidth = panelWidth;

        this.setBackground(color1);
        this.setLayout(new GridBagLayout());
        displayProducts();
    }

    /**
     * Displays the products in a grid layout. The number of columns is calculated based on the available panel width.
     */
    private void displayProducts() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        int columns = calculateColumns();
        int row = 0;
        int col = 0;

        for (Product product : allProducts) {
            ProductPanel productPanel = new ProductPanel(product, mainPageViewModel, viewProductController);
            gbc.gridx = col;
            gbc.gridy = row;
            this.add(productPanel, gbc);

            col++;
            if (col >= columns) {
                col = 0;
                row++;
            }
        }
    }

    /**
     * Calculates the number of columns based on the available panel width.
     *
     * @return the number of columns
     */
    private int calculateColumns() {
        int productPanelWidth = 140; // Including padding and margins

        return Math.max(2, panelWidth / productPanelWidth);
    }

}
