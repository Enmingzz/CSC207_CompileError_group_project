package use_case;

import data_access.QuestionCreateDataAccessInterface;
import entity.Product;
import entity.QuestionFactory;
import entity.Question;

import java.sql.SQLException;

public class PublishQuestionInteractor implements PublishQuestionInputBoundary{
    Product product;
    QuestionCreateDataAccessInterface questionCreateDataAccessInterface;
    QuestionFactory questionFactory;
    PublishQuestionOutputBoundary publishPresenter;

    public PublishQuestionInteractor(Product product,
                                     QuestionCreateDataAccessInterface questionSaveDataAccessInterface,
                                     QuestionFactory questionFactory,
                                     PublishQuestionOutputBoundary publishQuestionOutputBoundary){
        this.product = product;
        this.questionCreateDataAccessInterface = questionSaveDataAccessInterface;
        this.questionFactory = questionFactory;
        this.publishPresenter = publishQuestionOutputBoundary;
    }
    @Override
    public void execute(PublishQuestionInputData publishQuestionInputData) throws SQLException {
        Question publishQuestion = publishQuestionInputData.getQuestion();
        Product questionProduct = publishQuestionInputData.getProduct();

        Question question = questionFactory.createQuestion(publishQuestion.getDescription(), publishQuestion.getStudentNumber(),
                publishQuestion.getAnswer());
        questionCreateDataAccessInterface.saveQuestion(question, questionProduct.getProductID());

        PublishQuestionOutputData publishQuestionOutputData =  new PublishQuestionOutputData("question successfully published");
        publishPresenter.prepareSuccessView(publishQuestionOutputData);
    }
}
