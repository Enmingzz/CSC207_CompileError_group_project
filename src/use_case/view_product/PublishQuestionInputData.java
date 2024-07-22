package use_case.view_product;

import entity.product.Product;
import entity.comment.Question;
import entity.user.User;

/**
 * This class encapsulates the input data required to publish a question.
 * It contains a question, the product related to the question, and the user who is publishing the question.
 */
public class PublishQuestionInputData {
    private final Question question;
    private final Product product;
    private final User user;

    /**
     * Constructs a PublishQuestionInputData object with the specified question, product, and user.
     *
     * @param question the question to be published
     * @param product the product related to the question
     * @param user the user who is publishing the question
     */
    public PublishQuestionInputData(Question question, Product product, User user) {
        this.question = question;
        this.product = product;
        this.user = user;
    }

    /**
     * Returns the question to be published.
     *
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Returns the product related to the question.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the user who is publishing the question.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
