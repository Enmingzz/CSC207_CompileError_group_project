package view.search_product;

import entity.product.Product;
import entity.user.User;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.search_product.SearchProductByTagController;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.view_product.ViewProductController;
import view.main_page.HorizontalLayoutPanel;
import view.main_page.ProductPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchPageView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search_product_view";

    private SearchProductByNameController searchByNameController;
    private SearchProductByTagController searchByTagController;
    private ViewProductController viewProductController;
    private SearchProductViewModel viewModel;

    private JTextField searchBox;
    private JButton searchButton;
    private final String[] tags = {"Tag1", "Tag2", "Tag3"}; // to be decided later

    public SearchPageView(SearchProductByNameController searchByNameController,
                          SearchProductByTagController searchByTagController,
                          ViewProductController viewProductController,
                          SearchProductViewModel viewModel) {

        this.searchByNameController = searchByNameController;
        this.searchByTagController = searchByTagController;
        this.viewProductController = viewProductController;
        this.viewModel = viewModel;
        viewModel.addPropertyChangeListener(this);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchBox = new JTextField(20);
        searchButton = new JButton("Search");
        searchPanel.add(searchBox);
        searchPanel.add(searchButton);

        JPanel tagsPanel = new JPanel();
        tagsPanel.setLayout(new FlowLayout());
        for (String tag : tags) {
            JButton tagButton = new JButton(tag);
            tagButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(tagButton)) {
                        try {
                            searchByTagController.execute(viewModel.getState().getUser(), tag);
                        } catch (SQLException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            tagsPanel.add(tagButton);
        }

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(searchButton)) {
                    String text = searchBox.getText();
                    try {
                        searchByNameController.execute(viewModel.getState().getUser(), text);
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        ArrayList<Product> products = viewModel.getState().getProducts();

        int _i = 0;
        List<JPanel> listProductPanels = new ArrayList<>();

        for (Product product: products) {
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
                                    User user = viewModel.getState().getUser();
                                    try {
                                        viewProductController.execute(product, user) ;
                                    } catch (SQLException | IOException e) {
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
                    view.main_page.HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
                            listProductPanels
                    );
                    this.add(horizontalLayoutPanel);
                }
                else if (_i + 1 == products.size()){
                    view.main_page.HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
                            listProductPanels
                    );
                    this.add(horizontalLayoutPanel);
                }

                _i++;

            }

            this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(searchPanel);
        this.add(tagsPanel);




    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
