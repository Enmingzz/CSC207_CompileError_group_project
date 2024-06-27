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
import java.sql.SQLException;

public class MainPageView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "main page";
    private final MainPageViewModel mainPageViewModel;

    // Check necessity of this initialization
    private ArrayList<JButton> viewProductButtons = new ArrayList<>();

    // List and initialize all controllers as `private final`
    private final ViewProductController viewProductController;

    public MainPageView(MainPageViewModel mainPageViewModel,
                        ViewProductController viewProductController){
        // initialize all controllers here
        this.viewProductController = viewProductController;

        this.mainPageViewModel = mainPageViewModel;
        mainPageViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(mainPageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(title);

        ArrayList<Product> allProducts = mainPageViewModel.getState().getAllProducts();

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

                //TODO: CREATE THE REST OF THE PANEL

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
