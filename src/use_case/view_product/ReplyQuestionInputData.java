package use_case.view_product;

import entity.product.Product;
import entity.comment.Question;
import entity.user.User;

/**
 * This class encapsulates the input data required to reply to a question.
 * It contains a product, the seller who is replying, the question being replied to, and the answer description.
 */
public class ReplyQuestionInputData {
    private final Product product;
    private final User seller;
    private final Question question;
    private final String answerDescription;

    /**
     * Constructs a ReplyQuestionInputData object with the specified product, seller, question, and answer description.
     *
     * @param product the product related to the question.
     * @param user the seller who is replying to the question.
     * @param question the question being replied to.
     * @param answerDescription the description of the answer.
     */
    public ReplyQuestionInputData(Product product, User user, Question question, String answerDescription) {
        this.product = product;
        this.seller = user;
        this.question = question;
        this.answerDescription = answerDescription;
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

    /**
     * Returns the description of the answer.
     *
     * @return the answer description.
     */
    public String getAnswerDescription() {
        return answerDescription;
    }
}
