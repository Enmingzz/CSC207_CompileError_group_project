package app;

import data_access.factories.interfaces.Product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.Product.DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.Product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.Product.DatabaseProductUpdateStateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.Question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.User.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.User.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.Product.DataBaseProductReadByIdDataAccessObjectFactory;
import data_access.factories.objects.Product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.Product.DatabaseProductUpdateBuyerScheduleDataAccessObjectFactory;
import data_access.factories.objects.Product.DatabaseProductUpdateStateDataAccessObjectFactory;
import data_access.factories.objects.Question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.User.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.User.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.Prouct.ProductReadByIdDataAccessInterface;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.interfaces.Prouct.ProductUpdateBuyerScheduleDataAccessInterface;
import data_access.interfaces.Prouct.ProductUpdateStateDataAccessInterface;
import data_access.interfaces.Question.QuestionReadDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.User.UserCreateDataAccessInterface;
import data_access.interfaces.User.UserReadDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.CommonAnswerFactory;
import entity.comment.CommonQuestionFactory;
import entity.comment.QuestionFactory;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import entity.schedule.ScheduleFactory;
import entity.schedule.CommonScheduleFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.schedule.BuyerSelectSchedulePresenter;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.search_product.SearchProductByNamePresenter;
import interface_adapter.search_product.SearchProductByNameViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;
import interface_adapter.view_product.ViewProductController;
import interface_adapter.view_product.ViewProductPresenter;
import use_case.Signup.SignupInputBoundary;
import use_case.Signup.SignupInteractor;
import use_case.Signup.SignupOutputBoundary;
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
import use_case.schedule.BuyerSelectScheduleInputBoundary;
import use_case.schedule.BuyerSelectScheduleInteractor;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInteractor;
import use_case.view_product.ViewProductOutputBoundary;
import view.product_search.SearchByNameView;
import view.schedule.BuyerScheduleView;

import java.io.IOException;
import java.sql.SQLException;

public class BuyerScheduleUseCaseFactory {

    public static BuyerScheduleView create(ViewManagerModel viewManagerModel) throws SQLException {
        BuyerSelectScheduleViewModel viewModel = new BuyerSelectScheduleViewModel();
        BuyerSelectSchedulePresenter presenter = new BuyerSelectSchedulePresenter(viewModel);

        DataBaseProductReadByIdDataAccessObjectFactoryInterface readByIdFactory =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface updateBuyerScheduleFactory =
                new DatabaseProductUpdateBuyerScheduleDataAccessObjectFactory();
        DatabaseProductUpdateStateDataAccessObjectFactoryInterface updateProductStateFactory =
                new DatabaseProductUpdateStateDataAccessObjectFactory();

        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        ProductReadByIdDataAccessInterface readById = readByIdFactory.create(productFactory, scheduleFactory);
        ProductUpdateBuyerScheduleDataAccessInterface updateBuyerSchedule = updateBuyerScheduleFactory.create();
        ProductUpdateStateDataAccessInterface updateState = updateProductStateFactory.create();


        BuyerSelectScheduleInputBoundary interactor = new BuyerSelectScheduleInteractor(presenter, readById, updateBuyerSchedule, updateState);
        BuyerSelectScheduleController controller = new BuyerSelectScheduleController(interactor, viewManagerModel);

        BuyerScheduleView view = new BuyerScheduleView(viewModel, controller);
        viewModel.addPropertyChangeListener(view);

        return view;
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

}
