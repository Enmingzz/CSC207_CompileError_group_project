package view;

import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The TopBarSampleView class represents the top navigation bar for the application.
 * It includes buttons for various actions such as searching, navigating to the main page,
 * signing up, logging in, viewing the shopping cart, logging out, and viewing the user profile.
 * <p>
 * The class uses several controllers to manage user interaction with the application and to update the view
 * according to user actions and application state changes.
 * </p>
 */
public class TopBarSampleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "top bar sample view";

    private final JButton searchButton;
    private final JButton mainPageButton;

    private final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel title = new JPanel();
    private Color topBarColor = new Color(255,223,179);

    /**
     * Constructs a TopBarSampleView with specific controllers and user information.
     *
     * @param user the user for whom the top bar is displayed.
     * @param getSearchPageController controller to manage search page operations.
     * @param viewSignupPageController controller to manage signup page operations.
     * @param viewLoginPageController controller to manage login page operations.
     * @param shoppingCartController controller to manage shopping cart operations.
     * @param logOutController controller to manage logout operations.
     * @param viewProfileController controller to view user profile.
     * @param mainPageController controller to navigate to the main page.
     */
    public TopBarSampleView(User user, GetSearchPageController getSearchPageController,
                            ViewSignupPageController viewSignupPageController,
                            ViewLoginPageController viewLoginPageController,
                            ShoppingCartController shoppingCartController,
                            LogOutController logOutController,
                            ViewProfileController viewProfileController,
                            MainPageController mainPageController) {

        buttonPanel.setBackground(topBarColor);
        title.setBackground(topBarColor);
        this.setLayout(new BorderLayout());
        // Search button
        searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchButtonListener(getSearchPageController, user));
        buttonPanel.add(searchButton);

        // Welcome message or user greeting
        JLabel hi = new JLabel(user.getName().isEmpty() ? "Welcome!" : "Hi, " + user.getName() + "!");
        title.add(hi);

        // Main page button
        mainPageButton = new JButton("Main Page");
        mainPageButton.addActionListener(new MainPageButtonListener(mainPageController, user));
        buttonPanel.add(mainPageButton);

        // Buttons for non-logged-in users
        if (user.getName().isEmpty()) {
            // Sign Up button
            JButton signUp = new JButton("Sign Up Page");
            signUp.addActionListener(new SignInListener(viewSignupPageController));
            buttonPanel.add(signUp);

            // Log In button
            JButton logIn = new JButton("Login Page");
            logIn.addActionListener(new LogInListener(viewLoginPageController));
            buttonPanel.add(logIn);
        }

        // Buttons for logged-in users
        if (!user.getName().isEmpty()) {
            // Shopping Cart button
            JButton cart = new JButton("Shopping Cart");
            cart.addActionListener(new CartListener(shoppingCartController, user));
            buttonPanel.add(cart);

            // Log Out button
            JButton logOut = new JButton("Log Out");
            logOut.addActionListener(new LogOutListener(logOutController));
            buttonPanel.add(logOut);

            // View Profile button
            JButton profile = new JButton();
            ImageIcon imageIcon = new ImageIcon("src/pic/profile.jpg");
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            profile.setIcon(scaledIcon);
            profile.addActionListener(new ViewProfileListener(viewProfileController, user));
            buttonPanel.add(profile);
        }

        this.add(buttonPanel);
        this.add(title, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No action needed for this method currently
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // No property change handling needed for this method currently
    }

    // Inner classes for ActionListeners

    /**
     * Listener for the Search button.
     */
    private class SearchButtonListener implements ActionListener {
        private final GetSearchPageController getSearchPageController;
        private final User user;

        public SearchButtonListener(GetSearchPageController getSearchPageController, User user) {
            this.getSearchPageController = getSearchPageController;
            this.user = user;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                getSearchPageController.execute(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Listener for the Main Page button.
     */
    private class MainPageButtonListener implements ActionListener {
        private final MainPageController mainPageController;
        private final User user;

        public MainPageButtonListener(MainPageController mainPageController, User user) {
            this.mainPageController = mainPageController;
            this.user = user;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                mainPageController.execute(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Listener for the Sign Up button.
     */
    private class SignInListener implements ActionListener {
        private final ViewSignupPageController viewSignupPageController;

        public SignInListener(ViewSignupPageController viewSignupPageController) {
            this.viewSignupPageController = viewSignupPageController;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                viewSignupPageController.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Listener for the Log In button.
     */
    private class LogInListener implements ActionListener {
        private final ViewLoginPageController viewLoginPageController;

        public LogInListener(ViewLoginPageController viewLoginPageController) {
            this.viewLoginPageController = viewLoginPageController;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                viewLoginPageController.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Listener for the Shopping Cart button.
     */
    private class CartListener implements ActionListener {
        private final ShoppingCartController shoppingCartController;
        private final User user;

        public CartListener(ShoppingCartController shoppingCartController, User user) {
            this.shoppingCartController = shoppingCartController;
            this.user = user;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                shoppingCartController.execute(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Listener for the Log Out button.
     */
    private class LogOutListener implements ActionListener {
        private final LogOutController logOutController;

        public LogOutListener(LogOutController logOutController) {
            this.logOutController = logOutController;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                logOutController.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Listener for the View Profile button.
     */
    private class ViewProfileListener implements ActionListener {
        private final ViewProfileController viewProfileController;
        private final User user;

        public ViewProfileListener(ViewProfileController viewProfileController, User user) {
            this.viewProfileController = viewProfileController;
            this.user = user;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                viewProfileController.execute(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
