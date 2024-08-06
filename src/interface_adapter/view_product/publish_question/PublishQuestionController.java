package interface_adapter.view_product.publish_question;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import use_case.view_product.PublishQuestionInputBoundary;
import use_case.view_product.PublishQuestionInputData;

import java.sql.SQLException;

/**
 * The PublishQuestionController class handles the process of publishing a question.
 * It uses the PublishQuestionInputBoundary to interact with the use case.
 */
public class PublishQuestionController {
    private final PublishQuestionInputBoundary publishQuestionInteractor;

    /**
     * Constructs a PublishQuestionController with the specified input boundary.
     *
     * @param publishQuestionInputBoundary the interactor for publishing a question.
     */
    public PublishQuestionController(PublishQuestionInputBoundary publishQuestionInputBoundary) {
        this.publishQuestionInteractor = publishQuestionInputBoundary;
    }

    /**
     * Executes the process of publishing a question.
     *
     * @param question the question to be published.
     * @param product the product related to the question.
     * @param user the user who is publishing the question.
     * @throws SQLException if there is an error while interacting with the database.
     */
    public void execute(Question question, Product product, User user) throws SQLException {
        PublishQuestionInputData publishQuestionInputData = new PublishQuestionInputData(question, product, user);
        publishQuestionInteractor.execute(publishQuestionInputData);
    }
}
