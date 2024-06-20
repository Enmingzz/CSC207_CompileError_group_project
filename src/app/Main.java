package app;

import interface_adapter.LoginViewModel;
import interface_adapter.SignupViewModel;
import interface_adapter.ViewManagerModel;
import view.MainPageView;
import view.SignupView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

/**
 * The entrance for the whole program. Run this to start using.
 */

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("CSC207 Project");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();



        //viewManagerModel.setActiveView(MainPageView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
