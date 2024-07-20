package app;

import app.product_usecase_factory.*;
import app.mainpage_usecase_factory.MainPageUseCaseFactory;
import app.shopping_cart_usecase_factory.ShoppingCartUseCaseFactory;
import app.user_usecase_factory.*;
import app.search_product_usecase_factory.SearchProductUseCaseFactory;
import app.schedule_usecase_factory.BuyerScheduleUseCaseFactory;
import app.schedule_usecase_factory.SellerScheduleUseCaseFactory;
import entity.user.CommonUser;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageState;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ViewModifyProductState;
import interface_adapter.modify_product.ViewCreateProductViewModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileState;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.rating.RateProductState;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.schedule.BuyerSelectScheduleState;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.schedule.SellerSelectScheduleState;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.SearchProductState;
import interface_adapter.search_product.SearchProductViewModel;
//import interface_adapter.search_product.SearchProductByTagViewModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.*;

import view.*;
import view.modify_product.CreateProductView;
import view.modify_product.ModifyProductView;
import view.profile.ManageProductView;
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
        UserFactory commonUserFactory = new CommonUserFactory();

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
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
        //ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        UnloggedInViewModel unloggedInViewModel = new UnloggedInViewModel();
        SignupViewModel signUpViewModel = new SignupViewModel();
        ReplyQuestionViewModel replyQuestionViewModel = new ReplyQuestionViewModel();
        RateProductViewModel rateProductViewModel = new RateProductViewModel();
        ViewCreateProductViewModel viewCreateProductViewModel = new ViewCreateProductViewModel();
        ViewModifyProductViewModel viewModifyProductViewModel = new ViewModifyProductViewModel();




        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, mainPageViewModel, shoppingCartViewModel,
                searchProductViewModel, loginViewModel, viewProfileViewModel);
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainPageViewModel,
                shoppingCartViewModel,
                viewProfileViewModel,
                buyerViewProductViewModel,
                searchProductViewModel,
                signupViewModel);
        ProfileView profileView = ProfileUseCaseFactory.create(viewManagerModel, signupViewModel
                , loginViewModel, mainPageViewModel, shoppingCartViewModel, manageProductViewModel,
                searchProductViewModel, viewProfileViewModel, modifyProfileViewModel);
        ModifyProfileView modifyProfileView = ModifyProfileUseCaseFactory.create(viewManagerModel
                , mainPageViewModel,shoppingCartViewModel, searchProductViewModel, viewProfileViewModel, signUpViewModel,
                loginViewModel,modifyProfileViewModel);
        BuyerViewProductView buyerViewProductView =
                BuyerViewProductUseCaseFactory.create(viewManagerModel, mainPageViewModel, shoppingCartViewModel,
                        viewProfileViewModel, buyerViewProductViewModel, searchProductViewModel,
                        signupViewModel, loginViewModel);
        SellerScheduleView sellerScheduleView = SellerScheduleUseCaseFactory.create(sellerSelectScheduleViewModel,
                viewManagerModel, manageProductViewModel, signupViewModel, loginViewModel, shoppingCartViewModel,
                mainPageViewModel, searchProductViewModel, viewProfileViewModel);

        BuyerScheduleView buyerScheduleView = BuyerScheduleUseCaseFactory.create(buyerSelectScheduleViewModel, shoppingCartViewModel,
                viewManagerModel, signupViewModel, loginViewModel, searchProductViewModel, mainPageViewModel, viewProfileViewModel);

        SellerViewProductView sellerViewProductView = SellerViewProductUseCaseFactory.create(mainPageViewModel, viewManagerModel,
                sellerViewProductViewModel, viewProfileViewModel, replyQuestionViewModel,
                shoppingCartViewModel, searchProductViewModel,
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
                        searchProductViewModel, loginViewModel, signupViewModel,
                        unloggedInViewModel, viewProfileViewModel);

        SearchProductView searchProductView = SearchProductUseCaseFactory.create(searchProductViewModel, viewManagerModel,
                buyerViewProductViewModel, sellerViewProductViewModel, unloggedInViewModel, signupViewModel, loginViewModel,
                shoppingCartViewModel, mainPageViewModel, viewProfileViewModel);

        ManageProductView manageProductView = ManageProductUseCaseFactory.create(searchProductViewModel, manageProductViewModel,
                viewManagerModel, buyerViewProductViewModel, sellerViewProductViewModel, unloggedInViewModel, signupViewModel, loginViewModel,
                shoppingCartViewModel, mainPageViewModel, viewProfileViewModel, viewCreateProductViewModel, viewModifyProductViewModel,
                sellerSelectScheduleViewModel);

        CreateProductView createProductView = CreateProductUseCaseFactory.create(viewCreateProductViewModel, manageProductViewModel,
                shoppingCartViewModel, viewManagerModel, signupViewModel, loginViewModel, searchProductViewModel, viewProfileViewModel,
                mainPageViewModel);

        ModifyProductView modifyProductView =  ModifyProductUseCaseFactory.create(viewModifyProductViewModel, viewManagerModel,
                searchProductViewModel, signupViewModel, loginViewModel, shoppingCartViewModel, mainPageViewModel, viewProfileViewModel,
                manageProductViewModel);

