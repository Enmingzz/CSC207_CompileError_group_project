package use_case.view_product;

import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import entity.product.Product;
import entity.comment.QuestionFactory;
import entity.comment.Question;

import java.sql.SQLException;

/**
 * The PublishQuestionInteractor class implements the use case for publishing a question.
 * It interacts with the data access layer to save the question and uses the output boundary to present the result.
 */
public class PublishQuestionInteractor implements PublishQuestionInputBoundary {
    private final QuestionCreateDataAccessInterface questionCreateDataAccessObject;
    private final QuestionFactory questionFactory;
    private final PublishQuestionOutputBoundary publishPresenter;

    /**
     * Constructs a PublishQuestionInteractor with the specified data access interface, question factory, and output boundary.
     *
     * @param questionCreateDataAccessInterface the data access interface for saving questions.
     * @param questionFactory the factory for creating questions.
     * @param publishQuestionOutputBoundary the output boundary for presenting the result of the publish question use case.
     */
    public PublishQuestionInteractor(QuestionCreateDataAccessInterface questionCreateDataAccessInterface,
                                     QuestionFactory questionFactory,
                                     PublishQuestionOutputBoundary publishQuestionOutputBoundary) {
        this.questionCreateDataAccessObject = questionCreateDataAccessInterface;
        this.questionFactory = questionFactory;
        this.publishPresenter = publishQuestionOutputBoundary;
    }

    /**
     * Executes the use case of publishing a question.
     *
     * @param publishQuestionInputData the input data required to publish a question.
     * @throws SQLException if there is an error while interacting with the database.
     */
    @Override
    public void execute(PublishQuestionInputData publishQuestionInputData) throws SQLException {
        Question publishQuestion = publishQuestionInputData.getQuestion();
        Product questionProduct = publishQuestionInputData.getProduct();

        Question question = questionFactory.createQuestion(
                publishQuestion.getDescription(),
                publishQuestion.getStudentNumber(),
                publishQuestion.getAnswer(),
                publishQuestion.getQuestionID()
        );

        questionCreateDataAccessObject.saveQuestion(question, questionProduct);

        PublishQuestionOutputData publishQuestionOutputData = new PublishQuestionOutputData(
                "Question successfully published",
                publishQuestionInputData.getQuestion().getDescription(),
                publishQuestionInputData.getUser(),
                publishQuestion
        );
        publishPresenter.prepareSuccessView(publishQuestionOutputData);
    }
}
