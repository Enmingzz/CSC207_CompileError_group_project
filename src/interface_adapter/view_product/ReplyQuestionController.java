package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import use_case.view_product.ReplyQuestionInputBoundary;
import use_case.view_product.ReplyQuestionInputData;

import java.sql.SQLException;

public class ReplyQuestionController {
    final ReplyQuestionInputBoundary replyQuestionInteractor;
    public ReplyQuestionController(ReplyQuestionInputBoundary replyQuestionInputBoundary){
        this.replyQuestionInteractor = replyQuestionInputBoundary;
    }
    public void execute(Product product, User user, Question question, String answerDescription) throws SQLException {
        ReplyQuestionInputData replyQuestionInputData = new ReplyQuestionInputData(product, user, question, answerDescription);
        replyQuestionInteractor.execute(replyQuestionInputData);
    }
}
