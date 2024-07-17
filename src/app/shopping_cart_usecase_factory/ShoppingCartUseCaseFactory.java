package app.shopping_cart_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductUpdateStateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DataBaseProductReadByIdDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductUpdateStateDataAccessObjectFactory;
import data_access.factories.objects.question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import data_access.interfaces.question.QuestionReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.CommonAnswerFactory;
import entity.comment.CommonQuestionFactory;
import entity.comment.QuestionFactory;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
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
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.rating.GetRatePageController;
import interface_adapter.rating.GetRatePagePresenter;
import interface_adapter.rating.RateProductController;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.schedule.GetBuyerSchedulePageController;
import interface_adapter.schedule.GetBuyerSchedulePagePresenter;
import interface_adapter.search_product.*;
import interface_adapter.shopping_cart.*;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.signup.ViewSignupPagePresenter;
import interface_adapter.view_product.*;
import use_case.rate_product.GetRatePageInputBoundary;
import use_case.rate_product.GetRatePageInteractor;
import use_case.rate_product.GetRatePageOutputBoundary;
import use_case.schedule.GetBuyerSchedulePageInputBoundary;
import use_case.schedule.GetBuyerSchedulePageInteractor;
import use_case.schedule.GetBuyerSchedulePageOutputBoundary;
import use_case.search_product.*;
import use_case.signup.ViewSignupPageInputBoundary;
import use_case.signup.ViewSignupPageInteractor;
import use_case.signup.ViewSignupPageOutputBoundary;
import use_case.login.ViewLoginPageInputBoundary;
import use_case.login.ViewLoginPageInteractor;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInteractor;
import use_case.logout.LogOutOutputBoundary;
import use_case.main_page.ShowMainPageInputBoundary;
import use_case.main_page.ShowMainPageInteractor;
import use_case.main_page.ShowMainPageOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.*;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInteractor;
import use_case.view_product.ViewProductOutputBoundary;
import view.shopping_cart.ShoppingCartView;
import view.view_product.NonloggedInProductView;

import java.io.IOException;
import java.sql.SQLException;

public class ShoppingCartUseCaseFactory {

    /**
     * returns a new instance of ShoppingCartView, given the view models associated with each controller on the view
     * page
     *
     * @param shoppingCartViewModel: the view model associated with ShoppingCartView
     * @param buyerViewProductViewModel: the view model associated with BuyerViewProduct
     * @param sellerViewProductViewModel: the view model associated with SellerViewProduct
     * @param unloggedInViewModel: the view model associated with UnloggedInViewProduct
     * @param buyerSelectScheduleViewModel: the view model associated with BuyerSelectScheduleView
     * @param rateProductViewModel: the view model associated with RateProductView
     * @param viewProfileViewModel: the view model associated with ViewProfileView
     * @param mainPageViewModel: the view model associated with MainPageView
     * @param searchProductViewModel: the view model associated with SearchProductView
     * @param viewManagerModel: module responsible for switching between view pages when the app runs.
     * @return shoppingCartView: returns a new view page of instance ShoppingCartView
     * @throws SQLException: throws any exception related to the remote SQL database
     */

