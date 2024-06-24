package app;

import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ModifyProductViewModel;
import interface_adapter.profile.ManageProductViewModel;
import interface_adapter.profile.ModifyProfileViewModel;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;
import interface_adapter.view_product.ViewProductViewModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The entrance for the whole program. Run this to start using.
 * Should initialize all view pages and all view models.
 * Use viewCreateFactory to produce view pages.
 * At final stage, set the initial active viewModel to the MainPageViewModel
 */

public class Main {
    public static void main(String[] args) throws IOException {

        JFrame application = new JFrame("CSC207 Project");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setSize(800, 600);
        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ProfileViewModel profileViewModel = new ProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        ManageProductViewModel manageProductViewModel = new ManageProductViewModel();
        ModifyProfileViewModel modifyProfileViewModel = new ModifyProfileViewModel();
        SellerViewProductViewModel sellerViewProductViewModel = new SellerViewProductViewModel();
        BuyerViewProductViewModel buyerViewProductViewModel = new BuyerViewProductViewModel();
        ModifyProductViewModel modifyProductViewModel = new ModifyProductViewModel();
        SellerSelectScheduleViewModel sellerSelectScheduleViewModel = new SellerSelectScheduleViewModel();
        BuyerSelectScheduleViewModel buyerSelectScheduleViewModel = new BuyerSelectScheduleViewModel();


        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel);
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainPageViewModel);
        ProfileView profileView = ProfileUseCaseFactory.create(viewManagerModel, signupViewModel
                , loginViewModel, mainPageViewModel, profileViewModel,
                shoppingCartViewModel, manageProductViewModel);
        ModifyProfileView modifyProfileView = ModifyProfileUseCaseFactory.create();
        ProductView productView = ViewProductUseCaseFactory.create();
        SellerScheduleView sellerScheduleView = SellerScheduleUseCaseFactory.create();
        BuyerScheduleView buyerScheduleView = BuyerScheduleUseCaseFactory.create();


        TestView testView = new TestView();
        views.add(signupView.viewName, signupView);
        views.add(testView.viewName, testView);
        views.add(loginView);


        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
