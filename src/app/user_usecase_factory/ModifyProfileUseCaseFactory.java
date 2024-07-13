package app.user_usecase_factory;

import data_access.factories.interfaces.product.DataBaseProductReadAllDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductReadByUserDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserUpdateNameDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.user.DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DatabaseProductReadAllDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByNameDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductReadByUserDataAccessObjectFactory;
import data_access.factories.objects.shopping_cart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserReadDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserUpdateNameDataAccessObjectFactory;
import data_access.factories.objects.user.DatabaseUserUpdatePasswordDataAccessObjectFactory;
import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogOutController;
import interface_adapter.logout.LogOutPresenter;
import interface_adapter.main_page.MainPageController;
import interface_adapter.main_page.MainPagePresenter;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ViewModifyProductController;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductPresenter;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.modify_profile.ModifyProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfilePresenter;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
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
import use_case.modify_product.ViewModifyProductInputBoundary;
import use_case.modify_product.ViewModifyProductInteractor;
import use_case.search_product.*;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInteractor;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.modify_profile.ModifyProfileInputBoundary;
import use_case.profile.modify_profile.ModifyProfileInteractor;
import use_case.profile.modify_profile.ModifyProfileOutputBoundary;
import use_case.profile.view_profile.ViewProfileInputBoundary;
import use_case.profile.view_profile.ViewProfileInteractor;
import use_case.profile.view_profile.ViewProfileOutputBoundary;
import use_case.shopping_cart.ShowShoppingCartInputBoundary;
import use_case.shopping_cart.ShowShoppingCartInteractor;
import view.profile.ModifyProfileView;

import java.sql.SQLException;

public class ModifyProfileUseCaseFactory {

    public static ModifyProfileView create(ViewManagerModel viewManagerModel,
                                           MainPageViewModel mainPageViewModel,
                                           ShoppingCartViewModel shoppingCartViewModel,
                                           SearchProductViewModel searchProductViewModel) throws SQLException {
        try {
            MainPageController mainPageController =
                    ModifyProfileUseCaseFactory.createMainPageController(mainPageViewModel,
                            viewManagerModel);
            ModifyProfileController modifyProfileController =
                    ModifyProfileUseCaseFactory.createModifyProfileController();
            ShoppingCartController shoppingCartController =
                    ModifyProfileUseCaseFactory.createShoppingCartController(viewManagerModel,
                            shoppingCartViewModel);
            SearchProductByNameController searchProductByNameVController =
                    ModifyProfileUseCaseFactory.createSearchProductByNameController(viewManagerModel,
                            searchProductViewModel);
            return new ModifyProfileView(modifyProfileController, mainPageController,
                    shoppingCartController, searchProductByNameVController);
        } catch (SQLException e){
            //TODO write some message here
        }
        return null;
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
                                                                 ViewProfileViewModel profileViewModel) {
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

    private static ModifyProfileController createModifyProfileController() throws SQLException {
        DatabaseUserUpdateNameDataAccessObjectFactoryInterface databaseUserUpdateNameDataAccessObjectFactoryInterface
                = new DatabaseUserUpdateNameDataAccessObjectFactory();
        UserUpdateNameDataAccessInterface userUpdateNameDataAccessObject =
                databaseUserUpdateNameDataAccessObjectFactoryInterface.create();
        DatabaseUserUpdatePasswordDataAccessObjectFactoryInterface databaseUserUpdatePasswordDataAccessObjectFactoryInterface = new
                DatabaseUserUpdatePasswordDataAccessObjectFactory();
        UserFactory userFactory = new CommonUserFactory();
        DatabaseUserReadDataAccessObjectFactoryInterface userReadDataAccessObjectFactoryInterface = new DatabaseUserReadDataAccessObjectFactory();
        UserReadDataAccessInterface userReadDataAccessObject =
                userReadDataAccessObjectFactoryInterface.create(userFactory);
        UserUpdatePasswordDataAccessInterface userUpdatePasswordDataAccessObject =
                databaseUserUpdatePasswordDataAccessObjectFactoryInterface.create();
        ModifyProfileOutputBoundary modifyProfilePresenter = new ModifyProfilePresenter();
        ModifyProfileInputBoundary modifyProfileInteractor =
                new ModifyProfileInteractor(userUpdateNameDataAccessObject,
                                        userUpdatePasswordDataAccessObject, userReadDataAccessObject,
                                        modifyProfilePresenter);

        return new ModifyProfileController(modifyProfileInteractor);
    }

    private static ManageProductController createManageProductController(
            ViewManagerModel viewManagerModel, ViewModifyProductViewModel modifyProductViewModel) throws SQLException {
        ManageProductOutputBoundary manageProductPresenter =
                new ManageProductPresenter(viewManagerModel, modifyProductViewModel);
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

    private static ViewModifyProductController createModifyProductController(){
        ViewModifyProductInputBoundary modifyProductInteractor = new ViewModifyProductInteractor();
        return new ViewModifyProductController(modifyProductInteractor);
    }

}
