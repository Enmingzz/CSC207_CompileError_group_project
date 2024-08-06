package interface_adapter.view_product.seller_view;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * The SellerViewProductState class represents the state of the seller's view of a product.
 * It includes the product details, list of questions related to the product, user information,
 * prompt message, and a flag indicating if the state has changed.
 */
public class SellerViewProductState {
    private Product product = null;
    private ArrayList<Question> lst_question = new ArrayList<>();
    private User user = null;
    private String promptStr = "";
    private Boolean isChanged = false;

    /**
     * Constructs a SellerViewProductState with the specified product, list of questions, user, prompt message, and change flag.
     *
     * @param product the product being viewed.
     * @param lst_question the list of questions related to the product.
     * @param user the user viewing the product.
     * @param promptStr the prompt message to display.
     * @param isChanged the flag indicating if the state has changed.
     */
    public SellerViewProductState(Product product, ArrayList<Question> lst_question, User user, String promptStr, Boolean isChanged) {
        this.product = product;
        this.lst_question = lst_question;
        this.user = user;
        this.promptStr = promptStr;
        this.isChanged = isChanged;
    }

    /**
     * Default constructor for SellerViewProductState.
     */
    public SellerViewProductState() {}

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
    public ArrayList<Question> getQuestion() {
        return lst_question;
    }

    /**
     * Returns the user viewing the product.
     *
     * @return the user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the prompt message to display.
     *
     * @return the prompt message.
     */
    public String getPromptStr() {
        return promptStr;
    }

    /**
     * Returns the flag indicating if the state has changed.
     *
     * @return the change flag.
     */
    public Boolean getIsChanged() {
        return isChanged;
    }

    /**
     * Sets the product being viewed.
     *
     * @param product the product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets the list of questions related to the product.
     *
     * @param lst_question the list of questions.
     */
    public void setLst_question(ArrayList<Question> lst_question) {
        this.lst_question = lst_question;
    }

    /**
     * Sets the user viewing the product.
     *
     * @param user the user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets the prompt message to display.
     *
     * @param promptStr the prompt message.
     */
    public void setPromptStr(String promptStr) {
        this.promptStr = promptStr;
    }

    /**
     * Sets the flag indicating if the state has changed.
     *
     * @param isChanged the change flag.
     */
    public void setIsChanged(Boolean isChanged) {
        this.isChanged = isChanged;
    }
}
