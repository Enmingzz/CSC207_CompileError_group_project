package use_case.view_product;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The ViewProductInteractor class implements the use case for viewing a product.
 * It interacts with the data access layer to retrieve questions related to the product
 * and uses the output boundary to present the result.
 */
public class ViewProductInteractor implements ViewProductInputBoundary {
    final ViewProductOutputBoundary viewPresenter;
    final QuestionReadDataAccessInterface questionReadDataAccessObject;

    /**
     * Constructs a ViewProductInteractor with the specified output boundary and data access interface.
     *
     * @param viewProductOutputBoundary the output boundary for presenting the result of the view product use case.
     * @param questionReadDataAccessInterface the data access interface for reading questions.
     */
    public ViewProductInteractor(ViewProductOutputBoundary viewProductOutputBoundary,
                                 QuestionReadDataAccessInterface questionReadDataAccessInterface) {
        this.viewPresenter = viewProductOutputBoundary;
        this.questionReadDataAccessObject = questionReadDataAccessInterface;
    }

    /**
     * Executes the use case of viewing a product.
     *
     * @param viewProductInputData the input data required to view a product.
     * @throws SQLException if there is an error while interacting with the database.
     */
    @Override
    public void execute(ViewProductInputData viewProductInputData) throws SQLException {
        Product product = viewProductInputData.getProduct();
        User user = viewProductInputData.getUser();
        String user_type = "buyer";

        ArrayList<Question> lst_ques = questionReadDataAccessObject.getQuestion(product.getProductID());

        if (user.getStudentNumber().equals(product.getSellerStudentNumber())) {
            user_type = "seller";
        } else if (user.getStudentNumber().equals("")) {
            user_type = "unlogged in";
        }

        ViewProductOutputData outputProductQues = new ViewProductOutputData(product, lst_ques, user_type, user);
        viewPresenter.prepareViewSucceed(outputProductQues);
    }
}
