package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import use_case.view_product.ReplyQuestionInputBoundary1;
import use_case.view_product.ReplyQuestionInputBoundary2;
import use_case.view_product.ReplyQuestionInputData1;
import use_case.view_product.ReplyQuestionInputData2;

import java.sql.SQLException;

public class ReplyQuestionController2 {
    final ReplyQuestionInputBoundary2 replyQuestionInteractor;
    public ReplyQuestionController2(ReplyQuestionInputBoundary2 replyQuestionInputBoundary2){
        this.replyQuestionInteractor = replyQuestionInputBoundary2;
    }
    public void execute(Product product, User user, Question question, String answerDescription) throws SQLException {
        ReplyQuestionInputData2 replyQuestionInputData2 = new ReplyQuestionInputData2(product, user, question, answerDescription);
        replyQuestionInteractor.execute(replyQuestionInputData2);
    }
}
