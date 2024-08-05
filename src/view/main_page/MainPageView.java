package view.main_page;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;

import entity.user.UserFactory;
import interface_adapter.login.LoginController;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.main_page.MainPageState;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.main_page.MainPageState;

// Import all controllers related to MainPage
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.ViewProductController;

// Import all Controllers related to the top bar
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.profile.view_profile.ViewProfileController;
// import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import view.TopBarSampleView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class MainPageView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "main page";
    private final MainPageViewModel mainPageViewModel;
    private JPanel topBar;
    private int panelWidth = 10;

    // Check necessity of this initialization
    private List<JButton> viewProductButtons = new ArrayList<>();

    // List and initialize all controllers as `private final`
    private final ViewProductController viewProductController;

    private final ShoppingCartController shoppingCartController;
    private final ViewProfileController viewProfileController;
    private final GetSearchPageController getSearchPageController;
    private final LogOutController logOutController;
    private final MainPageController mainPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ViewSignupPageController viewSignupPageController;


    AllProductsPanel allProductsPanel;

    public MainPageView(MainPageViewModel mainPageViewModel,
                        ViewProductController viewProductController,
                        ShoppingCartController shoppingCartController,
                        ViewProfileController viewProfileController,
                        GetSearchPageController getSearchPageController,
                        LogOutController logOutController,
                        MainPageController mainPageController,
                        ViewSignupPageController viewSignupPageController,
                        ViewLoginPageController viewLoginPageController
                        ){
        // initialize all controllers here
        this.viewProductController = viewProductController;

        this.viewProfileController = viewProfileController;
        this.shoppingCartController = shoppingCartController;
        this.getSearchPageController = getSearchPageController;
        this.logOutController = logOutController;
        this.mainPageController = mainPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.viewSignupPageController = viewSignupPageController;

        this.mainPageViewModel = mainPageViewModel;
        mainPageViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(mainPageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.TOP_ALIGNMENT);

        this.setLayout(new BorderLayout());
        this.add(title);

//        JPanel topBar = new TopBarSampleView(this.mainPageViewModel.getState().getUser(),
//                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
//        this.add(topBar, BorderLayout.NORTH);
        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);
        this.add(topBar, BorderLayout.NORTH);
        topBar.setAlignmentY(Component.TOP_ALIGNMENT);

        // Products page starts here

        ArrayList<Product> allProducts = mainPageViewModel.getState().getAllProducts();

        allProductsPanel = new AllProductsPanel(allProducts, mainPageViewModel, viewProductController, panelWidth);
        this.add(new JScrollPane(allProductsPanel));

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
                    ArrayList<Product> products = mainPageViewModel.getState().getAllProducts();
                    allProductsPanel.add(new AllProductsPanel(products, mainPageViewModel, viewProductController, panelWidth));
                    allProductsPanel.repaint();
                    allProductsPanel.revalidate();
                }

            }
        });


//        Wrong implementation of MainPAgeView, left for reference

//        int _i = 0;
//        ArrayList<JPanel> listProductPanels = new ArrayList<>();
//
//        for (Product product: allProducts) {
//            if (product.getState() == 0){
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
//                                    User user = mainPageViewModel.getState().getUser();
//                                    try {
//                                        viewProductController.execute(product, user) ;
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
//                if (_i % 3 == 0){
//                    listProductPanels = new ArrayList<>();
//
//                }
//                listProductPanels.add(productPanel);
//
//                if (_i % 3 == 2){
//                    HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
//                            listProductPanels
//                    );
//                    this.add(horizontalLayoutPanel);
//                }
//                else if (_i + 1 == allProducts.size()){
//                    HorizontalLayoutPanel horizontalLayoutPanel = new HorizontalLayoutPanel(
//                            listProductPanels
//                    );
//                    this.add(horizontalLayoutPanel);
//                }
//
//                _i++;

    // Products panel ends here



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("init")) {
            try {
                this.mainPageController.execute(this.mainPageViewModel.getState().getUser());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//        System.out.println("propertyChange");

        MainPageState state = (MainPageState) evt.getNewValue();

        System.out.println(state.getUser().getStudentNumber() + "hi");

        ArrayList<Product> allProducts = state.getAllProducts();

        mainPageViewModel.setState(state);

//        topBar = new TopBarSampleView(this.mainPageViewModel.getState().getUser(),
//                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);

        //this.add(topBar, BorderLayout.NORTH);
        topBar.removeAll();
        topBar.add(new TopBarSampleView(mainPageViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.setAlignmentY(Component.TOP_ALIGNMENT);
        topBar.repaint();
        topBar.revalidate();

        allProductsPanel.removeAll();
        allProductsPanel.add(new AllProductsPanel(allProducts, mainPageViewModel, viewProductController, panelWidth));
        allProductsPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        allProductsPanel.repaint();
        allProductsPanel.revalidate();
//        this.revalidate();
//        this.repaint();
        //this.add(topBar);

    }

}
