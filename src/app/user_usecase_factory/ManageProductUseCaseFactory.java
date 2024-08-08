package app.user_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductDeleteByIDDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DataBaseProductDeleteByIDDataAccessObjectFactory;
import data_access.factories.objects.product.DataBaseProductReadByIdDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByUserDataAccessObjectFactory;
import data_access.factories.objects.question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.interfaces.question.QuestionReadDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.user.UserCreateDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
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
import interface_adapter.modify_product.create.ViewCreateProductController;
import interface_adapter.modify_product.create.ViewCreateProductPresenter;
import interface_adapter.modify_product.create.ViewCreateProductViewModel;
import interface_adapter.modify_product.delete.DeleteProductController;
import interface_adapter.modify_product.delete.DeleteProductPresenter;
import interface_adapter.modify_product.modify.ViewModifyProductController;
import interface_adapter.modify_product.modify.ViewModifyProductPresenter;
import interface_adapter.modify_product.modify.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductPresenter;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.seller_select_schedule.GetSellerSchedulePageController;
import interface_adapter.schedule.seller_select_schedule.GetSellerSchedulePagePresenter;
import interface_adapter.schedule.seller_select_schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.search_product.view_search_page.GetSearchPagePresenter;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartPresenter;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupController;
import interface_adapter.signup.signup.SignupPresenter;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import interface_adapter.signup.view_signup_page.ViewSignupPagePresenter;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import interface_adapter.view_product.non_logged_in_view.UnloggedInViewModel;
import interface_adapter.view_product.non_logged_in_view.ViewProductController;
import interface_adapter.view_product.non_logged_in_view.ViewProductPresenter;
import interface_adapter.view_product.seller_view.SellerViewProductViewModel;
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
import use_case.schedule.*;
import use_case.search_product.*;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInteractor;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.*;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInteractor;
import use_case.view_product.ViewProductOutputBoundary;
import view.profile.ManageProductView;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This class is responsible for creating and managing the product view.
 */

public class ManageProductUseCaseFactory {

    /**
     * Creates an instance of ManageProductView.
     *
     * @param searchProductViewModel      the search product view model
     * @param manageProductViewModel      the manage product view model
     * @param viewManagerModel            the view manager model
     * @param buyerViewProductViewModel   the buyer view product view model
     * @param sellerViewProductViewModel  the seller view product view model
     * @param unloggedInViewModel         the unlogged-in view model
     * @param signupViewModel             the signup view model
     * @param loginViewModel              the login view model
     * @param shoppingCartViewModel       the shopping cart view model
     * @param mainPageViewModel           the main page view model
     * @param viewProfileViewModel        the view profile view model
     * @param viewCreateProductViewModel  the view create product view model
     * @param viewModifyProductViewModel  the view modify product view model
     * @param sellerSelectScheduleViewModel the seller select schedule view model
     * @return an instance of ManageProductView
     * @throws SQLException if a database access error occurs
     */

    public static ManageProductView create(SearchProductViewModel searchProductViewModel,
                                           ManageProductViewModel manageProductViewModel,
                                           ViewManagerModel viewManagerModel,
                                           BuyerViewProductViewModel buyerViewProductViewModel,
                                           SellerViewProductViewModel sellerViewProductViewModel,
                                           UnloggedInViewModel unloggedInViewModel,
                                           SignupViewModel signupViewModel,
                                           LoginViewModel loginViewModel,
                                           ShoppingCartViewModel shoppingCartViewModel,
                                           MainPageViewModel mainPageViewModel,
                                           ViewProfileViewModel viewProfileViewModel,
                                           ViewCreateProductViewModel viewCreateProductViewModel,
                                           ViewModifyProductViewModel viewModifyProductViewModel,
                                           SellerSelectScheduleViewModel sellerSelectScheduleViewModel) throws SQLException {

        MainPageController mainPageController = createMainPageController(mainPageViewModel, viewManagerModel);
        ViewCreateProductController viewCreateProductController = createViewCreateProductController(
                viewCreateProductViewModel, viewManagerModel);
        DeleteProductController deleteProductController = createDeleteProductController(
                manageProductViewModel, viewManagerModel);
        ViewModifyProductController viewModifyProductController = createViewModifyProductController(
                viewModifyProductViewModel, viewManagerModel);
        ViewProductController viewProductController = createViewProductController(buyerViewProductViewModel,
                sellerViewProductViewModel, viewManagerModel,unloggedInViewModel);
        GetSellerSchedulePageController getSellerSchedulePageController = createGetSellerSchedulePageController(
                sellerSelectScheduleViewModel, viewManagerModel);
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

        return new ManageProductView(mainPageController,
                viewCreateProductController,
                deleteProductController,
                viewModifyProductController,
                manageProductViewModel,
                viewProductController,
                getSellerSchedulePageController,
                getSearchPageController,
                viewSignupPageController,
                viewLoginPageController,
                shoppingCartController,
                logOutController,
                viewProfileController);
    }

