package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;


public class ViewProductOutputData {
    private final Product product;
    private final ArrayList<Question> list_of_question;
    private final String user_type;
    private final User user;

    public ViewProductOutputData(Product product, ArrayList<Question> list_of_question, String user_type, User user){
        this.product = product;
        this.list_of_question = list_of_question;
        this.user_type = user_type;
        this.user = user;
    }

    public Product getProduct(){
        return product;
    }

    public ArrayList<Question> getList_of_question() {
        return list_of_question;
    }

    public String getUser_type() {return user_type;}

    public User getUser() {return user;}
}
