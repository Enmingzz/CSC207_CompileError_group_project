package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * This class encapsulates the output data for the use case of viewing a product.
 * It contains a product, a list of questions related to the product, the type of user viewing the product, and the user.
 */
public class ViewProductOutputData {
    private final Product product;
    private final ArrayList<Question> list_of_question;
    private final String user_type;
    private final User user;

    /**
     * Constructs a ViewProductOutputData object with the specified product, list of questions, user type, and user.
     *
     * @param product the product being viewed.
     * @param list_of_question the list of questions related to the product.
     * @param user_type the type of user viewing the product.
     * @param user the user who is viewing the product.
     */
    public ViewProductOutputData(Product product, ArrayList<Question> list_of_question, String user_type, User user) {
        this.product = product;
        this.list_of_question = list_of_question;
        this.user_type = user_type;
        this.user = user;
    }

    /**
     * Returns the product being viewed.
     *
     * @return the product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the list of questions related to the product.
     *
     * @return the list of questions.
     */
    public ArrayList<Question> getList_of_question() {
        return list_of_question;
    }

    /**
     * Returns the type of user viewing the product.
     *
     * @return the user type.
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * Returns the user who is viewing the product.
     *
     * @return the user.
     */
    public User getUser() {
        return user;
    }
}
