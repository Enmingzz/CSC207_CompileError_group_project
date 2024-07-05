package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import use_case.view_product.ViewReplyQuestionInputBoundary;
import use_case.view_product.ViewReplyQuestionInputData;

import java.sql.SQLException;

public class ViewReplyQuestionController {
    final ViewReplyQuestionInputBoundary replyQuestionInteractor;
    public ViewReplyQuestionController(ViewReplyQuestionInputBoundary viewReplyQuestionInputBoundary){
        this.replyQuestionInteractor = viewReplyQuestionInputBoundary;
    }
    public void execute(Product product, User user, Question question) throws SQLException {
        ViewReplyQuestionInputData viewReplyQuestionInputData = new ViewReplyQuestionInputData(product, user, question);
        replyQuestionInteractor.execute(viewReplyQuestionInputData);
    }
}
