package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

/**
 * This class encapsulates the output data for the use case of viewing the reply to a question.
 * It contains a seller, a product, and a question.
 */
public class ViewReplyQuestionOutputData {
    private final User seller;
    private final Product product;
    private final Question question;

    /**
     * Constructs a ViewReplyQuestionOutputData object with the specified seller, product, and question.
     *
     * @param seller the seller who replied to the question.
     * @param product the product related to the question.
     * @param question the question being replied to.
     */
    public ViewReplyQuestionOutputData(User seller, Product product, Question question) {
        this.seller = seller;
        this.product = product;
        this.question = question;
    }

    /**
     * Returns the seller who replied to the question.
     *
     * @return the seller.
     */
    public User getSeller() {
        return seller;
    }

    /**
     * Returns the product related to the question.
     *
     * @return the product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the question being replied to.
     *
     * @return the question.
     */
    public Question getQuestion() {
        return question;
    }
}
