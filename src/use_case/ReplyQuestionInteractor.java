package use_case;

import data_access.interfaces.QuestionUpdateDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.Question;
import entity.comment.Answer;
import entity.comment.QuestionFactory;
import entity.user.User;
import entity.product.Product;

import java.sql.SQLException;

public class ReplyQuestionInteractor implements ReplyQuestionInputBoundary{
    private final QuestionUpdateDataAccessInterface questionUpdateDataAccessObject;
//    private final QuestionReadDataAccessInterface questionReadDataAccessObject;
    private final ReplyQuestionOutputBoundary replyPresenter;
    private final AnswerFactory answerFactory;
    private final QuestionFactory questionFactory;

    public ReplyQuestionInteractor(QuestionUpdateDataAccessInterface questionUpdateDataAccessInterface,
                                   ReplyQuestionOutputBoundary replyQuestionOutputBoundary,
                                   AnswerFactory answerFactory,
                                   QuestionFactory questionFactory){
        this.questionUpdateDataAccessObject = questionUpdateDataAccessInterface;
        this.replyPresenter = replyQuestionOutputBoundary;
        this.answerFactory = answerFactory;
        this.questionFactory = questionFactory;
    }
    @Override
    public void execute(ReplyQuestionInputData replyQuestionInputData) throws SQLException {
        String answerDescription = replyQuestionInputData.getAnswerDescription();
        User seller = replyQuestionInputData.getSeller();
        Product product = replyQuestionInputData.getProduct();
        String questionContent = replyQuestionInputData.getQuestion().getDescription();

        Answer sellerAnswer = answerFactory.createAnswer(answerDescription, seller.getStudentNumber());

        Question completeQuestion = questionFactory.createQuestion(questionContent, product.getSellerStudentNumber(), sellerAnswer);
        questionUpdateDataAccessObject.updateQuestion(completeQuestion);

        ReplyQuestionOutputData replyQuestionOutputData = new ReplyQuestionOutputData("Question successfully answered");
        replyPresenter.prepareSuccessView(replyQuestionOutputData);
    }
}
