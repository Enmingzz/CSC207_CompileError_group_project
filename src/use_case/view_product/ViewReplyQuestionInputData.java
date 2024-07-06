package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

public class ViewReplyQuestionInputData {
    private final Product product;
    private final User seller;
    private final Question question;


    public ViewReplyQuestionInputData(Product product, User user, Question question){
        this.product = product;
        this.seller = user;
        this.question = question;
    }

    public Product getProduct() {
        return product;
    }

    public Question getQuestion() {
        return question;
    }

    public User getSeller() {
        return seller;
    }
}
