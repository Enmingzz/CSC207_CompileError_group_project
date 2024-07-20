package app.product_usecase_factory;

import app.mainpage_usecase_factory.MainPageUseCaseFactory;
import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.question.DatabaseQuestionCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.question.DatabaseQuestionUpdateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserCreateDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.question.DatabaseQuestionCreateDataAccessObjectFactory;
import data_access.factories.objects.question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.factories.objects.question.DatabaseQuestionUpdateDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartCreateDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserCreateDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import data_access.interfaces.question.QuestionReadDataAccessInterface;
import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
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
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.search_product.GetSearchPagePresenter;
import interface_adapter.search_product.SearchProductViewModel;
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
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.search_product.GetSearchViewInputBoundary;
import use_case.search_product.GetSearchViewInteractor;
import use_case.search_product.GetSearchViewOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import use_case.shopping_cart.ShowShoppingCartOutputBoundary;
import use_case.signup.*;
import use_case.view_product.*;
import view.main_page.MainPageView;
import view.view_product.SellerReplyView;

import java.io.IOException;
import java.sql.SQLException;

public class SellerReplyUseCaseFactory {

    /**
     * Creates a SellerReplyView instance along with its required controllers and view models.
     *
     * @param replyQuestionViewModel        the view model for replying to questions
     * @param viewManagerModel              the view manager model
     * @param mainPageViewModel             the main page view model
     * @param shoppingCartViewModel         the shopping cart view model
     * @param signupViewModel               the signup view model
     * @param loginViewModel                the login view model
     * @param viewProfileViewModel          the view profile view model
     * @param searchProductViewModel        the search product view model
     * @param buyerViewProductViewModel     the buyer view product view model
     * @param sellerViewProductViewModel    the seller view product view model
     * @param unloggedInViewModel           the unlogged-in view model
     * @return a new instance of SellerReplyView
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */

    public static SellerReplyView create(ReplyQuestionViewModel replyQuestionViewModel,
                                         ViewManagerModel viewManagerModel,
                                         MainPageViewModel mainPageViewModel,
                                         ShoppingCartViewModel shoppingCartViewModel,
                                         SignupViewModel signupViewModel,
                                         LoginViewModel loginViewModel,
                                         ViewProfileViewModel viewProfileViewModel,
                                         SearchProductViewModel searchProductViewModel,
                                         BuyerViewProductViewModel buyerViewProductViewModel,
                                         SellerViewProductViewModel sellerViewProductViewModel,
                                         UnloggedInViewModel unloggedInViewModel
    ) throws SQLException, IOException {

        ViewProductController viewProductController =
                SellerReplyUseCaseFactory.createViewProductController(buyerViewProductViewModel,
                        sellerViewProductViewModel,
                        viewManagerModel,
                        unloggedInViewModel);
        MainPageController mainPageController =
                SellerReplyUseCaseFactory.createMainPageController(mainPageViewModel,
                        viewManagerModel);
        ShoppingCartController shoppingCartController =
                SellerReplyUseCaseFactory.createShoppingCartController(viewManagerModel,
                        shoppingCartViewModel);
        LogOutController logOutController =
                SellerReplyUseCaseFactory.createLogOutController(viewManagerModel, mainPageViewModel);
        ViewProfileController viewProfileController =
                SellerReplyUseCaseFactory.createProfileController(viewManagerModel,
                        viewProfileViewModel);

        GetSearchPageController getSearchPageController =
                SellerReplyUseCaseFactory.createGetSearchPageController(viewManagerModel,
                        searchProductViewModel);

        ViewLoginPageController viewLoginPageController =
                SellerReplyUseCaseFactory.createViewLoginPageController(loginViewModel,viewManagerModel);
        ViewSignupPageController viewSignupPageController =
                SellerReplyUseCaseFactory.creatViewSignupPageController(viewManagerModel, signupViewModel);

        ReplyQuestionController replyQuestionController =
                SellerReplyUseCaseFactory.createReplyQuestionController(
                        replyQuestionViewModel,
                        sellerViewProductViewModel,
                        viewManagerModel);

        return new SellerReplyView(replyQuestionViewModel,
                replyQuestionController,
                mainPageController,
                getSearchPageController,
                viewSignupPageController,
                viewLoginPageController,
                shoppingCartController,
                logOutController,
                viewProfileController);
    }

    /**
     * Creates an instance of ReplyQuestionController with the given parameters.
     *
     * @param replyQuestionViewModel     the view model for replying to questions
     * @param sellerViewProductViewModel the seller view product view model
     * @param viewManagerModel           the view manager model
     * @return a new instance of ReplyQuestionController
     * @throws SQLException if a database access error occurs
     */

