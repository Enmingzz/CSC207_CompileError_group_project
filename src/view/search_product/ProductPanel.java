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

/**
 * The ProductPanel class represents a panel displaying product information.
 * It includes an image, title, price, and a button to view the product.
 */
public class ProductPanel extends JPanel {

    ProductPanel(Product product, SearchProductViewModel searchProductViewModel, ViewProductController viewProductController) {
//        setOpaque(false);
        JLabel paneledImage = new JLabel();
        paneledImage.setIcon(new ImageIcon(product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        paneledImage.setAlignmentX(CENTER_ALIGNMENT);

        JLabel productTitle = new JLabel(product.getTitle());
        productTitle.setAlignmentX(CENTER_ALIGNMENT);

        JLabel productPrice = new JLabel(String.valueOf(product.getPrice()));
        productPrice.setAlignmentX(CENTER_ALIGNMENT);

        JButton viewButton = new JButton("View");
        viewButton.setPreferredSize(new Dimension(100, 30));
        viewButton.setAlignmentX(CENTER_ALIGNMENT);
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(120, 190));
        this.add(Box.createVerticalGlue());
        this.add(Box.createVerticalStrut(5));
        this.add(paneledImage);
        this.add(Box.createVerticalStrut(10));
        this.add(productTitle);
        this.add(Box.createVerticalStrut(5));
        this.add(productPrice);
        this.add(Box.createVerticalStrut(10));
        this.add(viewButton);
        this.add(Box.createVerticalStrut(5));
        this.add(Box.createVerticalGlue());


    }

//    /**
//     * Constructs a ProductPanel with a rounded border.
//     *
//     * @param radius the radius of the rounded corners
//     */
//    public ProductPanel(int radius) {
//        super();
//        setOpaque(false);
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//    }
//
//    /**
//     * Sets the border radius for rounded corners.
//     *
//     * @param g the Graphics object
//     */
//    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(15, 15);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the rounded panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics.setColor(getBackground());
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }
//
//    public static JPanel createProductPanel(Product product, SearchProductViewModel searchProductViewModel, ViewProductController viewProductController) {
//        JLabel paneledImage = new JLabel();
//        paneledImage.setIcon(new ImageIcon(product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
//        paneledImage.setAlignmentX(CENTER_ALIGNMENT);
//
//        JLabel productTitle = new JLabel(product.getTitle());
//        productTitle.setAlignmentX(CENTER_ALIGNMENT);
//
//        JLabel productPrice = new JLabel(String.valueOf(product.getPrice()));
//        productPrice.setAlignmentX(CENTER_ALIGNMENT);
//
//        JButton viewButton = new JButton("View");
//        viewButton.setPreferredSize(new Dimension(100, 50));
//        viewButton.setAlignmentX(CENTER_ALIGNMENT);
//        viewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                if (event.getSource().equals(viewButton)) {
//                    User user = searchProductViewModel.getState().getUser();
//                    try {
//                        viewProductController.execute(product, user);
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        });
//
//        ProductPanel productPanel = new ProductPanel(15);
//        productPanel.setBackground(Color.LIGHT_GRAY);
//        productPanel.setPreferredSize(new Dimension(120, 180));
//        productPanel.add(Box.createVerticalGlue());
//        productPanel.add(paneledImage);
//        productPanel.add(Box.createVerticalStrut(10));
//        productPanel.add(productTitle);
//        productPanel.add(Box.createVerticalStrut(5));
//        productPanel.add(productPrice);
//        productPanel.add(Box.createVerticalStrut(10));
//        productPanel.add(viewButton);
//        productPanel.add(Box.createVerticalGlue());
//
//        return productPanel;
//    }
}