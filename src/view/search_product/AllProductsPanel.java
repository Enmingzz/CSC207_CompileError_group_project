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

public class AllProductsPanel extends JPanel {
    private ArrayList<Product> allProducts;
    private SearchProductViewModel searchProductViewModel;
    private ViewProductController viewProductController;
    private int panelWidth;

    public AllProductsPanel(ArrayList<Product> allProducts, SearchProductViewModel searchProductViewModel,
                            ViewProductController viewProductController, int panelWidth) {
        this.allProducts = allProducts;
        this.searchProductViewModel = searchProductViewModel;
        this.viewProductController = viewProductController;
        this.panelWidth = panelWidth;

        this.setLayout(new GridBagLayout());
        displayProducts();
    }

    private void displayProducts() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        int columns = calculateColumns();
        int row = 0;
        int col = 0;

        for (Product product : allProducts) {
            JPanel productPanel = createProductPanel(product);
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

    private int calculateColumns() {
        int productPanelWidth = 140; // Including padding and margins
//        int availableWidth = this.getWidth();
//        Rectangle r = this.getBounds();
//        int h = r.height;
//        int w = r.width;

        System.out.println("width: " + panelWidth);
        return Math.max(2, panelWidth / productPanelWidth);
    }

    private JPanel createProductPanel(Product product) {
        JLabel paneledImage = new JLabel();
        paneledImage.setIcon(new ImageIcon(product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        JLabel productTitle = new JLabel(product.getTitle());
        JLabel productPrice = new JLabel(String.valueOf(product.getPrice()));

        JButton viewButton = new JButton("View");
        viewButton.setPreferredSize(new Dimension(100, 50));
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource().equals(viewButton)) {
                    User user = searchProductViewModel.getState().getUser();
                    try {
                        viewProductController.execute(product, user);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        JPanel productPanel = new RoundedPanel(15);
        productPanel.setBackground(Color.PINK);
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
        productPanel.setPreferredSize(new Dimension(120, 180));
        productPanel.add(paneledImage);
        productPanel.add(productTitle);
        productPanel.add(productPrice);
        productPanel.add(viewButton);

        return productPanel;
    }

}