package app;

import data_access.factories.interfaces.Question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.factories.objects.Question.DatabaseQuestionReadDataAccessObjectFactory;
import data_access.interfaces.Question.QuestionReadDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.CommonAnswerFactory;
import entity.comment.CommonQuestionFactory;
import entity.comment.QuestionFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;
import interface_adapter.view_product.ViewProductController;
import interface_adapter.view_product.ViewProductPresenter;
import use_case.view_product.ViewProductInputBoundary;
import use_case.view_product.ViewProductInteractor;
import use_case.view_product.ViewProductOutputBoundary;
import view.profile.ManageProductView;

import java.sql.SQLException;

public class ManageProductUseCaseFactory {

    public static ManageProductView create(){
        //TODO implements this method
        return new ManageProductView();
    }

    private static ViewProductController createViewProductController
            (BuyerViewProductViewModel buyerViewProductViewModel, SellerViewProductViewModel
                    sellerViewProductViewModel, ViewManagerModel viewManagerModel) throws SQLException {
        ViewProductOutputBoundary viewProductPresenter =
                new ViewProductPresenter(buyerViewProductViewModel, sellerViewProductViewModel,
                        viewManagerModel);
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

}
