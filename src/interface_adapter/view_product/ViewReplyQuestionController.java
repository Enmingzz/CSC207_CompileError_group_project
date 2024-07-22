package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import use_case.view_product.ViewReplyQuestionInputBoundary;
import use_case.view_product.ViewReplyQuestionInputData;

import java.sql.SQLException;

/**
 * The ViewReplyQuestionController class handles the process of viewing a question for replying.
 * It uses the ViewReplyQuestionInputBoundary to interact with the use case.
 */
public class ViewReplyQuestionController {
    private final ViewReplyQuestionInputBoundary viewReplyQuestionInteractor;

    /**
     * Constructs a ViewReplyQuestionController with the specified input boundary.
     *
     * @param viewReplyQuestionInputBoundary the interactor for viewing a question for replying.
     */
    public ViewReplyQuestionController(ViewReplyQuestionInputBoundary viewReplyQuestionInputBoundary) {
        this.viewReplyQuestionInteractor = viewReplyQuestionInputBoundary;
    }

    /**
     * Executes the process of viewing a question for replying.
     *
     * @param product the product related to the question.
     * @param user the user viewing the question.
     * @param question the question being viewed for replying.
     * @throws SQLException if there is an error while interacting with the database.
     */
    public void execute(Product product, User user, Question question) throws SQLException {
        ViewReplyQuestionInputData viewReplyQuestionInputData = new ViewReplyQuestionInputData(product, user, question);
        viewReplyQuestionInteractor.execute(viewReplyQuestionInputData);
    }
}
