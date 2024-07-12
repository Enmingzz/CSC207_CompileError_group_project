package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class UnloggedInState {
    Product product = null;
    ArrayList<Question> lst_question = new ArrayList<>();
    User user = null;
    Boolean isChanged = false;

    public UnloggedInState(Product product, ArrayList<Question> lst_question, User user, Boolean isChanged){
        this.product = product;
        this.lst_question = lst_question;
        this.user = user;
        this.isChanged = isChanged;
    }
    //getter methods
    public Product getProduct(){
        return product;
    }

    public ArrayList<Question> getQuestion(){
        return lst_question;
    }

    public User getUser() {
        return user;
    }

    public Boolean getIsChanged(){return isChanged;}

    //setter methods
    public void setProduct(Product product){
        this.product = product;
    }

    public void setLst_question(ArrayList<Question> lst_question){
        this.lst_question = lst_question;
    }

    public void setUser(User user){this.user = user;}

    public void setIsChanged(Boolean isChanged){this.isChanged = isChanged;}

    public UnloggedInState(){}

}
