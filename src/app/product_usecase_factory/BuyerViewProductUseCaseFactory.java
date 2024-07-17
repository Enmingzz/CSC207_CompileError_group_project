package app.product_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.objects.question.DatabaseQuestionCreateDataAccessObject;
import data_access.objects.user.DatabaseUserCreateDataAccessObject;
import data_access.objects.user.DatabaseUserReadDataAccessObject;
import entity.comment.CommonQuestionFactory;
import entity.comment.QuestionFactory;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.login.ViewLoginPagePresenter;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.*;
import interface_adapter.view_product.*;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.search_product.*;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.*;
import use_case.signup.*;
import use_case.view_product.PublishQuestionInputBoundary;
import use_case.view_product.PublishQuestionInteractor;
import use_case.view_product.PublishQuestionOutputBoundary;
import view.login.LoginView;
import view.signup.SignupView;
import view.view_product.BuyerViewProductView;

import java.io.IOException;
import java.sql.SQLException;

public class BuyerViewProductUseCaseFactory {

    public static BuyerViewProductView create(ViewManagerModel viewManagerModel,
                                              MainPageViewModel mainPageViewModel,
                                              ShoppingCartViewModel shoppingCartViewModel,
                                              ViewProfileViewModel profileViewModel,
                                              BuyerViewProductViewModel buyerViewProductViewModel,
                                              SearchProductViewModel searchProductViewModel,
                                              SignupViewModel signupViewModel,
                                              LoginViewModel loginViewModel) throws SQLException, IOException {
        MainPageController mainPageController =
                BuyerViewProductUseCaseFactory.createMainPageController(mainPageViewModel,
                        viewManagerModel);
        AddToCartController addToCartController =
                BuyerViewProductUseCaseFactory.createAddToCartController(viewManagerModel, shoppingCartViewModel, buyerViewProductViewModel);
        PublishQuestionController publishQuestionController =
                BuyerViewProductUseCaseFactory.createPublishQuestionController(buyerViewProductViewModel, viewManagerModel);
        GetSearchPageController getSearchPageController = createGetSearchPageController(viewManagerModel, searchProductViewModel);

        ViewSignupPageController viewSignupPageController = createViewSignupPageController(viewManagerModel, signupViewModel);

        ViewLoginPageController viewLoginPageController = createViewLoginPageController(loginViewModel, viewManagerModel);
        ShoppingCartController shoppingCartController = createShoppingCartController(viewManagerModel, shoppingCartViewModel);
        LogOutController logOutController = createLogOutController(viewManagerModel, mainPageViewModel);

        ViewProfileController viewProfileController = createProfileController(viewManagerModel, profileViewModel);
        return new BuyerViewProductView(buyerViewProductViewModel, addToCartController, publishQuestionController, mainPageController,
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController);
    }

    private  static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel, ViewManagerModel viewManagerModel){


        ViewLoginPageOutputBoundary presenter = new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary interactor = new ViewLoginPageInteractor(presenter);
        return new ViewLoginPageController(interactor);
    }

    private static PublishQuestionController createPublishQuestionController(BuyerViewProductViewModel buyerViewProductViewModel, ViewManagerModel viewManagerModel) throws SQLException {

        QuestionCreateDataAccessInterface questionCreateDataAccessObject = new DatabaseQuestionCreateDataAccessObject();
        QuestionFactory questionFactory = new CommonQuestionFactory();
        PublishQuestionOutputBoundary presenter = new PublishQuestionPresenter(buyerViewProductViewModel, viewManagerModel);

        PublishQuestionInputBoundary publishQuestionInteractor = new PublishQuestionInteractor(questionCreateDataAccessObject, questionFactory, presenter);
        return new PublishQuestionController(publishQuestionInteractor);
    }

    private static AddToCartController createAddToCartController(ViewManagerModel viewManagerModel,
                                                                 ShoppingCartViewModel shoppingCartViewModel,
                                                                 BuyerViewProductViewModel buyerViewProductViewModel) throws SQLException {
        AddShoppingCartProductOutputBoundary addShoppingCartProductOutputPresenter =
                new AddToCartPresenter(viewManagerModel, shoppingCartViewModel, buyerViewProductViewModel);
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface shoppingCartReadDataAccessObjectFactoryInterface
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject =
                shoppingCartReadDataAccessObjectFactoryInterface.create(shoppingCartFactory,
                        productFactory, scheduleFactory);
        DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface shoppingCartUpdateAddDataAccessObjectFactory
                = new DatabaseShoppingCartUpdateAddDataAccessObjectFactory();
        ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateDeleteDataAccessObject =
                shoppingCartUpdateAddDataAccessObjectFactory.create();
        AddShoppingCartProductInputBoundary addShoppingCartProductInteractor =
                new AddShoppingCartProductInteractor(shoppingCartUpdateDeleteDataAccessObject,
                        addShoppingCartProductOutputPresenter, shoppingCartReadDataAccessObject);

        return new AddToCartController(addShoppingCartProductInteractor);
    }

    /**
     * Creates an instance of {@link ShoppingCartController}.
     *
     * @param viewManagerModel     the view manager model
     * @param shoppingCartViewModel the shopping cart view model
     * @return an instance of {@link ShoppingCartController}
     * @throws SQLException if a database access error occurs
     */

    private static ShoppingCartController createShoppingCartController(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel) throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShowShoppingCartOutputBoundary presenter = new ShoppingCartPresenter(viewManagerModel,
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

    private static ViewSignupPageController createViewSignupPageController(ViewManagerModel viewManagerModel,
                                                               SignupViewModel signupViewModel) throws SQLException{
        ViewSignupPageOutputBoundary preseter = new ViewSignupPagePresenter(viewManagerModel, signupViewModel);

        ViewSignupPageInputBoundary interactor = new ViewSignupPageInteractor(preseter);
        return new ViewSignupPageController(interactor);
    }

}
