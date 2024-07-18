package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.user.User;
import entity.user.UserFactory;

import java.util.ArrayList;

public class BuyerViewProductState {


    private Product product = null;
    private ArrayList<Question> lst_question = new ArrayList<>();
    private String prompt_words = "";
    private User user = null;
    private Boolean isChanged = false;


    public BuyerViewProductState(Product product, ArrayList<Question> lst_question, String prompt_words, User user, Boolean isChanged){
        this.product = product;
        this.lst_question = lst_question;
        this.prompt_words = prompt_words;
        this.user = user;
        this.isChanged = isChanged;
    }

    //getter methods
    public Product getProduct(){return product;}

    public ArrayList<Question> getQuestion(){return lst_question;}

    public String getPrompt_words(){return prompt_words;}

    public User getUser() {return user;}

    public Boolean getIsChanged(){return isChanged;}

    //setter methods
    public void setProduct(Product product){this.product = product;}

    public void setLst_question(ArrayList<Question> lst_question){this.lst_question = lst_question;}

    public void setPrompt_words(String prompt_words){this.prompt_words = prompt_words;}

    public void setUser(User user){this.user = user;}

    public void setIsChanged(Boolean isChanged){this.isChanged = isChanged;}

    public BuyerViewProductState(){}
}
