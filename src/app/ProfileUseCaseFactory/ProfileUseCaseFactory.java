package app.ProfileUseCaseFactory;

import data_access.factories.interfaces.Product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.Product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.ManageProduct.ManageProductViewModel;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.search_product.SearchProductByNamePresenter;
import interface_adapter.search_product.SearchProductByNameViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
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
import view.profile.ProfileView;

import java.io.IOException;
import java.sql.SQLException;

public class ProfileUseCaseFactory {

    private ProfileUseCaseFactory() {
    }

    public static ProfileView create(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel, ProfileViewModel profileViewModel, ShoppingCartViewModel shoppingCartViewModel, ManageProductViewModel manageProductViewModel) throws IOException {
        //TODO implements this
        return null;
    }

    private static ProfileController createProfileController(ViewManagerModel viewManagerModel,
                                             SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException {

        return null;
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

    private static MainPageController createMainPageController(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel){
        ShowMainPageOutputBoundary showMainPagePresenter = new MainPagePresenter(mainPageViewModel, viewManagerModel);
        ShowMainPageInputBoundary showMainPageInteractor =
                new ShowMainPageInteractor(showMainPagePresenter);
        return new MainPageController(showMainPageInteractor);
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

}
