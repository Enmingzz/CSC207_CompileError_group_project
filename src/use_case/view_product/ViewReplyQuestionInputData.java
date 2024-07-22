package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

/**
 * This class encapsulates the input data required to view the reply to a question.
 * It contains a product, the seller who is replying, and the question being replied to.
 */
public class ViewReplyQuestionInputData {
    private final Product product;
    private final User seller;
    private final Question question;

    /**
     * Constructs a ViewReplyQuestionInputData object with the specified product, seller, and question.
     *
     * @param product the product related to the question.
     * @param user the seller who is replying to the question.
     * @param question the question being replied to.
     */
    public ViewReplyQuestionInputData(Product product, User user, Question question) {
        this.product = product;
        this.seller = user;
        this.question = question;
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

    /**
     * Returns the seller who is replying to the question.
     *
     * @return the seller.
     */
    public User getSeller() {
        return seller;
    }
}
