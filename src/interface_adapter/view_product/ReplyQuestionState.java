package interface_adapter.view_product;

import entity.comment.*;
import entity.product.Product;
import entity.user.User;

/**
 * The ReplyQuestionState class represents the state of the reply question view.
 * It includes the question being replied to, the product related to the question, and the user replying to the question.
 */
public class ReplyQuestionState {
    private final QuestionFactory questionFactory = new CommonQuestionFactory();
    private final AnswerFactory answerFactory = new CommonAnswerFactory();

    private Question question = questionFactory.createQuestion("", "", answerFactory.createAnswer("", ""), "");
    private Product product = null;
    private User user = null;

    /**
     * Constructs a ReplyQuestionState with the specified question, product, and user.
     *
     * @param question the question being replied to.
     * @param product the product related to the question.
     * @param user the user replying to the question.
     */
    public ReplyQuestionState(Question question, Product product, User user) {
        this.question = question;
        this.product = product;
        this.user = user;
    }

    /**
     * Default constructor for ReplyQuestionState.
     */
    public ReplyQuestionState() {}

    /**
     * Returns the question being replied to.
     *
     * @return the question.
     */
    public Question getQuestion() {
        return question;
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
     * Returns the user replying to the question.
     *
     * @return the user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the question being replied to.
     *
     * @param question the question.
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Sets the product related to the question.
     *
     * @param product the product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets the user replying to the question.
     *
     * @param user the user.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