    /**
     * Creates an instance of ViewSignupPageController.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @return an instance of ViewSignupPageController
     */

    private static ViewSignupPageController creatViewSignupPageController(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel){
        ViewSignupPageOutputBoundary viewSignupPagePresenter =
                new ViewSignupPagePresenter(viewManagerModel, signupViewModel);
        ViewSignupPageInputBoundary viewSignupPageInteractor =
                new ViewSignupPageInteractor(viewSignupPagePresenter);
        return new ViewSignupPageController(viewSignupPageInteractor);
    }

    /**
     * Creates an instance of SignupController.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @param loginViewModel   the login view model
     * @return an instance of SignupController
     * @throws IOException   if an I/O error occurs
     * @throws SQLException  if a database access error occurs
     */

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {

        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory
                = new DatabaseUserCreateDataAccessObjectFactory();
        UserCreateDataAccessInterface userCreateDataAccessObject =
                databaseUserCreateDataAccessObjectFactory.create();
        SignupOutputBoundary signupOutputBoundary = new
                SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory =
                new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface =
                databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());

        DatabaseShoppingCartCreateDataAccessObjectFactoryInterface databaseShoppingCartCreateDataAccessObjectFactory =
                new DatabaseShoppingCartCreateDataAccessObjectFactory();
        ShoppingCartCreateDataAccessInterface shoppingCartCreateDataAccessObject =
                databaseShoppingCartCreateDataAccessObjectFactory.create();

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userCreateDataAccessObject, userReadDataAccessInterface, signupOutputBoundary, userFactory, shoppingCartCreateDataAccessObject);

        return new SignupController(userSignupInteractor);
    }

    /**
     * Creates an instance of ViewLoginPageController.
     *
     * @param loginViewModel   the login view model
     * @param viewManagerModel the view manager model
     * @return an instance of ViewLoginPageController
     * @throws SQLException if a database access error occurs
     */

    private static ViewLoginPageController createViewLoginPageController
            (LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) throws SQLException {

        ViewLoginPageOutputBoundary viewLoginPagePresenter = new ViewLoginPagePresenter(loginViewModel, viewManagerModel);
        ViewLoginPageInputBoundary viewLoginPageInteractor =
                new ViewLoginPageInteractor(viewLoginPagePresenter);
        return new ViewLoginPageController(viewLoginPageInteractor);
    }

    /**
     * Creates an instance of ViewProductController.
     *
     * @param buyerViewProductViewModel the buyer view product view model
     * @param sellerViewProductViewModel the seller view product view model
     * @param viewManagerModel           the view manager model
     * @param non_loggedInProductView    the unlogged-in view model
     * @return an instance of ViewProductController
     * @throws SQLException if a database access error occurs
     */

    private static ViewProductController createViewProductController
            (BuyerViewProductViewModel buyerViewProductViewModel, SellerViewProductViewModel
                    sellerViewProductViewModel, ViewManagerModel viewManagerModel,
             UnloggedInViewModel non_loggedInProductView) throws SQLException {
        ViewProductOutputBoundary viewProductPresenter =
                new ViewProductPresenter(buyerViewProductViewModel, sellerViewProductViewModel,
                        non_loggedInProductView, viewManagerModel);
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
     * Creates an instance of MainPageController.
     *
     * @param mainPageViewModel the main page view model
     * @param viewManagerModel  the view manager model
     * @return an instance of MainPageController
     * @throws SQLException if a database access error occurs
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

        DataBaseProductReadByIdDataAccessObjectFactoryInterface dataBaseProductReadByIdDataAccessObjectFactory =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                dataBaseProductReadByIdDataAccessObjectFactory.create(productFactory, scheduleFactory);

        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess, productReadByIdDataAccessObject, shoppingCartFactory);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    /**
     * Factory method to create a LogOutController.
     *
     * @param viewManagerModel The view manager model.
     * @param mainPageViewModel The main page view model.
     * @return A new instance of LogOutController.
     * @throws SQLException if a database access error occurs.
     */

    private static LogOutController createLogOutController(ViewManagerModel viewManagerModel,
                                                           MainPageViewModel mainPageViewModel) throws SQLException {
        LogOutOutputBoundary LogOutPresenter = new LogOutPresenter(mainPageViewModel,
                viewManagerModel);
        LogOutInputBoundary logOutInteractor = new LogOutInteractor(LogOutPresenter);
        return new LogOutController(logOutInteractor);
    }

    /**
     * Factory method to create a ViewProfileController.
     *
     * @param viewManagerModel The view manager model.
     * @param profileViewModel The profile view model.
     * @return A new instance of ViewProfileController.
     */

    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel){
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
    }

    /**
     * Factory method to create a GetSearchPageController.
     *
     * @param viewManagerModel The view manager model.
     * @param searchProductViewModel The search product view model.
     * @return A new instance of GetSearchPageController.
     * @throws SQLException if a database access error occurs.
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
     * Factory method to create a ManageProductController.
     *
     * @param viewManagerModel The view manager model.
     * @param manageProductViewModel The manage product view model.
     * @return A new instance of ManageProductController.
     * @throws SQLException if a database access error occurs.
     */

    private static ManageProductController createManageProductController(
            ViewManagerModel viewManagerModel,  ManageProductViewModel manageProductViewModel) throws SQLException {
        ManageProductOutputBoundary manageProductPresenter =
                new ManageProductPresenter(viewManagerModel, manageProductViewModel);
        DatabaseProductReadByUserDataAccessObjectFactoryInterface databaseProductReadByUserDataAccessObjectFactoryInterface
                = new DatabaseProductReadByUserDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        ProductReadByUserDataAccessInterface productReadByUserDataAccessObject =
                databaseProductReadByUserDataAccessObjectFactoryInterface.create(productFactory,
                        scheduleFactory);
        ManageProductInputBoundary manageProductInteractor =
                new ManageProductInteractor(manageProductPresenter, productReadByUserDataAccessObject);
        return new ManageProductController(manageProductInteractor);
    }

    /**
     * Factory method to create a ViewCreateProductController.
     *
     * @param viewCreateProductViewModel The view model for creating a product.
     * @param viewManagerModel The view manager model.
     * @return A new instance of ViewCreateProductController.
     */

    private static ViewCreateProductController createViewCreateProductController(
            ViewCreateProductViewModel viewCreateProductViewModel,
            ViewManagerModel viewManagerModel) {
        ViewCreateProductOutputBoundary viewCreateProductPresenter =
                new ViewCreateProductPresenter(viewCreateProductViewModel, viewManagerModel);
        ViewCreateProductInputBoundary viewCreateProductInteractor =
                new ViewCreateProductInteractor(viewCreateProductPresenter);
        return new ViewCreateProductController(viewCreateProductInteractor);
    }

    /**
     * Factory method to create a DeleteProductController.
     *
     * @param manageProductViewModel The manage product view model.
     * @param viewManagerModel The view manager model.
     * @return A new instance of DeleteProductController.
     * @throws SQLException if a database access error occurs.
     */

    private static DeleteProductController createDeleteProductController(
            ManageProductViewModel manageProductViewModel,
            ViewManagerModel viewManagerModel
    ) throws SQLException {

        DataBaseProductDeleteByIDDataAccessObjectFactoryInterface databaseProductDeleteByIDDataAccessObjectFactoryObject =
                new DataBaseProductDeleteByIDDataAccessObjectFactory();

        DeleteProductOutputBoundary deleteProductPresenter =
                new DeleteProductPresenter(
                        manageProductViewModel,
                        viewManagerModel);

        ProductDeleteDataAccessByIDInterface productDeleteDataAccessObject =
                databaseProductDeleteByIDDataAccessObjectFactoryObject.create();

        DeleteProductInputBoundary deleteProductInteractor = new DeleteProductInteractor(
                deleteProductPresenter,
                productDeleteDataAccessObject);
        return new DeleteProductController(deleteProductInteractor);
    }

    /**
     * Factory method to create a ViewModifyProductController.
     *
     * @param viewModifyProductViewModel The view model for modifying a product.
     * @param viewManagerModel The view manager model.
     * @return A new instance of ViewModifyProductController.
     */

    private static ViewModifyProductController createViewModifyProductController (
            ViewModifyProductViewModel viewModifyProductViewModel, ViewManagerModel viewManagerModel) {
        ViewModifyProductOutputBoundary viewModifyProductPresenter =
                new ViewModifyProductPresenter(viewModifyProductViewModel, viewManagerModel);
        ViewModifyProductInputBoundary viewModifyProductInteractor =
                new ViewModifyProductInteractor(viewModifyProductPresenter);
        return new ViewModifyProductController(viewModifyProductInteractor);
    }

    /**
     * Factory method to create a GetSellerSchedulePageController.
     *
     * @param sellerSelectScheduleViewModel The view model for the seller's schedule selection.
     * @param viewManagerModel The view manager model.
     * @return A new instance of GetSellerSchedulePageController.
     */

    private static GetSellerSchedulePageController createGetSellerSchedulePageController(
            SellerSelectScheduleViewModel sellerSelectScheduleViewModel, ViewManagerModel viewManagerModel) {
        GetSellerSchedulePageOutputBoundary presenter =
                new GetSellerSchedulePagePresenter(sellerSelectScheduleViewModel, viewManagerModel);
        GetSellerSchedulePageInputBoundary interactor =
                new GetSellerSchedulePageInteractor(presenter);
        return new GetSellerSchedulePageController(interactor);
    }
}
