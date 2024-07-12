package app.product_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartUpdateAddDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
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
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.search_product.SearchProductByNamePresenter;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.view_product.AddToCartController;
import interface_adapter.view_product.AddToCartPresenter;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.PublishQuestionController;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.search_product.SearchProductByNameInputBoundary;
import use_case.search_product.SearchProductByNameInteractor;
import use_case.search_product.SearchProductByNameOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.*;
import use_case.view_product.PublishQuestionInputBoundary;
import use_case.view_product.PublishQuestionInteractor;
import view.view_product.BuyerViewProductView;

import java.io.IOException;
import java.sql.SQLException;

public class BuyerViewProductUseCaseFactory {

    public static BuyerViewProductView create(ViewManagerModel viewManagerModel,
                                              MainPageViewModel mainPageViewModel,
                                              ShoppingCartViewModel shoppingCartViewModel,
                                              ViewProfileViewModel profileViewModel,
                                              BuyerViewProductViewModel buyerViewProductViewModel) throws SQLException {
        MainPageController mainPageController =
                BuyerViewProductUseCaseFactory.createMainPageController(mainPageViewModel,
                        viewManagerModel);
        AddToCartController addToCartController =
                BuyerViewProductUseCaseFactory.createAddToCartController(viewManagerModel,
                        shoppingCartViewModel, buyerViewProductViewModel);
        PublishQuestionController publishQuestionController =
                BuyerViewProductUseCaseFactory.createPublishQuestionController();
        return new BuyerViewProductView(buyerViewProductViewModel, addToCartController, publishQuestionController, mainPageController, );
    }

    private static PublishQuestionController createPublishQuestionController(){
        PublishQuestionInputBoundary publishQuestionInteractor = new PublishQuestionInteractor();
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

    private static SearchProductByNameController createSearchProductByNameController(ViewManagerModel viewManagerModel, SearchProductViewModel searchProductViewModel) throws SQLException {
        SearchProductByNameOutputBoundary searchProductByNamePresenter =
                new SearchProductByNamePresenter(viewManagerModel, searchProductViewModel);
        DatabaseProductReadByNameDataAccessObjectFactoryInterface databaseProductReadByNameDataAccessObjectFactory
                = new DatabaseProductReadByNameDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByNameDataAccessInterface productReadByNameDataAccessObject =
                databaseProductReadByNameDataAccessObjectFactory.create(productFactory, scheduleFactory);
        SearchProductByNameInputBoundary searchProductByNameInteractor =
                new SearchProductByNameInteractor(productReadByNameDataAccessObject,
                        searchProductByNamePresenter);
        return new SearchProductByNameController(searchProductByNameInteractor);
    }


}