    public static ShoppingCartView create(ShoppingCartViewModel shoppingCartViewModel,
                                          BuyerViewProductViewModel buyerViewProductViewModel,
                                          SellerViewProductViewModel sellerViewProductViewModel,
                                          UnloggedInViewModel unloggedInViewModel,
                                          BuyerSelectScheduleViewModel buyerSelectScheduleViewModel,
                                          RateProductViewModel rateProductViewModel,
                                          ViewProfileViewModel viewProfileViewModel,
                                          MainPageViewModel mainPageViewModel,
                                          SearchProductViewModel searchProductViewModel,
                                          ViewManagerModel viewManagerModel) throws SQLException {
        ViewProductController viewProductController =
                ShoppingCartUseCaseFactory.createViewProductController(buyerViewProductViewModel,
                        sellerViewProductViewModel, viewManagerModel, unloggedInViewModel);
        PurchaseController purchaseController =
                ShoppingCartUseCaseFactory.createPurchaseController(shoppingCartViewModel,
                        viewManagerModel);
        DeleteShoppingCartProductController deleteShoppingCartProductController =
                ShoppingCartUseCaseFactory.createDeleteShoppingCartProductController(
                        shoppingCartViewModel, viewManagerModel);
        GetBuyerSchedulePageController getBuyerSelectScheduleController =
                ShoppingCartUseCaseFactory.createGetBuyerSelectPageScheduleController(buyerSelectScheduleViewModel,
                        viewManagerModel);

        ConfirmController confirmController = ShoppingCartUseCaseFactory.createConfirmController(rateProductViewModel,
                shoppingCartViewModel,
                viewManagerModel);

        GetRatePageController getRatePageController =
                ShoppingCartUseCaseFactory.createRateProductController(rateProductViewModel, viewManagerModel);

        // Top bar controllers start here
        ShoppingCartController shoppingCartController = ShoppingCartUseCaseFactory.createShoppingCartController(
                viewManagerModel,
                shoppingCartViewModel);

        ViewProfileController viewProfileController = ShoppingCartUseCaseFactory.createviewProfileController(
                viewProfileViewModel,
                viewManagerModel
        );
        GetSearchPageController getSearchPageController = ShoppingCartUseCaseFactory.createGetSearchPageController(
                viewManagerModel,
                searchProductViewModel
        );
        LogOutController logOutController = ShoppingCartUseCaseFactory.createLogOutController(viewManagerModel,
                mainPageViewModel);

        MainPageController mainPageController = ShoppingCartUseCaseFactory.createMainPageController(mainPageViewModel,
                viewManagerModel);



        return new ShoppingCartView(shoppingCartViewModel,
                viewProductController,
                purchaseController,
                deleteShoppingCartProductController,
                getBuyerSelectScheduleController,
                confirmController,
                getRatePageController,
                shoppingCartController,
                viewProfileController,
                getSearchPageController,
                logOutController,
                mainPageController);
    }

    /**
     * Helper function that returns a new ViewProfileController
     * @param profileViewModel: view model associated with ProfileView
     * @param viewManagerModel: module responsible for switching between view pages when the app runs.
     * @return viewProfileController: returns a new instance of ViewProfileController
     */

