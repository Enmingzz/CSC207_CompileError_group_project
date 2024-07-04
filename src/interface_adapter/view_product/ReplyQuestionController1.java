package interface_adapter.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import use_case.view_product.ReplyQuestionInputBoundary1;
import use_case.view_product.ReplyQuestionInputBoundary2;
import use_case.view_product.ReplyQuestionInputData1;
import use_case.view_product.ReplyQuestionInputData2;

import java.sql.SQLException;

public class ReplyQuestionController1 {
    final ReplyQuestionInputBoundary1 replyQuestionInteractor;
    public ReplyQuestionController1(ReplyQuestionInputBoundary1 replyQuestionInputBoundary1){
        this.replyQuestionInteractor = replyQuestionInputBoundary1;
    }
    public void execute(Product product, User user, Question question) throws SQLException {
        ReplyQuestionInputData1 replyQuestionInputData1 = new ReplyQuestionInputData1(product, user, question);
        replyQuestionInteractor.execute(replyQuestionInputData1);
    }
}
