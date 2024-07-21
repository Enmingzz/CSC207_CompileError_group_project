package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;

import entity.user.User;
import use_case.view_product.PublishQuestionInputBoundary;
import use_case.view_product.PublishQuestionInputData;




import java.sql.SQLException;

public class PublishQuestionController {
    final PublishQuestionInputBoundary publishQuestionInteractor;

    public PublishQuestionController(PublishQuestionInputBoundary publishQuestionInputBoundary){
        this.publishQuestionInteractor = publishQuestionInputBoundary;
    }

    public void execute(Question question, Product product, User user) throws SQLException {
        PublishQuestionInputData publishQuestionInputData = new PublishQuestionInputData(question, product, user);
        publishQuestionInteractor.execute(publishQuestionInputData);
    }

}
