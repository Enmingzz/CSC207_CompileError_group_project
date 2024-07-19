package app.product_usecase_factory;

import app.search_product_usecase_factory.SearchProductUseCaseFactory;
import data_access.factories.interfaces.product.*;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.*;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.interfaces.product.*;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.login.ViewLoginPagePresenter;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ModifyProductController;
import interface_adapter.modify_product.ModifyProductPresenter;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductPresenter;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.signup.ViewSignupPagePresenter;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.modify_product.*;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInteractor;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.search_product.*;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.signup.ViewSignupPageInputBoundary;
import use_case.signup.ViewSignupPageInteractor;
import use_case.signup.ViewSignupPageOutputBoundary;
import view.modify_product.ModifyProductView;

import java.io.IOException;
import java.sql.SQLException;

public class ModifyProductUseCaseFactory {
    public static ModifyProductView create(ViewModifyProductViewModel viewModifyProductViewModel,
                                           ViewManagerModel viewManagerModel,
                                           SearchProductViewModel searchProductViewModel,
                                           SignupViewModel signupViewModel,
                                           LoginViewModel loginViewModel,
                                           ShoppingCartViewModel shoppingCartViewModel,
                                           MainPageViewModel mainPageViewModel,
                                           ViewProfileViewModel viewProfileViewModel,
                                           ManageProductViewModel manageProductViewModel
                                           ) throws SQLException, IOException {
        ModifyProductController modifyProductController = createmodifyProductController(viewManagerModel, manageProductViewModel);


        ManageProductController manageProductController = createManageProductController(viewManagerModel,
                manageProductViewModel);

        GetSearchPageController getSearchPageController =
                createGetSearchPageController(viewManagerModel, searchProductViewModel);
        ViewSignupPageController viewSignupPageController =
                creatViewSignupPageController(viewManagerModel, signupViewModel);
        ViewLoginPageController viewLoginPageController =
                createViewLoginPageController(loginViewModel, viewManagerModel);
        ShoppingCartController shoppingCartController =
                createShoppingCartController(viewManagerModel, shoppingCartViewModel);
        LogOutController logOutController =
                createLogOutController(viewManagerModel, mainPageViewModel);
        ViewProfileController viewProfileController =
                createProfileController(viewManagerModel, viewProfileViewModel);
        MainPageController mainPageController = createMainPageController(mainPageViewModel, viewManagerModel);


        //TODO implements this method
        return new ModifyProductView(viewModifyProductViewModel,
                modifyProductController,
                manageProductController,
                mainPageController,
                getSearchPageController,
                viewSignupPageController,
                viewLoginPageController,
                shoppingCartController,
                logOutController,
                viewProfileController);
    }


    private  static ModifyProductController createmodifyProductController(ViewManagerModel viewManagerModel,
                                                                          ManageProductViewModel manageProductViewModel) throws SQLException {

        //TODO might need modification in interactor, since we cannot initialize the
        // ChangeProductDescriptionInterface, ChangeProductPriceInterface, ChangeProductPictureInterface, by using
        // databaseinterfaceFactorires?
        ChangeProductOutputBoundary presenter = new ModifyProductPresenter(manageProductViewModel, viewManagerModel);

        DatabaseProductUpdateDescriptionDataAccessObjectFactoryInterface databaseProductUpdateDescriptionDataAccessObjectFactory
                = new DatabaseProductUpdateDescriptionDataAccessObjectFactory();
        ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessObject =
                databaseProductUpdateDescriptionDataAccessObjectFactory.create();


        DatabaseProductUpdatePriceDataAccessObjectFactoryInterface databaseProductUpdatePriceDataAccessObjectFactory
                = new DatabaseProductUpdatePriceDataAccessObjectFactory();
        ProductUpdatePriceDataAccessInterface productUpdatePriceDataAccessObject =
                databaseProductUpdatePriceDataAccessObjectFactory.create();

        ChangeProductInputBoundary interactor = new ChangeProductInteractor(presenter, productUpdatePriceDataAccessObject,
                productUpdateDescriptionDataAccessObject);
        return new ModifyProductController(interactor);
    }

    private  static ManageProductController createManageProductController(ViewManagerModel viewManagerModel,
                                                                          ManageProductViewModel manageProductViewModel) throws SQLException {

        DatabaseProductReadByUserDataAccessObjectFactoryInterface factoryInterface =
                new DatabaseProductReadByUserDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByUserDataAccessInterface productReadByUserDAO = factoryInterface.create(productFactory, scheduleFactory);
        ManageProductOutputBoundary presenter = new ManageProductPresenter(viewManagerModel, manageProductViewModel);
        ManageProductInputBoundary interactor = new ManageProductInteractor(presenter,productReadByUserDAO);
        return new ManageProductController(interactor);
    }

    private static ViewLoginPageController createViewLoginPageController
            (LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) throws SQLException {

        ViewLoginPageOutputBoundary viewLoginPagePresenter = new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }

    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
    }

    private static ShoppingCartController createShoppingCartController(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShoppingCartPresenter presenter = new ShoppingCartPresenter(viewManagerModel,
                shoppingCartViewModel);
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess =
                databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory,
                        productFactory, scheduleFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    private static MainPageController createMainPageController(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ShowMainPageOutputBoundary showMainPagePresenter = new MainPagePresenter(mainPageViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        ShowMainPageInputBoundary showMainPageInteractor =
                new ShowMainPageInteractor(showMainPagePresenter, productReadAllDataAccessObeject);
        return new MainPageController(showMainPageInteractor);
    }

    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel,
                                                           MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary LogOutPresenter = new LogOutPresenter(mainPageViewModel,
                viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(LogOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel) throws IOException {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    private static GetSearchPageController createGetSearchPageController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        GetSearchViewOutputBoundary getSearchViewPresenter =
                new GetSearchPagePresenter(searchProductViewModel, viewManagerModel);
        DataBaseProductReadAllDataAccessObjectFactoryInterface dataBaseProductReadAllDataAccessObjectFactoryInterface = new DatabaseProductReadAllDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadAllDataAccessInterface productReadAllDataAccessObeject =
                dataBaseProductReadAllDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        GetSearchViewInputBoundary getSearchViewInteractor =
                new GetSearchViewInteractor(getSearchViewPresenter, productReadAllDataAccessObeject);
        return new GetSearchPageController(getSearchViewInteractor);
    }


}
