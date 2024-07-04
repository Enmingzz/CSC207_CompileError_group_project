package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class SellerViewProductState {
    Product product = null;
    ArrayList<Question> lst_question = new ArrayList<>();
    User user = null;
    String promptStr = "";

    public SellerViewProductState(Product product, ArrayList<Question> lst_question, User user, String promptStr){
        this.product = product;
        this.lst_question = lst_question;
        this.user = user;
        this.promptStr = promptStr;
    }

    public Product getProduct(){
        return product;
    }

    public ArrayList<Question> getQuestion(){
        return lst_question;
    }

    public User getUser(){return user;}

    public String getPromptStr(){return promptStr;}



    public void setProduct(Product product){
        this.product = product;
    }

    public void setLst_question(ArrayList<Question> lst_question){
        this.lst_question = lst_question;
    }

    public void setUser(User user){this.user = user;}

    public void setPromptStr(String promptStr){this.promptStr = promptStr;}


    public SellerViewProductState(){}
}