    private static ReplyQuestionController createReplyQuestionController(ReplyQuestionViewModel replyQuestionViewModel,
                                                                         SellerViewProductViewModel sellerViewProductViewModel,
                                                                         ViewManagerModel viewManagerModel) throws SQLException {

        ReplyQuestionOutputBoundary replyQuestionPresenter =
                new ReplyQuestionPresenter(replyQuestionViewModel,
                        sellerViewProductViewModel,
                        viewManagerModel);

        DatabaseQuestionUpdateDataAccessObjectFactoryInterface databaseQuestionUpdateDataAccessObjectFactory =
                new DatabaseQuestionUpdateDataAccessObjectFactory();
        QuestionUpdateDataAccessInterface questionUpdateDAO =
                databaseQuestionUpdateDataAccessObjectFactory.create();

        DatabaseQuestionReadDataAccessObjectFactoryInterface databaseQuestionReadDataAccessObjectFactory =
                new DatabaseQuestionReadDataAccessObjectFactory();
        QuestionFactory questionFactory = new CommonQuestionFactory();
        AnswerFactory answerFactory = new CommonAnswerFactory();
        QuestionReadDataAccessInterface questionReadDAO =
                databaseQuestionReadDataAccessObjectFactory.create(questionFactory, answerFactory);

        ReplyQuestionInputBoundary replyQuestionInteractor =
                new ReplyQuestionInteractor(questionUpdateDAO,
                        replyQuestionPresenter,
                        questionReadDAO,
                        answerFactory,
                        questionFactory);
        return new ReplyQuestionController(replyQuestionInteractor);
    }

    /**
     * Creates an instance of {@link ViewProductController}.
     *
     * @param buyerViewProductViewModel  the buyer view product view model
     * @param sellerViewProductViewModel the seller view product view model
     * @param viewManagerModel           the view manager model
     * @param unloggedInViewModel        the unlogged-in view model
     * @return an instance of {@link ViewProductController}
     * @throws SQLException if a database access error occurs
     */

    private static ViewProductController createViewProductController
    (BuyerViewProductViewModel buyerViewProductViewModel, SellerViewProductViewModel
            sellerViewProductViewModel, ViewManagerModel viewManagerModel,
     UnloggedInViewModel unloggedInViewModel) throws SQLException {
        ViewProductOutputBoundary viewProductPresenter =
                new ViewProductPresenter(buyerViewProductViewModel, sellerViewProductViewModel,
                        unloggedInViewModel, viewManagerModel);
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
     * Creates an instance of {@link SignupController}.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @param loginViewModel   the login view model
     * @return an instance of {@link SignupController}
     * @throws IOException  if an I/O error occurs
     * @throws SQLException if a database access error occurs
     */

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException, SQLException {

        //TODO: CHECK WHETHER THIS CAN BE DELETED OR NOT
        DatabaseUserCreateDataAccessObjectFactoryInterface databaseUserCreateDataAccessObjectFactory = new DatabaseUserCreateDataAccessObjectFactory();
        UserCreateDataAccessInterface userCreateDataAccessObject = databaseUserCreateDataAccessObjectFactory.create();
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        DatabaseUserReadDataAccessObjectFactoryInterface databaseUserReadDataAccessObjectFactory = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessInterface = databaseUserReadDataAccessObjectFactory.create(new CommonUserFactory());
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

    /**
     * Creates an instance of {@link MainPageController}.
     *
     * @param mainPageViewModel the main page view model
     * @param viewManagerModel  the view manager model
     * @return an instance of {@link MainPageController}
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
        ShowShoppingCartInputBoundary showShoppingCartInteractor =
                new ShowShoppingCartInteractor(presenter, shoppingCartReadDataAccess);
        return new ShoppingCartController(showShoppingCartInteractor);
    }

    /**
     * Creates an instance of {@link LogOutController}.
     *
     * @param viewManagerModel  the view manager model
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
     * Creates an instance of {@link ViewProfileController}.
     *
     * @param viewManagerModel  the view manager model
     * @param profileViewModel  the view profile view model
     * @return an instance of {@link ViewProfileController}
     * @throws IOException if an I/O error occurs
     */

    private static ViewProfileController createProfileController(ViewManagerModel viewManagerModel,
                                                                 ViewProfileViewModel profileViewModel) throws IOException {
        ViewProfileOutputBoundary viewProfilePresenter = new ViewProfilePresenter(profileViewModel,
                viewManagerModel);
        ViewProfileInputBoundary viewProfileInteractor = new ViewProfileInteractor(viewProfilePresenter);
        return new ViewProfileController(viewProfileInteractor);
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
}
