package use_case;
import entity.Product;
import entity.Question;

public class PublishQuestionInputData {
    private final Question question;
    private final Product product;//

    public PublishQuestionInputData(Question question, Product product) {
        this.question = question;
        this.product = product;
    }

    public Question getQuestion() {
        return question;
    }

    public Product getProduct(){
        return product;
    }
}
