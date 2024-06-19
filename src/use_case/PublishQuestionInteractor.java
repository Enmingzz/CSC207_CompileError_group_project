package use_case;

import data_access.QuestionSaveDataAccessInterface;//QuestionCreateDataAccessInterface;
import entity.CommonQuestion;
import entity.QuestionFactory;
import entity.Question;

public class PublishQuestionInteractor implements PublishQuestionInputBoundary{
    QuestionSaveDataAccessInterface questionSaveDataAccessObject;
    QuestionFactory questionFactory;
    PublishQuestionOutputBoundary publishPresenter;

    public PublishQuestionInteractor(QuestionSaveDataAccessInterface questionSaveDataAccessInterface,
                                   QuestionFactory questionFactory,
                                   PublishQuestionOutputBoundary publishQuestionOutputBoundary){
        this.questionSaveDataAccessObject = questionSaveDataAccessInterface;
        this.questionFactory = questionFactory;
        this.publishPresenter = publishQuestionOutputBoundary;
    }
    @Override
    public void execute(PublishQuestionInputData publishQuestionInputData){
        CommonQuestion publishQuestion = publishQuestionInputData.getCommonQuestion();

    Question question = questionFactory.createQuestion(publishQuestion.getDescription(), publishQuestion.getPostedUser().,
                publishQuestion.getAnswer());
        questionSaveDataAccessObject.saveQuestion(question);
    }
}
