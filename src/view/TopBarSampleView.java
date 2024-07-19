package view;

import entity.user.User;
import interface_adapter.login.LoginController;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.BuyerViewProductState;
import view.view_product.BuyerViewProductView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class TopBarSampleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "top bar sample view";

    private final JButton searchButton;
    private final JButton mainPageButton;

    private final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel title = new JPanel();

    public TopBarSampleView(User user, GetSearchPageController getSearchPageController,
                            ViewSignupPageController viewSignupPageController,
                            ViewLoginPageController viewLoginPageController,
                            ShoppingCartController shoppingCartController,
                            LogOutController logOutController,
                            ViewProfileController viewProfileController,
                            MainPageController mainPageController) {

        this.setLayout(new BorderLayout());

        //(1)search button
        searchButton = new JButton("Search");
        class SearchButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(searchButton)){
                    try{
                        getSearchPageController.execute(user);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        searchButton.addActionListener(new SearchButtonListener());
        buttonPanel.add(searchButton);

        //(2)hi, user. if it's already logged in
        JLabel hi;
        if (user == null){
            hi = new JLabel("Welcome!");
        } else {
            hi = new JLabel("hi, " + user.getName());
        }
        title.add(hi);

        //(3)jump to main page
        mainPageButton = new JButton("main page");
        class MainPageButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(mainPageButton)){
                    try{
                        mainPageController.execute(user);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        mainPageButton.addActionListener(new MainPageButtonListener());
        buttonPanel.add(mainPageButton);

        //haven't logged in
        if(Objects.equals(user, null)){
            //(4)signUp
            JButton signUp = new JButton("Sign in");
            class SignInListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(evt.getSource().equals(signUp)){
                        try {
                            viewSignupPageController.execute();
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            signUp.addActionListener(new SignInListener());
            buttonPanel.add(signUp);

            //(5)logIn
            JButton logIn = new JButton("Log in");
            class LogInListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent evt){
                    if(evt.getSource().equals(logIn)){
                        try {
                            viewLoginPageController.execute();
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            logIn.addActionListener(new LogInListener());
            buttonPanel.add(logIn);
        }


        //already logged in
        if(!Objects.equals(user, null)){
            //（6）shoppingCart
            JButton cart = new JButton("Cart");
            class CartListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(evt.getSource().equals(cart)){
                        try {
                            shoppingCartController.execute(user);
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            cart.addActionListener(new CartListener());
            buttonPanel.add(cart);

            //(7)logOut
            JButton logOut = new JButton("Log out");
            class LogOutListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(evt.getSource().equals(logOut)){
                        try{
                            logOutController.execute();
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            logOut.addActionListener(new LogOutListener());
            buttonPanel.add(logOut);


            //(8) ViewProfile
            JButton profile = new JButton();
            ImageIcon imageIcon = new ImageIcon("/src/pic/testpic4.png");
            profile.setIcon(imageIcon);
            class ViewProfileListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent evt){
                    if(evt.getSource().equals(profile)){
                        try{
                            viewProfileController.execute(user);
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            profile.addActionListener(new ViewProfileListener());
            buttonPanel.add(profile);
        }
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(title, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
