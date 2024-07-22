package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import use_case.view_product.ReplyQuestionInputBoundary;
import use_case.view_product.ReplyQuestionInputData;

import java.sql.SQLException;

/**
 * The ReplyQuestionController class handles the process of replying to a question.
 * It uses the ReplyQuestionInputBoundary to interact with the use case.
 */
public class ReplyQuestionController {
    private final ReplyQuestionInputBoundary replyQuestionInteractor;

    /**
     * Constructs a ReplyQuestionController with the specified input boundary.
     *
     * @param replyQuestionInputBoundary the interactor for replying to a question.
     */
    public ReplyQuestionController(ReplyQuestionInputBoundary replyQuestionInputBoundary) {
        this.replyQuestionInteractor = replyQuestionInputBoundary;
    }

    /**
     * Executes the process of replying to a question.
     *
     * @param product the product related to the question.
     * @param user the user who is replying to the question.
     * @param question the question being replied to.
     * @param answerDescription the description of the answer.
     * @throws SQLException if there is an error while interacting with the database.
     */
    public void execute(Product product, User user, Question question, String answerDescription) throws SQLException {
        ReplyQuestionInputData replyQuestionInputData = new ReplyQuestionInputData(product, user, question, answerDescription);
        replyQuestionInteractor.execute(replyQuestionInputData);
    }
}
