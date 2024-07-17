package app;

import app.product_usecase_factory.NonLoggedInViewProductUseFactory;
import app.mainpage_usecase_factory.MainPageUseCaseFactory;
import app.shopping_cart_usecase_factory.ShoppingCartUseCaseFactory;
import app.user_usecase_factory.LoginUseCaseFactory;
import app.user_usecase_factory.SignupUseCaseFactory;
import app.search_product_usecase_factory.SearchProductUseCaseFactory;
import app.product_usecase_factory.BuyerViewProductUseCaseFactory;
import app.product_usecase_factory.SellerViewProductUseCaseFactory;
import app.user_usecase_factory.ModifyProfileUseCaseFactory;
import app.user_usecase_factory.ProfileUseCaseFactory;
import app.schedule_usecase_factory.BuyerScheduleUseCaseFactory;
import app.schedule_usecase_factory.SellerScheduleUseCaseFactory;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.search_product.SearchProductByTagViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.ReplyQuestionViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;

import interface_adapter.view_product.UnloggedInViewModel;
import view.*;
import view.search_product.SearchProductView;
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
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
//        SearchProductByTagViewModel searchProductByTagViewModel = new SearchProductByTagViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        UnloggedInViewModel unloggedInViewModel = new UnloggedInViewModel();
        SignupViewModel signUpViewModel = new SignupViewModel();
        ReplyQuestionViewModel replyQuestionViewModel = new ReplyQuestionViewModel();
        RateProductViewModel rateProductViewModel = new RateProductViewModel();


        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, mainPageViewModel, shoppingCartViewModel,
                searchProductViewModel, loginViewModel, viewProfileViewModel);
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainPageViewModel,
                shoppingCartViewModel,
                profileViewModel,
                buyerViewProductViewModel,
                searchProductViewModel,
                signupViewModel);
        ProfileView profileView = ProfileUseCaseFactory.create(viewManagerModel, signupViewModel
                , loginViewModel, mainPageViewModel, profileViewModel,
                shoppingCartViewModel, manageProductViewModel);
        ModifyProfileView modifyProfileView = ModifyProfileUseCaseFactory.create(viewManagerModel
                , mainPageViewModel,shoppingCartViewModel, searchProductViewModel, viewProfileViewModel, signUpViewModel,
                loginViewModel,modifyProfileViewModel);
        BuyerViewProductView buyerViewProductView =
                BuyerViewProductUseCaseFactory.create(viewManagerModel, mainPageViewModel, shoppingCartViewModel,
                        profileViewModel, buyerViewProductViewModel, searchProductViewModel, signupViewModel, loginViewModel);
        SellerScheduleView sellerScheduleView = SellerScheduleUseCaseFactory.create(sellerSelectScheduleViewModel,
                viewManagerModel, manageProductViewModel, signupViewModel, loginViewModel, shoppingCartViewModel,
                mainPageViewModel, searchProductViewModel, viewProfileViewModel);

        BuyerScheduleView buyerScheduleView = BuyerScheduleUseCaseFactory.create(buyerSelectScheduleViewModel, shoppingCartViewModel,
                viewManagerModel, signupViewModel, loginViewModel, searchProductViewModel, mainPageViewModel, viewProfileViewModel);

        SellerViewProductView sellerViewProductView = SellerViewProductUseCaseFactory.create(mainPageViewModel, viewManagerModel,
                sellerViewProductViewModel, profileViewModel, replyQuestionViewModel, shoppingCartViewModel, searchProductViewModel,
                signupViewModel, loginViewModel);

        MainPageView mainPageView = MainPageUseCaseFactory.create(viewManagerModel,
                        mainPageViewModel, shoppingCartViewModel, signupViewModel, loginViewModel,
                viewProfileViewModel, searchProductViewModel, buyerViewProductViewModel,
                sellerViewProductViewModel, unloggedInViewModel);
        ShoppingCartView shoppingCartView =
                ShoppingCartUseCaseFactory.create(shoppingCartViewModel, buyerViewProductViewModel, sellerViewProductViewModel,
                        unloggedInViewModel, buyerSelectScheduleViewModel, rateProductViewModel, viewProfileViewModel, mainPageViewModel,
                        searchProductViewModel, viewManagerModel, signupViewModel, loginViewModel);

        NonloggedInProductView productView =
                NonLoggedInViewProductUseFactory.create(viewManagerModel, mainPageViewModel, shoppingCartViewModel,
                        searchProductViewModel, loginViewModel, signupViewModel, unloggedInViewModel, profileViewModel);

        SearchProductView searchProductView = SearchProductUseCaseFactory.create(searchProductViewModel, viewManagerModel,
                buyerViewProductViewModel, sellerViewProductViewModel, unloggedInViewModel, signupViewModel, loginViewModel,
                shoppingCartViewModel, mainPageViewModel, viewProfileViewModel);

//        SearchByNamePanel searchByNamePanel = SearchProductUseCaseFactory.create(searchProductViewModel, viewManagerModel,
//                buyerViewProductViewModel, sellerViewProductViewModel, unloggedInViewModel, signupViewModel, loginViewModel,
//                shoppingCartViewModel, mainPageViewModel, viewProfileViewModel);
//        SearchByTagPanel searchByTagPanel = SearchByTagUseCaseFactory.create(viewManagerModel, mainPageViewModel); TODO not sure if the two types of search panels should be added?


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
        views.add(searchProductView.viewName,searchProductView);

//        views.add(searchByNamePanel.viewName, searchByNamePanel);
//        views.add(searchByTagPanel.viewName, searchByTagPanel);


        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
