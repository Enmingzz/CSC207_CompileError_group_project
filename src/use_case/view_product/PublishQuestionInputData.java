package use_case.view_product;
import entity.product.Product;
import entity.comment.Question;
import entity.user.User;

public class PublishQuestionInputData {
    private final Question question;
    private final Product product;
    private final User user;

    public PublishQuestionInputData(Question question, Product product, User user) {
        this.question = question;
        this.product = product;
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public Product getProduct(){
        return product;
    }

    public User getUser() {return user; }
}
