package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;

import java.util.ArrayList;


public class ViewProductOutputData {
    private final Product product;
    private final ArrayList<Question> list_of_question;

    public ViewProductOutputData(Product product, ArrayList<Question> list_of_question){
        this.product = product;
        this.list_of_question = list_of_question;

    }

    public Product getProduct(){
        return product;
    }

    public ArrayList<Question> getList_of_question() {
        return list_of_question;
    }
}
