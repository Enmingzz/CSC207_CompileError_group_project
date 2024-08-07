package view.search_product;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.search.SearchProductByNameController;
import interface_adapter.search_product.search.SearchProductByTagController;
import interface_adapter.search_product.search.SearchProductState;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import interface_adapter.view_product.non_logged_in_view.ViewProductController;
import view.TopBarSampleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The SearchProductView class represents the UI for searching products.
 * It allows users to search products by name, filter by tags, and view the list of products.
 */
public class SearchProductView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search_product_view";

    private final SearchProductByNameController searchByNameController;
    private final SearchProductByTagController searchByTagController;
    private final ViewProductController viewProductController;
    private final SearchProductViewModel searchProductViewModel;

    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private JTextField searchBox;
    private final JButton searchButton;
    private JPanel searchPanel;
    private final String[] tags = {"Furniture", "Clothes", "Electronics"}; // to be decided later
    AllProductsPanel allProductsPanel;
    private JPanel topBar;
    private int panelWidth = 10;
    private Color color1 = new Color(184,222,254);
    private Color topBarColor = new Color(255,223,179);



    /**
     * Constructs a SearchProductView with the specified controllers and view model.
     *
     * @param searchByNameController the controller for searching products by name
     * @param searchByTagController the controller for searching products by tag
     * @param viewProductController the controller for viewing products
     * @param viewModel the view model for search products
     * @param getSearchPageController the controller for the search page
     * @param viewSignupPageController the controller for the signup page
     * @param viewLoginPageController the controller for the login page
     * @param shoppingCartController the controller for the shopping cart
     * @param logOutController the controller for logging out
     * @param viewProfileController the controller for the profile view
     * @param mainPageController the controller for the main page
     */
    public SearchProductView(SearchProductByNameController searchByNameController,
                             SearchProductByTagController searchByTagController,
                             ViewProductController viewProductController,
                             SearchProductViewModel viewModel,
                             GetSearchPageController getSearchPageController,
                             ViewSignupPageController viewSignupPageController,
                             ViewLoginPageController viewLoginPageController,
                             ShoppingCartController shoppingCartController,
                             LogOutController logOutController,
                             ViewProfileController viewProfileController,
                             MainPageController mainPageController) {

        this.searchByNameController = searchByNameController;
        this.searchByTagController = searchByTagController;
        this.viewProductController = viewProductController;
        this.searchProductViewModel = viewModel;
        // for top bar
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;


        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        viewModel.addPropertyChangeListener(this);

        searchPanel = new JPanel();
        searchPanel.setBackground(color1);
        searchPanel.setLayout(new FlowLayout());
        searchBox = new JTextField(20);
        searchButton = new JButton("Search");
        searchPanel.add(searchBox);
        searchPanel.add(searchButton);

        JPanel tagsPanel = new JPanel();
        tagsPanel.setBackground(color1);
        tagsPanel.setLayout(new FlowLayout());
        for (String tag : tags) {
            JButton tagButton = new JButton(tag);
            tagButton.addActionListener(new ActionListener() {
                /**
                 * Handles the action event when a tag button is clicked.
                 * Searches for products by the selected tag.
                 *
                 * @param evt the action event
                 */
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
            /**
             * Handles the action event when the search button is clicked.
             * Searches for products by the entered name.
             *
             * @param evt the action event
             */
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




        this.setLayout(new BorderLayout(1, 1));
        this.add(topBar, BorderLayout.NORTH);

        JPanel searchPagePanel = new JPanel();
        searchPagePanel.setLayout(new BorderLayout());
        JPanel searchNameAndTagPanel = new JPanel();
        searchNameAndTagPanel.setLayout(new BoxLayout(searchNameAndTagPanel, BoxLayout.Y_AXIS));
        searchNameAndTagPanel.add(searchPanel);
        searchNameAndTagPanel.add(tagsPanel);
        searchPagePanel.add(searchNameAndTagPanel, BorderLayout.NORTH);
        // products display starts here
        ArrayList<Product> products = viewModel.getState().getProducts();



        allProductsPanel = new AllProductsPanel(products, viewModel, viewProductController, panelWidth);
        JScrollPane productsScrollPanel = new JScrollPane(allProductsPanel);
        productsScrollPanel.setOpaque(true);
        productsScrollPanel.getViewport().setBackground(color1);
        searchPagePanel.add(productsScrollPanel, BorderLayout.CENTER);

        this.add(searchPagePanel, BorderLayout.CENTER);


        addComponentListener(new ComponentAdapter() {
            /**
             * Handles the component resize event.
             *
             * @param e the component event
             */
            public void componentResized(ComponentEvent e) {

                Dimension newSize = e.getComponent().getBounds().getSize();
                if (panelWidth != newSize.width) {
                    panelWidth = newSize.width;
                    allProductsPanel.removeAll();
                    ArrayList<Product> products = viewModel.getState().getProducts();
                    allProductsPanel.add(new view.search_product.AllProductsPanel(products, viewModel, viewProductController, panelWidth));
                    allProductsPanel.repaint();
                    allProductsPanel.revalidate();
                }

            }
        });

        // Wrong implementation of SearchProductView, left for reference
//        int _i = 0;
//        List<JPanel> listProductPanels = new ArrayList<>();
//
//        for (Product product: products) {
//            if (product.getState() == 0) {
//
//                Image image = product.getImage();
//                JLabel paneledImage = new JLabel(new ImageIcon(image));
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
//                                    User user = viewModel.getState().getUser();
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
//                view.search_product.ProductPanel productPanel = new view.search_product.ProductPanel(
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
//                    view.search_product.HorizontalLayoutPanel horizontalLayoutPanel = new view.search_product.HorizontalLayoutPanel(
//                            listProductPanels
//                    );
//                    this.add(horizontalLayoutPanel);
//                } else if (_i + 1 == products.size()) {
//                    view.search_product.HorizontalLayoutPanel horizontalLayoutPanel = new view.search_product.HorizontalLayoutPanel(
//                            listProductPanels
//                    );
//                    this.add(horizontalLayoutPanel);
//                }
//
//                _i++;
//
//            }
//        }
//        // Products panel ends here


    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchProductState searchProductState = (SearchProductState) evt.getNewValue();

        ArrayList<Product> products = searchProductState.getProducts();

        topBar.removeAll();
        topBar.add(new TopBarSampleView(searchProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();

//        JPanel topBar = new TopBarSampleView(searchProductState.getUser(),
//                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
//        this.add(topBar);

        allProductsPanel.removeAll();
        allProductsPanel.add(new view.search_product.AllProductsPanel(products, searchProductViewModel, viewProductController, panelWidth));
        allProductsPanel.repaint();
        allProductsPanel.revalidate();

        searchPanel.removeAll();
        searchPanel.setBackground(color1);
        searchBox = new JTextField(20);
        searchPanel.add(searchBox);
        searchPanel.add(searchButton);
        searchPanel.repaint();
        searchPanel.revalidate();
    }

}
