package app.schedule_usecase_factory;

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
import entity.shopping_cart.ShoppingCartFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.SellerSelectScheduleController;
import interface_adapter.schedule.SellerSelectSchedulePresenter;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.schedule.SellerSelectScheduleOutputBoundary;
import use_case.search_product.*;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.schedule.SellerSelectScheduleInputBoundary;
import use_case.schedule.SellerSelectScheduleInteractor;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.schedule.SellerScheduleView;

import java.io.IOException;
import java.sql.SQLException;

public class SellerScheduleUseCaseFactory {

    public static SellerScheduleView create(SellerSelectScheduleViewModel sellerSelectScheduleViewModel,
                                            ViewManagerModel viewManagerModel,
                                            ViewProfileViewModel viewProfileViewModel) throws SQLException, IOException {
        SellerSelectScheduleController sellerSelectScheduleController =
                SellerScheduleUseCaseFactory.createSellerSelectScheduleController(sellerSelectScheduleViewModel,
                        viewManagerModel, viewProfileViewModel);
        ViewProfileController viewProfileController =
                SellerScheduleUseCaseFactory.createProfileController(viewManagerModel, viewProfileViewModel);
        return new SellerScheduleView(sellerSelectScheduleController, sellerSelectScheduleViewModel, viewProfileController);

    }

    private static SellerSelectScheduleController createSellerSelectScheduleController
            (SellerSelectScheduleViewModel sellerSelectScheduleViewModel, ViewManagerModel viewManagerModel,
             ViewProfileViewModel viewProfileViewModel) throws SQLException {
        SellerSelectScheduleOutputBoundary sellerSelectSchedulePresenter =
                new SellerSelectSchedulePresenter(sellerSelectScheduleViewModel, viewProfileViewModel, viewManagerModel);
        DataBaseProductReadByIdDataAccessObjectFactoryInterface dataBaseProductReadByIdDataAccessObjectFactoryInterface =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                dataBaseProductReadByIdDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface dataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateSellerScheduleDataAccessObjectFactory();
        ProductUpdateSellerScheduleDataAccessInterface productUpdateSellerScheduleDataAccessObject =
                dataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface.create();
        DatabaseProductUpdateStateDataAccessObjectFactoryInterface databaseProductUpdateStateDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateStateDataAccessObjectFactory();
        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject =
                databaseProductUpdateStateDataAccessObjectFactoryInterface.create();
        SellerSelectScheduleInputBoundary sellerSelectScheduleInteractor =
                new SellerSelectScheduleInteractor(sellerSelectSchedulePresenter, productReadByIdDataAccessObject,
                        productUpdateSellerScheduleDataAccessObject, productUpdateStateDataAccessObject);
        return new SellerSelectScheduleController(sellerSelectScheduleInteractor);
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
