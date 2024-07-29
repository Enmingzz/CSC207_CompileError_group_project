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
import java.util.ArrayList;

/**
 * The ReplyQuestionInteractor class implements the use case for replying to a question.
 * It interacts with the data access layer to update the question with the reply and uses the output boundary to present the result.
 */
public class ReplyQuestionInteractor implements ReplyQuestionInputBoundary {
    private final QuestionUpdateDataAccessInterface questionUpdateDataAccessObject;
    private final QuestionReadDataAccessInterface questionReadDataAccessObject;
    private final ReplyQuestionOutputBoundary replyPresenter;
    private final AnswerFactory answerFactory;
    private final QuestionFactory questionFactory;

    /**
     * Constructs a ReplyQuestionInteractor with the specified data access interfaces, output boundary, and factories.
     *
     * @param questionUpdateDataAccessInterface the data access interface for updating questions.
     * @param replyQuestionOutputBoundary the output boundary for presenting the result of the reply question use case.
     * @param questionReadDataAccessObject the data access interface for reading questions.
     * @param answerFactory the factory for creating answers.
     * @param questionFactory the factory for creating questions.
     */
    public ReplyQuestionInteractor(QuestionUpdateDataAccessInterface questionUpdateDataAccessInterface,
                                   ReplyQuestionOutputBoundary replyQuestionOutputBoundary,
                                   QuestionReadDataAccessInterface questionReadDataAccessObject,
                                   AnswerFactory answerFactory,
                                   QuestionFactory questionFactory) {
        this.questionUpdateDataAccessObject = questionUpdateDataAccessInterface;
        this.replyPresenter = replyQuestionOutputBoundary;
        this.questionReadDataAccessObject = questionReadDataAccessObject;
        this.answerFactory = answerFactory;
        this.questionFactory = questionFactory;
    }

    /**
     * Executes the use case of replying to a question.
     *
     * @param replyQuestionInputData the input data required to reply to a question.
     * @throws SQLException if there is an error while interacting with the database.
     */
    @Override
    public void execute(ReplyQuestionInputData replyQuestionInputData) throws SQLException {
        String answerDescription = replyQuestionInputData.getAnswerDescription();
        User seller = replyQuestionInputData.getSeller();
        Product product = replyQuestionInputData.getProduct();
        String questionContent = replyQuestionInputData.getQuestion().getDescription();

        Answer sellerAnswer = answerFactory.createAnswer(answerDescription, seller.getStudentNumber());

        String questionID = replyQuestionInputData.getQuestion().getQuestionID();

//        System.out.println("this is the question I'm replying to:::::::" + questionContent);
//        System.out.println("this is the answer content:::::::" + answerDescription);

        Question completeQuestion = questionFactory.createQuestion(
                questionContent,
                product.getSellerStudentNumber(),
                sellerAnswer,
                questionID
        );

//        System.out.println("this is the answer:::::::" + completeQuestion.getAnswer().getDescription());
//        System.out.println("this is the uuid:::::::" + completeQuestion.getQuestionID());

        questionUpdateDataAccessObject.updateQuestion(completeQuestion);

        ArrayList<Question> newLst = questionReadDataAccessObject.getQuestion(product.getProductID());

        ReplyQuestionOutputData replyQuestionOutputData = new ReplyQuestionOutputData(
                "question successfully answered",
                newLst
        );
        replyPresenter.prepareSuccessView(replyQuestionOutputData);
    }
}
