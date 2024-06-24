package use_case.view_product;

import data_access.interfaces.QuestionReadDataAccessInterface;
import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

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
        User user = viewProductInputData.getUser();
        String user_type = "buyer";


        ArrayList<Question> lst_ques = questionReadDataAccessObject.getQuestion(product.getProductID());

        if (user.getStudentNumber().equals(product.getSellerStudentNumber())){
            user_type = "seller";
        }

        ViewProductOutputData outputProductQues = new ViewProductOutputData(product, lst_ques, user_type);
        viewPresenter.prepareViewSucceed(outputProductQues);
    }
}
