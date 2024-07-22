package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * The BuyerViewProductState class represents the state of the buyer's view of a product.
 * It includes the product details, questions related to the product, prompt words, the user viewing the product, and a change flag.
 */
public class BuyerViewProductState {

    private Product product = null;
    private ArrayList<Question> lst_question = new ArrayList<>();
    private String prompt_words = "";
    private User user = null;
    private Boolean isChanged = false;

    /**
     * Constructs a BuyerViewProductState with the specified product, list of questions, prompt words, user, and change flag.
     *
     * @param product the product being viewed.
     * @param lst_question the list of questions related to the product.
     * @param prompt_words the prompt words to display to the user.
     * @param user the user viewing the product.
     * @param isChanged the flag indicating if the state has changed.
     */
    public BuyerViewProductState(Product product, ArrayList<Question> lst_question, String prompt_words, User user, Boolean isChanged) {
        this.product = product;
        this.lst_question = lst_question;
        this.prompt_words = prompt_words;
        this.user = user;
        this.isChanged = isChanged;
    }

    /**
     * Default constructor for BuyerViewProductState.
     */
    public BuyerViewProductState() {}

    // Getter methods

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
     * Returns the prompt words to display to the user.
     *
     * @return the prompt words.
     */
    public String getPrompt_words() {
        return prompt_words;
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
     * Returns the flag indicating if the state has changed.
     *
     * @return the change flag.
     */
    public Boolean getIsChanged() {
        return isChanged;
    }

    // Setter methods

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
     * Sets the prompt words to display to the user.
     *
     * @param prompt_words the prompt words.
     */
    public void setPrompt_words(String prompt_words) {
        this.prompt_words = prompt_words;
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
     * Sets the flag indicating if the state has changed.
     *
     * @param isChanged the change flag.
     */
    public void setIsChanged(Boolean isChanged) {
        this.isChanged = isChanged;
    }
}
