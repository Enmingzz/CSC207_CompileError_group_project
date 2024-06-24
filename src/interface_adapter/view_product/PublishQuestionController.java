package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import use_case.view_product.PublishQuestionInputBoundary;
import use_case.view_product.PublishQuestionInputData;

import java.sql.SQLException;

public class PublishQuestionController {
    final PublishQuestionInputBoundary publishQuestionInteractor;

    public PublishQuestionController(PublishQuestionInputBoundary publishQuestionInputBoundary){
        this.publishQuestionInteractor = publishQuestionInputBoundary;
    }

    public void execute(Question question, Product product) throws SQLException {
        PublishQuestionInputData publishQuestionInputData = new PublishQuestionInputData(question, product);
        publishQuestionInteractor.execute(publishQuestionInputData);
    }

}
