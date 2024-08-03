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
            ProductPanel productPanel = new ProductPanel(product, searchProductViewModel, viewProductController);
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
        return Math.max(2, panelWidth / productPanelWidth);
    }

}