//        SearchByNamePanel searchByNamePanel = SearchProductUseCaseFactory.create(searchProductViewModel, viewManagerModel,
//                buyerViewProductViewModel, sellerViewProductViewModel, unloggedInViewModel, signupViewModel, loginViewModel,
//                shoppingCartViewModel, mainPageViewModel, viewProfileViewModel);
//        SearchByTagPanel searchByTagPanel = SearchByTagUseCaseFactory.create(viewManagerModel, mainPageViewModel); TODO not sure if the two types of search panels should be added?

        /**
         * initialize state
         */

        LoginState loginState = loginViewModel.getState();
        loginState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        loginViewModel.setState(loginState);
        //loginViewModel.firePropertyChanged();
        SignupState signupState = signupViewModel.getState();
        signupState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        signupViewModel.setState(signupState);
        //signupViewModel.firePropertyChanged();
        MainPageState mainPageState = mainPageViewModel.getState();
        mainPageState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        mainPageViewModel.setState(mainPageState);
        //mainPageViewModel.firePropertyChanged();
        ViewProfileState viewProfileState = viewProfileViewModel.getState();
        viewProfileState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        viewProfileViewModel.setState(viewProfileState);
        //viewProfileViewModel.firePropertyChanged();
        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        shoppingCartViewModel.setState(shoppingCartState);
        //shoppingCartViewModel.firePropertyChanged();
        ManageProductState manageProductState = manageProductViewModel.getState();
        manageProductState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        manageProductViewModel.setState(manageProductState);
        //manageProductViewModel.firePropertyChanged();
        ModifyProfileState modifyProfileState = modifyProfileViewModel.getState();
        modifyProfileState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        modifyProfileViewModel.setState(modifyProfileState);
        //modifyProfileViewModel.firePropertyChanged();
        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
        sellerViewProductState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        sellerViewProductViewModel.setState(sellerViewProductState);
        //sellerViewProductViewModel.firePropertyChanged();
        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
        buyerViewProductState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        buyerViewProductViewModel.setState(buyerViewProductState);
        //buyerViewProductViewModel.firePropertyChanged();
        ViewModifyProductState viewModifyProductState = modifyProductViewModel.getState();
        viewModifyProductState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        modifyProductViewModel.setState(viewModifyProductState);
        //modifyProductViewModel.firePropertyChanged();
        SellerSelectScheduleState sellerSelectScheduleState = sellerSelectScheduleViewModel.getState();
        sellerSelectScheduleState.setSeller(commonUserFactory.createUser("", "", "", 0, ""));
        sellerSelectScheduleViewModel.setState(sellerSelectScheduleState);
        //sellerSelectScheduleViewModel.firePropertyChanged();
        BuyerSelectScheduleState buyerSelectScheduleState =
                buyerSelectScheduleViewModel.getState();
        buyerSelectScheduleState.setBuyer(commonUserFactory.createUser("", "", "", 0, ""));
        buyerSelectScheduleViewModel.setState(buyerSelectScheduleState);
        //buyerSelectScheduleViewModel.firePropertyChanged();
        SearchProductState searchProductState = searchProductViewModel.getState();
        searchProductState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        searchProductViewModel.setState(searchProductState);
        //searchProductViewModel.firePropertyChanged();
        UnloggedInState unloggedInState = unloggedInViewModel.getState();
        unloggedInState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        unloggedInViewModel.setState(unloggedInState);
        //unloggedInViewModel.firePropertyChanged();
        SignupState signUpState = signUpViewModel.getState();
        signUpState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        signUpViewModel.setState(signUpState);
        //signUpViewModel.firePropertyChanged();
        ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
        replyQuestionState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        replyQuestionViewModel.setState(replyQuestionState);
        //replyQuestionViewModel.firePropertyChanged();
        RateProductState rateProductState = rateProductViewModel.getState();
        rateProductState.setUser(commonUserFactory.createUser("", "", "", 0, ""));
        rateProductViewModel.setState(rateProductState);
        //rateProductViewModel.firePropertyChanged();


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
        views.add(manageProductView.viewName, manageProductView);
        views.add(createProductView.viewName, createProductView);
        views.add(modifyProductView.viewName, modifyProductView);

//        views.add(searchByNamePanel.viewName, searchByNamePanel);
//        views.add(searchByTagPanel.viewName, searchByTagPanel);

        viewManagerModel.setActiveView(mainPageView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
