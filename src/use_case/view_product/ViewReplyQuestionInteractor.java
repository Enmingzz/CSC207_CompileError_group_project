package use_case.view_product;

import entity.comment.Question;

import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

public class ViewReplyQuestionInteractor implements ViewReplyQuestionInputBoundary {

    private final ViewReplyQuestionOutputBoundary viewReplyPresenter;

    public ViewReplyQuestionInteractor(ViewReplyQuestionOutputBoundary viewReplyQuestionOutputBoundary){
        this.viewReplyPresenter = viewReplyQuestionOutputBoundary;
    }
    @Override
    public void execute(ViewReplyQuestionInputData viewReplyQuestionInputData) throws SQLException {

        User seller = viewReplyQuestionInputData.getSeller();
        Product product = viewReplyQuestionInputData.getProduct();
        Question question = viewReplyQuestionInputData.getQuestion();

        ViewReplyQuestionOutputData replyQuestionOutputData2 = new ViewReplyQuestionOutputData(seller, product, question);
        viewReplyPresenter.prepareSuccessView(replyQuestionOutputData2);
    }
}
