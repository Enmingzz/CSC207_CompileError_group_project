package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

/**
 * The ViewReplyQuestionInteractor class implements the use case for viewing the reply to a question.
 * It uses the output boundary to present the result.
 */
public class ViewReplyQuestionInteractor implements ViewReplyQuestionInputBoundary {

    private final ViewReplyQuestionOutputBoundary viewReplyPresenter;

    /**
     * Constructs a ViewReplyQuestionInteractor with the specified output boundary.
     *
     * @param viewReplyQuestionOutputBoundary the output boundary for presenting the result of the view reply question use case.
     */
    public ViewReplyQuestionInteractor(ViewReplyQuestionOutputBoundary viewReplyQuestionOutputBoundary) {
        this.viewReplyPresenter = viewReplyQuestionOutputBoundary;
    }

    /**
     * Executes the use case of viewing the reply to a question.
     *
     * @param viewReplyQuestionInputData the input data required to view the reply to a question.
     * @throws SQLException if there is an error while interacting with the database.
     */
    @Override
    public void execute(ViewReplyQuestionInputData viewReplyQuestionInputData) throws SQLException {

        User seller = viewReplyQuestionInputData.getSeller();
        Product product = viewReplyQuestionInputData.getProduct();
        Question question = viewReplyQuestionInputData.getQuestion();

        ViewReplyQuestionOutputData replyQuestionOutputData2 = new ViewReplyQuestionOutputData(seller, product, question);
        viewReplyPresenter.prepareSuccessView(replyQuestionOutputData2);
    }
}
