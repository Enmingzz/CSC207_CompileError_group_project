package interface_adapter.view_product;

import entity.comment.*;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;

public class ReplyQuestionState {
    private QuestionFactory questionFactory = new CommonQuestionFactory();
    private AnswerFactory answerFactory = new CommonAnswerFactory();
//    private ProductFactory productFactory = new CommonProductFactory();

    private Question question = questionFactory.createQuestion("", "", answerFactory.createAnswer("", ""),"" );
    private Product product = null;
    private User user = null;

    public ReplyQuestionState(Question question, Product product, User user) {
        this.question = question;
        this.product = product;
        this.user = user;
    }

    public ReplyQuestionState(){};

    public Question getQuestion() {return question;}

    public Product getProduct() {return product;}

    public User getUser() {return user;}


    public void setQuestion(Question question){
        this.question = question;
    }

    public void setProduct(Product product){this.product = product;}

    public void setUser(User user){this.user = user;}

}
