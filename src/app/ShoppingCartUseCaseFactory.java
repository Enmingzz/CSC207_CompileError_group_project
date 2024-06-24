package app;

import data_access.factories.interfaces.Question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.ShoppingCart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactoryInterface;
import data_access.factories.objects.Question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartReadDataAccessObjectFactory;
import data_access.factories.objects.ShoppingCart.DatabaseShoppingCartUpdateDeleteDataAccessObjectFactory;
import data_access.interfaces.Question.QuestionReadDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartReadDataAccessInterface;
import data_access.interfaces.ShoppingCart.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.CommonAnswerFactory;
import entity.comment.CommonQuestionFactory;
import entity.comment.QuestionFactory;
import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import entity.shopping_cart.CommonShoppingCartFactory;
import entity.shopping_cart.ShoppingCartFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.*;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;
import interface_adapter.view_product.ViewProductController;
import interface_adapter.view_product.ViewProductPresenter;
import use_case.shopping_cart.DeleteShoppingCartProductInputBoundary;
import use_case.shopping_cart.DeleteShoppingCartProductInteractor;
import use_case.shopping_cart.DeleteShoppingCartProductOutputBoundary;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInteractor;
import use_case.view_product.ViewProductOutputBoundary;
import view.shopping_cart.ShoppingCartView;

import java.sql.SQLException;

public class ShoppingCartUseCaseFactory {

    public static ShoppingCartView create(ShoppingCartViewModel shoppingCartViewModel,
                                          ViewProductController viewProductController,
                                          PurchaseController purchaseController,
                                          DeleteShoppingCartProductController deleteShoppingCartProductController){
        //TODO need to implement this method
        return new ShoppingCartView(shoppingCartViewModel,
                viewProductController,
                purchaseController,
                deleteShoppingCartProductController);
    }

    private static ShoppingCartController createShoppingCartController(){
        //TODO TODO need to implement this method
        return new ShoppingCartController();
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

    private static PurchaseController createPurchaseController(){

    }

}
