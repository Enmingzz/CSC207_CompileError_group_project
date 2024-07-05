package use_case.view_product;

import entity.product.Product;
import entity.comment.Question;
import entity.user.User;

public class ReplyQuestionInputData {
    private final Product product;
    private final User seller;
    private final Question question;
    private final String answerDescription;

    public ReplyQuestionInputData(Product product, User user, Question question, String answerDescription){
        this.product = product;
        this.seller = user;
        this.question = question;
        this.answerDescription = answerDescription;
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

    public String  getAnswerDescription(){
        return answerDescription;
    }
}
