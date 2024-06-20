package use_case;

import data_access.QuestionCreateDataAccessInterface;//QuestionCreateDataAccessInterface;
import entity.CommonQuestion;
import entity.QuestionFactory;
import entity.Question;

import java.sql.SQLException;

public class PublishQuestionInteractor implements PublishQuestionInputBoundary{
    QuestionCreateDataAccessInterface questionCreateDataAccessInterface;
    QuestionFactory questionFactory;
    PublishQuestionOutputBoundary publishPresenter;

    public PublishQuestionInteractor(QuestionCreateDataAccessInterface questionSaveDataAccessInterface,
                                   QuestionFactory questionFactory,
                                   PublishQuestionOutputBoundary publishQuestionOutputBoundary){
        this.questionCreateDataAccessInterface = questionSaveDataAccessInterface;
        this.questionFactory = questionFactory;
        this.publishPresenter = publishQuestionOutputBoundary;
    }
    @Override
    public void execute(PublishQuestionInputData publishQuestionInputData) throws SQLException {
        CommonQuestion publishQuestion = publishQuestionInputData.getCommonQuestion();

    Question question = questionFactory.createQuestion(publishQuestion.getDescription(), publishQuestion.getPostedUser(),
                publishQuestion.getAnswer());
        questionCreateDataAccessInterface.saveQuestion(question);
    }
}
