package use_case.view_product;

import data_access.interfaces.Question.QuestionCreateDataAccessInterface;
import entity.product.Product;
import entity.comment.QuestionFactory;
import entity.comment.Question;

import java.sql.SQLException;

public class PublishQuestionInteractor implements PublishQuestionInputBoundary{
    Product product;
    QuestionCreateDataAccessInterface questionCreateDataAccessObject;
    QuestionFactory questionFactory;
    PublishQuestionOutputBoundary publishPresenter;

    public PublishQuestionInteractor(Product product,
                                     QuestionCreateDataAccessInterface questionSaveDataAccessInterface,
                                     QuestionFactory questionFactory,
                                     PublishQuestionOutputBoundary publishQuestionOutputBoundary){
        this.product = product;
        this.questionCreateDataAccessObject = questionSaveDataAccessInterface;
        this.questionFactory = questionFactory;
        this.publishPresenter = publishQuestionOutputBoundary;
    }
    @Override
    public void execute(PublishQuestionInputData publishQuestionInputData) throws SQLException {
        Question publishQuestion = publishQuestionInputData.getQuestion();
        Product questionProduct = publishQuestionInputData.getProduct();

        Question question = questionFactory.createQuestion(publishQuestion.getDescription(), publishQuestion.getStudentNumber(),
                publishQuestion.getAnswer());

        questionCreateDataAccessObject.saveQuestion(question, questionProduct);

        PublishQuestionOutputData publishQuestionOutputData =  new PublishQuestionOutputData("question successfully published");
        publishPresenter.prepareSuccessView(publishQuestionOutputData);
    }
}
