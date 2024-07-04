package use_case.view_product;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.Question;
import entity.comment.Answer;
import entity.comment.QuestionFactory;
import entity.user.User;
import entity.product.Product;

import java.sql.SQLException;

public class ReplyQuestionInteractor2 implements ReplyQuestionInputBoundary2 {
    private final QuestionUpdateDataAccessInterface questionUpdateDataAccessObject;
//    private final QuestionReadDataAccessInterface questionReadDataAccessObject;
    private final ReplyQuestionOutputBoundary2 replyPresenter;
    private final AnswerFactory answerFactory;
    private final QuestionFactory questionFactory;

    public ReplyQuestionInteractor2(QuestionUpdateDataAccessInterface questionUpdateDataAccessInterface,
                                    ReplyQuestionOutputBoundary2 replyQuestionOutputBoundary2,
                                    AnswerFactory answerFactory,
                                    QuestionFactory questionFactory){
        this.questionUpdateDataAccessObject = questionUpdateDataAccessInterface;
        this.replyPresenter = replyQuestionOutputBoundary2;
        this.answerFactory = answerFactory;
        this.questionFactory = questionFactory;
    }
    @Override
    public void execute(ReplyQuestionInputData2 replyQuestionInputData2) throws SQLException {
        String answerDescription = replyQuestionInputData2.getAnswerDescription();
        User seller = replyQuestionInputData2.getSeller();
        Product product = replyQuestionInputData2.getProduct();
        String questionContent = replyQuestionInputData2.getQuestion().getDescription();

        Answer sellerAnswer = answerFactory.createAnswer(answerDescription, seller.getStudentNumber());

        Question completeQuestion = questionFactory.createQuestion(questionContent, product.getSellerStudentNumber(), sellerAnswer);
        questionUpdateDataAccessObject.updateQuestion(completeQuestion);

        ReplyQuestionOutputData2 replyQuestionOutputData2 = new ReplyQuestionOutputData2("question successfully answered", replyQuestionInputData2.getQuestion());
        replyPresenter.prepareSuccessView(replyQuestionOutputData2);
    }
}
