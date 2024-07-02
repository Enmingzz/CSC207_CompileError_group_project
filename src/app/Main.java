package app;

import app.ProductUseCaseFactory.NonLoggedInViewProductUseFactory;
import app.ShoppingCartAndMainPageUseCaseFactory.MainPageUseCaseFactory;
import app.ShoppingCartAndMainPageUseCaseFactory.ShoppingCartUseCaseFactory;
import app.UserUseCaseFactory.LoginUseCaseFactory;
import app.UserUseCaseFactory.SignupUseCaseFactory;
import app.SearchUseCaseFactory.SearchByNameUseCaseFactory;
import app.SearchUseCaseFactory.SearchByTagUseCaseFactory;
import app.ProductUseCaseFactory.BuyerViewProductUseCaseFactory;
import app.ProductUseCaseFactory.SellerViewProductUseCaseFactory;
import app.UserUseCaseFactory.ModifyProfileUseCaseFactory;
import app.UserUseCaseFactory.ProfileUseCaseFactory;
import app.ScheduleUseCaseFactory.BuyerScheduleUseCaseFactory;
import app.ScheduleUseCaseFactory.SellerScheduleUseCaseFactory;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.ManageProduct.ManageProductViewModel;
import interface_adapter.profile.ModifyProfile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.SearchProductByNameViewModel;
import interface_adapter.search_product.SearchProductByTagViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;

import view.*;
import view.product_search.SearchByNameView;
import view.product_search.SearchByTagView;
import view.shopping_cart.ShoppingCartView;
import view.login.LoginView;
import view.main_page.MainPageView;
import view.profile.ModifyProfileView;
import view.profile.ProfileView;
import view.schedule.BuyerScheduleView;
import view.schedule.SellerScheduleView;
import view.signup.SignupView;
import view.view_product.BuyerViewProductView;
import view.view_product.NonloggedInProductView;
import view.view_product.SellerViewProductView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The entrance for the whole program. Run this to start using.
 * Should initialize all view pages and all view models.
 * Use viewCreateFactory to produce view pages.
 * At final stage, set the initial active viewModel to the MainPageViewModel
 */

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

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
        ViewProfileViewModel profileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        ManageProductViewModel manageProductViewModel = new ManageProductViewModel();
        ModifyProfileViewModel modifyProfileViewModel = new ModifyProfileViewModel();
        SellerViewProductViewModel sellerViewProductViewModel = new SellerViewProductViewModel();
        BuyerViewProductViewModel buyerViewProductViewModel = new BuyerViewProductViewModel();
        ViewModifyProductViewModel modifyProductViewModel = new ViewModifyProductViewModel();
        SellerSelectScheduleViewModel sellerSelectScheduleViewModel = new SellerSelectScheduleViewModel();
        BuyerSelectScheduleViewModel buyerSelectScheduleViewModel = new BuyerSelectScheduleViewModel();
        SearchProductByNameViewModel searchProductByNameViewModel = new SearchProductByNameViewModel();
        SearchProductByTagViewModel searchProductByTagViewModel = new SearchProductByTagViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();


        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, mainPageViewModel, shoppingCartViewModel,
                searchProductByNameViewModel, searchProductByTagViewModel, loginViewModel);
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainPageViewModel);
        ProfileView profileView = ProfileUseCaseFactory.create(viewManagerModel, signupViewModel
                , loginViewModel, mainPageViewModel, profileViewModel,
                shoppingCartViewModel, manageProductViewModel);
        ModifyProfileView modifyProfileView = ModifyProfileUseCaseFactory.create(viewManagerModel
                , mainPageViewModel,shoppingCartViewModel, searchProductByNameViewModel);
        BuyerViewProductView buyerViewProductView =
                BuyerViewProductUseCaseFactory.create(viewManagerModel, mainPageViewModel,
                        shoppingCartViewModel, profileViewModel, buyerViewProductViewModel);
        SellerScheduleView sellerScheduleView = SellerScheduleUseCaseFactory.create();
        BuyerScheduleView buyerScheduleView = BuyerScheduleUseCaseFactory.create();
        SellerViewProductView sellerViewProductView = SellerViewProductUseCaseFactory.create();
        MainPageView mainPageView = MainPageUseCaseFactory.Create(viewManagerModel,
                        mainPageViewModel, shoppingCartViewModel, signupViewModel, loginViewModel,
                viewProfileViewModel, searchProductByNameViewModel, buyerViewProductViewModel,
                sellerViewProductViewModel);
        ShoppingCartView shoppingCartView =
                ShoppingCartUseCaseFactory.create(shoppingCartViewModel,
                        buyerViewProductViewModel, sellerViewProductViewModel, viewManagerModel);
        NonloggedInProductView productView = NonLoggedInViewProductUseFactory.create(viewManagerModel);
        SearchByNameView searchByNameView = SearchByNameUseCaseFactory.create();
        SearchByTagView searchByTagView = SearchByTagUseCaseFactory.create(viewManagerModel, mainPageViewModel);


        TestView testView = new TestView();
        views.add(signupView.viewName, signupView);
        views.add(loginView.viewName, loginView);
        views.add(testView.viewName, testView);
        views.add(buyerViewProductView.viewName, buyerViewProductView);
        views.add(modifyProfileView.viewName, modifyProfileView);
        views.add(sellerScheduleView.viewName, sellerScheduleView);
        views.add(buyerScheduleView.viewName, buyerScheduleView);
        views.add(profileView.viewName, profileView);
        views.add(sellerViewProductView.viewName, sellerViewProductView);
        views.add(mainPageView.viewName, mainPageView);
        views.add(shoppingCartView.viewName, shoppingCartView);
        views.add(productView.viewName, productView);
        views.add(searchByNameView.viewName, searchByNameView);
        views.add(searchByTagView.viewName, searchByTagView);


        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
