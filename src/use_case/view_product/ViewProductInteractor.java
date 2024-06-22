package use_case.view_product;

import data_access.interfaces.QuestionReadDataAccessInterface;
import entity.comment.Question;
import entity.product.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViewProductInteractor implements ViewProductInputBoundary{
    final ViewProductOutputBoundary viewPresenter;
    final QuestionReadDataAccessInterface questionReadDataAccessObject;



    public ViewProductInteractor(ViewProductOutputBoundary viewProductOutputBoundary,
                                 QuestionReadDataAccessInterface questionReadDataAccessInterface){
        this.viewPresenter = viewProductOutputBoundary;
        this.questionReadDataAccessObject = questionReadDataAccessInterface;
    }

    @Override
    public void execute(ViewProductInputData viewProductInputData) throws SQLException {
        Product product = viewProductInputData.getProduct();


        ArrayList<Question> lst_ques = questionReadDataAccessObject.getQuestion(product.getProductID());

        ViewProductOutputData outputProductQues = new ViewProductOutputData(product, lst_ques);
        viewPresenter.prepareViewSucceed(outputProductQues);
    }
}
