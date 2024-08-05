package view.main_page;

import entity.product.Product;
import entity.user.User;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.view_product.ViewProductController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductPanel extends JPanel {

    private final Color color1 = new Color(190,227,182);

    ProductPanel(Product product, MainPageViewModel mainPageViewModel, ViewProductController viewProductController) {

//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(paneledImage);
//        this.add(productTitle);
//        this.add(productPrice);
//        this.add(viewButton);

        this.setOpaque(false);

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
            /**
             * Handles the action event when the view button is clicked.
             * Executes the view product controller to view the product details.
             *
             * @param event the action event
             */
            public void actionPerformed(ActionEvent event) {
                if (event.getSource().equals(viewButton)) {
                    User user = mainPageViewModel.getState().getUser();
                    try {
                        viewProductController.execute(product, user);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(color1);
        this.setPreferredSize(new Dimension(130, 190));
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


    /**
     * Paints the component with rounded corners and custom background color.
     *
     * @param g the Graphics object used for painting
     */
    @Override
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

}
