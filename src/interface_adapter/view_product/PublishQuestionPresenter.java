package interface_adapter.view_product;

import entity.comment.*;
import interface_adapter.ViewManagerModel;
import use_case.view_product.PublishQuestionOutputBoundary;
import use_case.view_product.PublishQuestionOutputData;

import java.time.LocalDateTime;

public class PublishQuestionPresenter implements PublishQuestionOutputBoundary {
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private ViewManagerModel viewManagerModel;

    public PublishQuestionPresenter(BuyerViewProductViewModel buyerViewProductViewModel,
                                    ViewManagerModel viewManagerModel) {
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(PublishQuestionOutputData publishQuestionOutputData) {
        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();

        System.out.println("publish question prepare successful view ");
        for(Question que:buyerViewProductState.getQuestion()){
            System.out.println(que.getDescription());
        }
        String new_ques_str = publishQuestionOutputData.getNewQuestion();
        QuestionFactory questionFactory = new CommonQuestionFactory();
        String student_num = publishQuestionOutputData.getQuestionUser().getStudentNumber();
        String questionId = publishQuestionOutputData.getQuestion().getQuestionID();

        AnswerFactory answerFactory = new CommonAnswerFactory();
        Answer ans = answerFactory.createAnswer("", "");

        Question question = questionFactory.createQuestion(new_ques_str, student_num, ans, questionId);
        System.out.println("QuestionId in publishquestion presenter" + questionId);

        buyerViewProductState.getQuestion().add(question);

//        buyerViewProductState.setLst_question(publishQuestionOutputData.getNewQuestions());
        buyerViewProductState.setPrompt_words(publishQuestionOutputData.getOutputStr());
        buyerViewProductState.setIsChanged(true);

        for (Question que: buyerViewProductState.getQuestion()){
            System.out.println(que.getDescription());
        }

        this.buyerViewProductViewModel.setState(buyerViewProductState);
        buyerViewProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(buyerViewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
