package view.main_page;

import entity.product.Product;
import entity.user.User;

import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.main_page.MainPageState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.main_page.MainPageState;

// Import all controllers related to MainPage
import interface_adapter.view_product.ViewProductController;

// Import all Controllers related to the top bar
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.search_product.SearchProductByTagController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class MainPageView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "main page";
    private final MainPageViewModel mainPageViewModel;

    // Check necessity of this initialization
    private List<JButton> viewProductButtons = new ArrayList<>();

    // List and initialize all controllers as `private final`
    private final ViewProductController viewProductController;

    private final ShoppingCartController shoppingCartController;
    private final ViewProfileController viewProfileController;
    private final SearchProductByTagController searchProductByTagController;
    private final SearchProductByNameController searchProductByNameController;
    private final LogOutController logOutController;
    private final MainPageController mainPageController;

    public MainPageView(MainPageViewModel mainPageViewModel,
                        ViewProductController viewProductController,
                        ShoppingCartController shoppingCartController,
                        ViewProfileController viewProfileController,
                        SearchProductByTagController searchProductByTagController,
                        SearchProductByNameController searchProductByNameController,
                        LogOutController logOutController,
                        MainPageController mainPageController){
        // initialize all controllers here
        this.viewProductController = viewProductController;

        this.viewProfileController = viewProfileController;
        this.shoppingCartController = shoppingCartController;
        this.searchProductByNameController = searchProductByNameController;
        this.searchProductByTagController = searchProductByTagController;
        this.logOutController = logOutController;
        this.mainPageController = mainPageController;

        this.mainPageViewModel = mainPageViewModel;
        mainPageViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(mainPageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(title);

        //TODO: FINISH TOP BAR

        List<Product> allProducts = mainPageViewModel.getState().getAllProducts();

        int _i = 0;
        List<JPanel> listProductPanels = new ArrayList<>();

        for (Product product: allProducts) {
            if (product.getState() == 0){

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
                                    User user = mainPageViewModel.getState().getUser();
                                    try {
                                        viewProductController.execute(product, user) ;
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );

                ProductPanel productPanel = new ProductPanel(
                        paneledImage, productTitle, productPrice, viewButton
                );

                // Above created one panel for image

                if (_i % 3 == 0){
                    listProductPanels = new ArrayList<>();

                }
                listProductPanels.add(productPanel);

                if (_i % 3 == 2){
                    HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
                            listProductPanels
                    );
                    this.add(horizontalLayoutPanel);
                }
                else if (_i + 1 == allProducts.size()){
                    HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
                            listProductPanels
                    );
                    this.add(horizontalLayoutPanel);
                }

                _i++;

            }




        }




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