    private static ViewProfileController createviewProfileController(ViewProfileViewModel profileViewModel,
                                                                     ViewManagerModel viewManagerModel) {

        ViewProfileOutputBoundary viewProfilePresenter = new
                ViewProfilePresenter(profileViewModel, viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor =
                new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    /**
     * Helper function that returns a new ShoppingCartController
     * @param viewManagerModel: module responsible for switching between view pages when the app runs.
     * @param shoppingCartViewModel: view model associated with ShoppingCartView
     * @return shoppingCartController: returns an instance of ShoppingCartController
     * @throws SQLException: throws any exception related to the database
     */

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

    /**
     * returns a new instance of ViewProductController given the necessary view models.
     * @param buyerViewProductViewModel: view model associated with the BuyerViewProductView
     * @param sellerViewProductViewModel: view model associated with the SellerViewProductView
     * @param viewManagerModel: module responsible for changing the view page of the app
     * @param unloggedInProductViewModel: view model associated with UnloggedInProductView
     * @return viewProductController: returns a new ViewProductController
     * @throws SQLException: throws any exception related to database
     */

    private static ViewProductController createViewProductController
            (BuyerViewProductViewModel buyerViewProductViewModel, SellerViewProductViewModel
                    sellerViewProductViewModel, ViewManagerModel viewManagerModel,
             UnloggedInViewModel unloggedInProductViewModel) throws SQLException {
        ViewProductOutputBoundary viewProductPresenter =
                new ViewProductPresenter(buyerViewProductViewModel, sellerViewProductViewModel,
                        unloggedInProductViewModel, viewManagerModel);
        DatabaseQuestionReadDataAccessObjectFactoryInterface databaseQuestionReadDataAccessObjectFactory = new DatabaseQuestionReadDataAccessObjectFactory();
        QuestionFactory commonQuestionFactory = new CommonQuestionFactory();
        AnswerFactory commonAnswerFactory = new CommonAnswerFactory();
        QuestionReadDataAccessInterface questionReadDataAccess =
                new DatabaseQuestionReadDataAccessObjectFactory().create(commonQuestionFactory,
                        commonAnswerFactory);
        ViewProductInputBoundary viewProductInteractor =
                new ViewProductInteractor(viewProductPresenter, questionReadDataAccess);
        return new ViewProductController(viewProductInteractor);
    }

    /**
     * returns a new instance of DeleteShoppingCartController given the necessary view models.
     * @param shoppingCartViewModel: view model associated with ShoppingCartView
     * @param viewManagerModel: module responsible for changing view of the app.
     * @return deleteShoppingCartProductController: returns a new instance of DeleteShoppingCartProductController
     * @throws SQLException: throws any exception related to database
     */

    private static DeleteShoppingCartProductController createDeleteShoppingCartProductController(
            ShoppingCartViewModel shoppingCartViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ShoppingCartFactory commonShoppingCartFactory = new CommonShoppingCartFactory();
        DeleteShoppingCartProductOutputBoundary deleteShoppingCartProductPresenter =
                new DeleteShoppingCartProductPresenter(shoppingCartViewModel, viewManagerModel);
        ProductFactory commonProductFactory = new CommonProductFactory();
        DatabaseShoppingCartReadDataAccessObjectFactoryInterface databaseShoppingCartReadDataAccessObjectFactory
                = new DatabaseShoppingCartReadDataAccessObjectFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject =
                databaseShoppingCartReadDataAccessObjectFactory.create(commonShoppingCartFactory,
                        commonProductFactory, scheduleFactory);
        DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface databaseShoppingCartUpdateDeleteDataAccessObjectFactory
                = new DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory();
        ShoppingCartUpdateDeleteDataAccessInterface shoppingCartUpdateDeleteDataAccessObject =
                databaseShoppingCartUpdateDeleteDataAccessObjectFactory.create();
        DeleteShoppingCartProductInputBoundary deleteShoppingCartProductInteractor =
                new DeleteShoppingCartProductInteractor(shoppingCartUpdateDeleteDataAccessObject,
                        shoppingCartReadDataAccessObject, deleteShoppingCartProductPresenter);
        return new DeleteShoppingCartProductController(deleteShoppingCartProductInteractor);
    }

    /**
     * returns an instance of PurchaseController given all necessary view models as an input
     * @param shoppingCartViewModel: view model associated with ShoppingCartView
     * @param viewManagerModel: module responsible for changing view page
     * @return purchaseController: returns an instance of PurchaseController
     * @throws SQLException: throws any exception related to database
     */

    private static PurchaseController createPurchaseController(ShoppingCartViewModel shoppingCartViewModel,
                                                               ViewManagerModel viewManagerModel) throws SQLException {

        DatabaseProductUpdateStateDataAccessObjectFactoryInterface databaseProductUpdateStateDataAccessObjectFactory =
                new DatabaseProductUpdateStateDataAccessObjectFactory();

        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject =
                databaseProductUpdateStateDataAccessObjectFactory.create();

        DataBaseProductReadByIdDataAccessObjectFactoryInterface databaseProductReadByIdDataAccessObjectFactory =
                new DataBaseProductReadByIdDataAccessObjectFactory();

        ProductFactory commonProductFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                databaseProductReadByIdDataAccessObjectFactory.create(commonProductFactory, scheduleFactory);

        PurchaseOutputBoundary purchaseOutputBoundary = new PurchasePresenter(shoppingCartViewModel, viewManagerModel);

        PurchaseInputBoundary purchaseInteractor = new PurchaseInteractor(productUpdateStateDataAccessObject,
                productReadByIdDataAccessObject,
                purchaseOutputBoundary);
        return new PurchaseController(purchaseInteractor);
    }

    /**
     * returns an instance of MainPageController given all view models associated with it
     * @param mainPageViewModel: view model associated with MainPageView
     * @param viewManagerModel: module responsible for switching between view pages
     * @return mainPageController: returns a new instance of MainPageController
     * @throws SQLException: throws any exception related to database
     */

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

    /**
     * returns an instance of GetBuyerScheduleController
     * @param buyerSelectScheduleViewModel: view model associated with BuyerSelectScheduleView
     * @param viewManagerModel: module associated with switching view pages
     * @return getBuyerSchedulePageController: returns a new instance of GetBuyerSchedulePageController
     */

    public static GetBuyerSchedulePageController createGetBuyerSelectPageScheduleController(
            BuyerSelectScheduleViewModel buyerSelectScheduleViewModel,
            ViewManagerModel viewManagerModel){

        GetBuyerSchedulePageOutputBoundary getBuyerSelectSchedulePagePresenter =
                new GetBuyerSchedulePagePresenter(buyerSelectScheduleViewModel, viewManagerModel);
        GetBuyerSchedulePageInputBoundary getBuyerSchedulePageInteractor =
                new GetBuyerSchedulePageInteractor(getBuyerSelectSchedulePagePresenter);
        return new GetBuyerSchedulePageController(getBuyerSchedulePageInteractor);
    }

    /**
     * Creates an instance of {@link ConfirmController}.
     *
     * @param rateProductViewModel    the view model for rating products
     * @param shoppingCartViewModel   the view model for the shopping cart
     * @param viewManagerModel        the view manager model
     * @return an instance of {@link ConfirmController}
     * @throws SQLException if a database access error occurs
     */

    public static ConfirmController createConfirmController(RateProductViewModel rateProductViewModel,
                                                            ShoppingCartViewModel shoppingCartViewModel,
                                                            ViewManagerModel viewManagerModel) throws SQLException {

        ConfirmOutputBoundary confirmPresenter = new
                ConfirmPresenter(rateProductViewModel, shoppingCartViewModel, viewManagerModel);

        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        DataBaseProductReadByIdDataAccessObjectFactoryInterface productReadByIdDataAccessObjectFactory =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                productReadByIdDataAccessObjectFactory.create(productFactory, scheduleFactory);

        DatabaseProductUpdateStateDataAccessObjectFactoryInterface productUpdateStateDataAccessObjectFactory =
                new DatabaseProductUpdateStateDataAccessObjectFactory();
        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject =
                productUpdateStateDataAccessObjectFactory.create();

        ConfirmInputBoundary confirmInteractor =
                new ConfirmInteractor(confirmPresenter,
                        productUpdateStateDataAccessObject,
                        productReadByIdDataAccessObject);
        return new ConfirmController(confirmInteractor);
    }

    /**
     * Creates an instance of {@link GetRatePageController}.
     *
     * @param rateProductViewModel the view model for rating products
     * @param viewManagerModel     the view manager model
     * @return an instance of {@link GetRatePageController}
     */

    public static GetRatePageController createRateProductController(RateProductViewModel rateProductViewModel,
                                                                    ViewManagerModel viewManagerModel){

        GetRatePageOutputBoundary getRatePagePresenter =
                new GetRatePagePresenter(rateProductViewModel, viewManagerModel);
        GetRatePageInputBoundary getRatePageInteractor =
                new GetRatePageInteractor(getRatePagePresenter);
        return new GetRatePageController(getRatePageInteractor);
    }

    /**
     * Creates an instance of {@link LogOutController}.
     *
     * @param viewManagerModel the view manager model
     * @param mainPageViewModel the main page view model
     * @return an instance of {@link LogOutController}
     * @throws SQLException if a database access error occurs
     */

    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel,
                                                           MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary LogOutPresenter = new LogOutPresenter(mainPageViewModel,
                viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(LogOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    /**
     * Creates an instance of {@link GetSearchPageController}.
     *
     * @param viewManagerModel       the view manager model
     * @param searchProductViewModel the search product view model
     * @return an instance of {@link GetSearchPageController}
     * @throws SQLException if a database access error occurs
     */

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

    /**
     * Creates an instance of {@link ViewLoginPageController}.
     *
     * @param loginViewModel   the login view model
     * @param viewManagerModel the view manager model
     * @return an instance of {@link ViewLoginPageController}
     */

    private static ViewLoginPageController createViewLoginPageController(LoginViewModel loginViewModel,
                                                                         ViewManagerModel viewManagerModel){

        ViewLoginPageOutputBoundary viewLoginPagePresenter =
                new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }

    /**
     * Creates an instance of {@link ViewSignupPageController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @return an instance of {@link ViewSignupPageController}
     */

    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
    }


}
