package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;

import java.util.ArrayList;

public class BuyerViewProductState {
    Product product;
    ArrayList<Question> lst_question;

    public BuyerViewProductState(Product product, ArrayList<Question> lst_question){
        this.product = product;
        this.lst_question = lst_question;
    }

    public Product getProduct(){
        return product;
    }

    public ArrayList<Question> getQuestion(){
        return lst_question;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public void setLst_question(ArrayList<Question> lst_question){
        this.lst_question = lst_question;
    }

    public BuyerViewProductState(){}
}
