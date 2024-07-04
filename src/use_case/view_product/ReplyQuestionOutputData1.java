package use_case.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;

public class ReplyQuestionOutputData1 {
    private User seller;
    private Product product;
    private Question question;

    public ReplyQuestionOutputData1(User seller, Product product, Question question) {
        this.seller = seller;
        this.product = product;
        this.question = question;
    }
    public User getSeller() {return seller;}
    public Product getProduct() {return product;}
    public Question getQuestion() {return question;}
}
