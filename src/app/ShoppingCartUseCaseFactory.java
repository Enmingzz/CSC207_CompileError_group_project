package app;

import data_access.factories.interfaces.Product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.Product.DatabaseProductUpdateStateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.Question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface;
import data_access.factories.objects.Product.DataBaseProductReadByIdDataAccessObjectFactory;
import data_access.factories.objects.Product.DatabaseProductUpdateStateDataAccessObjectFactory;
import data_access.factories.objects.Question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory;
import data_access.interfaces.Prouct.ProductReadByIdDataAccessInterface;
import data_access.interfaces.Prouct.ProductUpdateStateDataAccessInterface;
import data_access.interfaces.Question.QuestionReadDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.objects.Product.DatabaseProductUpdateStateDataAccessObject;
import entity.comment.AnswerFactory;
import entity.comment.CommonAnswerFactory;
import entity.comment.CommonQuestionFactory;
import entity.comment.QuestionFactory;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.rating.RateProductController;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.shopping_cart.*;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;
import interface_adapter.view_product.ViewProductController;
import interface_adapter.view_product.ViewProductPresenter;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.profile.ViewProfileInputBoundary;
import use_case.profile.ViewProfileInteractor;
import use_case.profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.*;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInteractor;
import use_case.view_product.ViewProductOutputBoundary;
import view.shopping_cart.ShoppingCartView;
import view.view_product.BuyerViewProductView;

import java.sql.SQLException;

public class ShoppingCartUseCaseFactory {

    public static ShoppingCartView create(ShoppingCartViewModel shoppingCartViewModel,
                                          BuyerViewProductViewModel buyerViewProductViewModel,
                                          SellerViewProductViewModel sellerViewProductViewModel,
                                          ViewManagerModel viewManagerModel) throws SQLException {
        //TODO need to implement this method
        ViewProductController viewProductController =
                ShoppingCartUseCaseFactory.createViewProductController(buyerViewProductViewModel,
                        sellerViewProductViewModel, viewManagerModel);
        PurchaseController purchaseController =
                ShoppingCartUseCaseFactory.createPurchaseController(shoppingCartViewModel,
                        viewManagerModel);
        DeleteShoppingCartProductController deleteShoppingCartProductController =
                ShoppingCartUseCaseFactory.createDeleteShoppingCartProductController(
                        shoppingCartViewModel, viewManagerModel);
        BuyerSelectScheduleController buyerSelectScheduleController =
                ShoppingCartUseCaseFactory.createBuyerSelectScheduleController();
        ConfirmController confirmController = ShoppingCartUseCaseFactory.createConfirmController();
        RateProductController rateProductController =
                ShoppingCartUseCaseFactory.createRateProductController();
        return new ShoppingCartView(shoppingCartViewModel,
                viewProductController,
                purchaseController,
                deleteShoppingCartProductController,
                buyerSelectScheduleController,
                confirmController,
                rateProductController);
    }

    private static ShoppingCartController createShoppingCartController() throws SQLException {
        ShoppingCartFactory shoppingCartFactory = new CommonShoppingCartFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ShoppingCartPresenter presenter = new ShoppingCartPresenter();
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess =
                databaseShoppingCartReadDataAccessObjectFactory.create(shoppingCartFactory,
                        productFactory);
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    private static ViewProductController createViewProductController
            (BuyerViewProductViewModel buyerViewProductViewModel, SellerViewProductViewModel
                    sellerViewProductViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ViewProductOutputBoundary viewProductPresenter =
                new ViewProductPresenter(buyerViewProductViewModel, sellerViewProductViewModel,
                        viewManagerModel);
        DatabaseQuestionReadDataAccessObjectFactoryInterface databaseQuestionReadDataAccessObjectFactory
                = new DatabaseQuestionReadDataAccessObjectFactory();
        QuestionFactory commonQuestionFactory = new CommonQuestionFactory();
        AnswerFactory commonAnswerFactory = new CommonAnswerFactory();
        QuestionReadDataAccessInterface questionReadDataAccess =
                new DatabaseQuestionReadDataAccessObjectFactory().create(commonQuestionFactory,
                        commonAnswerFactory);
        ViewProductInputBoundary viewProductInteractor =
                new ViewProductInteractor(viewProductPresenter, questionReadDataAccess);
        return new ViewProductController(viewProductInteractor);
    }

    private static DeleteShoppingCartProductController createDeleteShoppingCartProductController(
            ShoppingCartViewModel shoppingCartViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ShoppingCartFactory commonShoppingCartFactory = new CommonShoppingCartFactory();
        DeleteShoppingCartProductOutputBoundary deleteShoppingCartProductPresenter =
                new DeleteShoppingCartProductPresenter(shoppingCartViewModel, viewManagerModel);
        ProductFactory commonProductFactory = new CommonProductFactory();
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject =
                databaseShoppingCartReadDataAccessObjectFactory.create(commonShoppingCartFactory,
                        commonProductFactory);
        DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface databaseShoppingCartUpdateDeleteDataAccessObjectFactory
                = new DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory();
        ShoppingCartUpdateDeleteDataAccessInterface shoppingCartUpdateDeleteDataAccessObject =
                databaseShoppingCartUpdateDeleteDataAccessObjectFactory.create();
        DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor =
                new DeleteShoppingCartProductInteractor(shoppingCartUpdateDeleteDataAccessObject,
                        shoppingCartReadDataAccessObject, deleteShoppingCartProductPresenter);
        return new DeleteShoppingCartProductController(deleteShoppingCartProductInteractor);
    }

    private static PurchaseController createPurchaseController(ShoppingCartViewModel shoppingCartViewModel,
                                                               ViewManagerModel viewManagerModel) throws SQLException {

        DatabaseProductUpdateStateDataAccessObjectFactoryInterface databaseProductUpdateStateDataAccessObjectFactory =
                new DatabaseProductUpdateStateDataAccessObjectFactory();

        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject =
                databaseProductUpdateStateDataAccessObjectFactory.create();

        DataBaseProductReadByIdDataAccessObjectFactoryInterface databaseProductReadByIdDataAccessObjectFactory =
                new DataBaseProductReadByIdDataAccessObjectFactory();

        ProductFactory commonProductFactory = new CommonProductFactory();

        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                databaseProductReadByIdDataAccessObjectFactory.create(commonProductFactory);

        PurchaseOutputBoundary purchaseOutputBoundary = new PurchasePresenter(shoppingCartViewModel, viewManagerModel);

        PurchaseInputBoundary purchaseInteractor = new PurchaseInteractor(productUpdateStateDataAccessObject,
                productReadByIdDataAccessObject,
                purchaseOutputBoundary);
        return new PurchaseController(purchaseInteractor);
    }

    private static MainPageController createMainPageController(MainPageViewModel mainPageViewModel, ViewManagerModel viewManagerModel){
        ShowMainPageOutputBoundary showMainPagePresenter = new MainPagePresenter(mainPageViewModel, viewManagerModel);
        ShowMainPageInputBoundary showMainPageInteractor =
                new ShowMainPageInteractor(showMainPagePresenter);
        return new MainPageController(showMainPageInteractor);
    }

    public static BuyerSelectScheduleController createBuyerSelectScheduleController(){
        //TODO  need to implement this method
        return new BuyerSelectScheduleController();
    }

    public static ConfirmController createConfirmController(){
        //TODO need to implement this method
        return new ConfirmController();
    }

    public static RateProductController createRateProductController(){
        //TODO need to implement this method
        return new RateProductController();
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

}
