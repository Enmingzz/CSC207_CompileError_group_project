package view.search_product;

import entity.product.Product;
import interface_adapter.search_product.search.SearchProductViewModel;
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
    private SearchProductViewModel searchProductViewModel;
    private ViewProductController viewProductController;
    private int panelWidth;
    private final Color color1 = new Color(251,249,238);

    /**
     * Constructs an AllProductsPanel with the specified list of products, view model, product controller, and panel width.
     *
     * @param allProducts the list of all products to be displayed
     * @param searchProductViewModel the view model for search products
     * @param viewProductController the controller for viewing products
     * @param panelWidth the width of the panel
     */
    public AllProductsPanel(ArrayList<Product> allProducts, SearchProductViewModel searchProductViewModel,
                            ViewProductController viewProductController, int panelWidth) {
        this.allProducts = allProducts;
        this.searchProductViewModel = searchProductViewModel;
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