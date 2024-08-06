package interface_adapter.view_product.publish_question;

import entity.comment.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.buyer_view.BuyerViewProductState;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import use_case.view_product.PublishQuestionOutputBoundary;
import use_case.view_product.PublishQuestionOutputData;

/**
 * The PublishQuestionPresenter class implements the PublishQuestionOutputBoundary
 * and handles the presentation logic for publishing a question.
 */
public class PublishQuestionPresenter implements PublishQuestionOutputBoundary {
    private final BuyerViewProductViewModel buyerViewProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a PublishQuestionPresenter with the specified view models.
     *
     * @param buyerViewProductViewModel the view model for the buyer view product.
     * @param viewManagerModel the view manager model to manage active views.
     */
    public PublishQuestionPresenter(BuyerViewProductViewModel buyerViewProductViewModel,
                                    ViewManagerModel viewManagerModel) {
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view for publishing a question.
     *
     * @param publishQuestionOutputData the output data containing the result of publishing a question.
     */
    @Override
    public void prepareSuccessView(PublishQuestionOutputData publishQuestionOutputData) {
        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();

        System.out.println("publish question prepare successful view");
        for (Question que : buyerViewProductState.getQuestion()) {
            System.out.println(que.getDescription());
        }

        String new_ques_str = publishQuestionOutputData.getNewQuestion();
        QuestionFactory questionFactory = new CommonQuestionFactory();
        String student_num = publishQuestionOutputData.getQuestionUser().getStudentNumber();
        String questionId = publishQuestionOutputData.getQuestion().getQuestionID();

        AnswerFactory answerFactory = new CommonAnswerFactory();
        Answer ans = answerFactory.createAnswer("", "");

        Question question = questionFactory.createQuestion(new_ques_str, student_num, ans, questionId);
        System.out.println("QuestionId in publish question presenter: " + questionId);

        buyerViewProductState.getQuestion().add(question);
        buyerViewProductState.setPrompt_words(publishQuestionOutputData.getOutputStr());
        buyerViewProductState.setIsChanged(true);

        for (Question que : buyerViewProductState.getQuestion()) {
            System.out.println(que.getDescription());
        }

        this.buyerViewProductViewModel.setState(buyerViewProductState);
        buyerViewProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(buyerViewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
