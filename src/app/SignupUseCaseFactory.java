package app;

import data_access.factories.interfaces.Product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.User.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.User.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.Product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.User.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.User.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.User.UserCreateDataAccessInterface;
import data_access.interfaces.User.UserReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.*;
import interface_adapter.login.*;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.*;
import use_case.Signup.*;
import use_case.login.*;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.product_search.SearchProductByNameInputBoundary;
import use_case.product_search.SearchProductByNameInteractor;
import use_case.product_search.SearchProductByNameOutputBoundary;
import use_case.profile.ViewProfileInputBoundary;
import use_case.profile.ViewProfileInteractor;
import use_case.profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.product_search.SearchByNameView;
import view.signup.SignupView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class SignupUseCaseFactory {

    private SignupUseCaseFactory() {
    }

    public static SignupView create(ViewManagerModel viewManagerModel,
                                    LoginViewModel loginViewModel,
                                    SignupViewModel signupViewModel,
                                    MainPageViewModel mainPageViewModel,
                                    ShoppingCartViewModel shoppingCartViewModel,
                                    SearchProductByNameViewModel searchProductByNameViewModel,
                                    SearchProductByTagViewModel searchProductByTagViewModel,
                                    LoginViewModel LoginViewModel) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel);
            EmailVerificationController emailVerificationController = SignupUseCaseFactory.createEmailVerifyUseCase(viewManagerModel, signupViewModel);
            MainPageController mainPageController =
                    SignupUseCaseFactory.createMainPageController(mainPageViewModel,
                    viewManagerModel);
            ShoppingCartController shoppingCartController =
                    SignupUseCaseFactory.createShoppingCartController(shoppingCartViewModel);
            SearchProductByNameController searchProductByNameController =
                    SignupUseCaseFactory.createSearchProductByNameController(viewManagerModel,
                            searchProductByNameViewModel);
            SearchProductByTagController searchProductByTagController =
                    SignupUseCaseFactory.createSearchProductByTagController();
            ViewLoginPageController viewLoginPageController =
                    SignupUseCaseFactory.createViewLoginPageController();
            return new SignupView(signupController, signupViewModel, emailVerificationController,
                    mainPageController, shoppingCartController, searchProductByNameController,
                    searchProductByTagController, viewLoginPageController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {

        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory
                = new DatabaseUserCreateDataAccessObjectFactory();
        UserCreateDataAccessInterface userCreateDataAccessObject = databaseUserCreateDataAccessObjectFactory.create();
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory
                = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface =
                databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

    private static EmailVerificationController createEmailVerifyUseCase(ViewManagerModel viewManagerModel,
                                                                        SignupViewModel signupViewModel) {
        EmailVerificationOutputBoundary emailVerificationOutputBoundary = new
                EmailVerificationPresenter(viewManagerModel, signupViewModel);
        EmailVerificationInputBoundary emailVerificationInteractor = new
                EmailVerificationInteractor(emailVerificationOutputBoundary);
        return new EmailVerificationController(emailVerificationInteractor);
    }

    private static ShoppingCartController createShoppingCartController(ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShoppingCartPresenter presenter = new ShoppingCartPresenter(shoppingCartViewModel);
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess =
                databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory,
                        productFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    private static MainPageController createMainPageController(MainPageViewModel mainPageViewModel,
                                                               ViewManagerModel viewManagerModel){
        ShowMainPageOutputBoundary showMainPagePresenter = new MainPagePresenter(mainPageViewModel,
                viewManagerModel);
        ShowMainPageInputBoundary showMainPageInteractor =
                new ShowMainPageInteractor(showMainPagePresenter);
        return new MainPageController(showMainPageInteractor);
    }

    private static LoginController createUserLoginUseCase(ViewManagerModel viewManagerModel, LoginViewModel
            loginViewModel, MainPageViewModel mainPageViewModel) throws IOException, SQLException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel, mainPageViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary userLoginInteractor = new LoginInteractor(userReadDataAccessInterface, loginOutputBoundary, userFactory);

        return new LoginController(userLoginInteractor);
    }

    private static ViewLoginPageController createViewLoginPageController(){

        ViewLoginPageOutputBoundary viewLoginPagePresenter = new ViewLoginPagePresenter();
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }


    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel,
                                                           MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary LogOutPresenter = new LogOutPresenter(mainPageViewModel,
                viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(LogOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    private static ProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                             ProfileViewModel profileViewModel){
        ViewProfileOutputBoundary viewProfileOutputBoundary =
                new ProfilePresenter(profileViewModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfileOutputBoundary);
        return new ProfileController(viewProfileInteractor);
    }

    private static SearchProductByNameController createSearchProductByNameController(ViewManagerModel viewManagerModel, SearchProductByNameViewModel searchProductByNameViewModel){
        SearchProductByNameOutputBoundary searchProductByNamePresenter =
                new SearchProductByNamePresenter(viewManagerModel, searchProductByNameViewModel);
        DatabaseProductReadByNameDataAccessObjectFactoryInterface databaseProductReadByNameDataAccessObjectFactory
                = new DatabaseProductReadByNameDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ProductReadByNameDataAccessInterface productReadByNameDataAccessObject =
                databaseProductReadByNameDataAccessObjectFactory.create(productFactory);
        SearchProductByNameInputBoundary searchProductByNameInteractor =
                new SearchProductByNameInteractor(productReadByNameDataAccessObject,
                        searchProductByNamePresenter);
        return new SearchProductByNameController(searchProductByNameInteractor);
    }

    private static SearchProductByTagController createSearchProductByTagController(){
        //TODO need to implement this method
        return new SearchProductByTagController();
    }
}

