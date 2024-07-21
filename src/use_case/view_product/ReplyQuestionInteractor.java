package use_case.view_product;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import entity.comment.AnswerFactory;
import entity.comment.Question;
import entity.comment.Answer;
import entity.comment.QuestionFactory;
import entity.user.User;
import entity.product.Product;

import java.sql.SQLException;

public class ReplyQuestionInteractor implements ReplyQuestionInputBoundary {
    private final QuestionUpdateDataAccessInterface questionUpdateDataAccessObject;
    private final QuestionReadDataAccessInterface questionReadDataAccessObject;
    private final ReplyQuestionOutputBoundary replyPresenter;
    private final AnswerFactory answerFactory;
    private final QuestionFactory questionFactory;

    public ReplyQuestionInteractor(QuestionUpdateDataAccessInterface questionUpdateDataAccessInterface,
                                   ReplyQuestionOutputBoundary replyQuestionOutputBoundary,
                                   QuestionReadDataAccessInterface questionReadDataAccessObject,
                                   AnswerFactory answerFactory,
                                   QuestionFactory questionFactory){
        this.questionUpdateDataAccessObject = questionUpdateDataAccessInterface;
        this.replyPresenter = replyQuestionOutputBoundary;
        this.questionReadDataAccessObject = questionReadDataAccessObject;
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

        String questionID = replyQuestionInputData.getQuestion().getQuestionID();

        System.out.println("this is the question i'm replying:::::::" + questionContent);
        System.out.println("this is the answer content:::::::" + answerDescription);

        Question completeQuestion = questionFactory.createQuestion(questionContent, product.getSellerStudentNumber(), sellerAnswer, questionID);

        System.out.println("this is the answer" + completeQuestion.getAnswer().getDescription());
        System.out.println("this is the uuid" + completeQuestion.getQuestionID());

        questionUpdateDataAccessObject.updateQuestion(completeQuestion);//TODO: this DAO might have issue

        ReplyQuestionOutputData replyQuestionOutputData = new ReplyQuestionOutputData("question successfully answered", replyQuestionInputData.getQuestion());
        replyPresenter.prepareSuccessView(replyQuestionOutputData);
    }
}
