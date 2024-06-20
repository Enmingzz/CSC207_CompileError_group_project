package use_case;

import data_access.QuestionCreateDataAccessInterface;//QuestionCreateDataAccessInterface;
import entity.CommonQuestion;
import entity.QuestionFactory;
import entity.Question;

public class PublishQuestionInteractor implements PublishQuestionInputBoundary{
    QuestionCreateDataAccessInterface questionSaveDataAccessObject;
    QuestionFactory questionFactory;
    PublishQuestionOutputBoundary publishPresenter;

    public PublishQuestionInteractor(QuestionCreateDataAccessInterface questionCreateDataAccessInterface,
                                   QuestionFactory questionFactory,
                                   PublishQuestionOutputBoundary publishQuestionOutputBoundary){
        this.questionSaveDataAccessObject = questionCreateDataAccessInterface;
        this.questionFactory = questionFactory;
        this.publishPresenter = publishQuestionOutputBoundary;
    }
    @Override
    public void execute(PublishQuestionInputData publishQuestionInputData){
        CommonQuestion publishQuestion = publishQuestionInputData.getCommonQuestion();

    Question question = questionFactory.createQuestion(publishQuestion.getDescription(), publishQuestion.getPostedUser(),
                publishQuestion.getAnswer());
        questionSaveDataAccessObject.saveQuestion(question);
    }
}
