package use_case.view_product;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import entity.comment.Question;

import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

public class ReplyQuestionInteractor1 implements ReplyQuestionInputBoundary1{

    private final ReplyQuestionOutputBoundary1 replyPresenter;

    public ReplyQuestionInteractor1(ReplyQuestionOutputBoundary1 replyQuestionOutputBoundary1){
        this.replyPresenter = replyQuestionOutputBoundary1;
    }
    @Override
    public void execute(ReplyQuestionInputData1 replyQuestionInputData1) throws SQLException {

        User seller = replyQuestionInputData1.getSeller();
        Product product = replyQuestionInputData1.getProduct();
        Question question = replyQuestionInputData1.getQuestion();

        ReplyQuestionOutputData1 replyQuestionOutputData2 = new ReplyQuestionOutputData1(seller, product, question);
        replyPresenter.prepareSuccessView(replyQuestionOutputData2);
    }
}
