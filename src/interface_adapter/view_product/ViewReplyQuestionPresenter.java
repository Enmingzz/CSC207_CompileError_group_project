package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import use_case.view_product.ViewReplyQuestionOutputBoundary;
import use_case.view_product.ViewReplyQuestionOutputData;

/**
 * The ViewReplyQuestionPresenter class implements the ViewReplyQuestionOutputBoundary
 * and handles the presentation logic for viewing a question for replying.
 */
public class ViewReplyQuestionPresenter implements ViewReplyQuestionOutputBoundary {
    private final ReplyQuestionViewModel replyQuestionViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewReplyQuestionPresenter with the specified view models and view manager model.
     *
     * @param replyQuestionViewModel the view model for the reply question.
     * @param viewManagerModel the view manager model to manage active views.
     */
    public ViewReplyQuestionPresenter(ReplyQuestionViewModel replyQuestionViewModel,
                                      ViewManagerModel viewManagerModel) {
        this.replyQuestionViewModel = replyQuestionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view for viewing a question for replying.
     *
     * @param viewReplyQuestionOutputData the output data containing the question, product, and seller details.
     */
    @Override
    public void prepareSuccessView(ViewReplyQuestionOutputData viewReplyQuestionOutputData) {
        ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
        replyQuestionState.setQuestion(viewReplyQuestionOutputData.getQuestion());
        System.out.println("This is the presenter viewreplyquestionpresenter: Is set question correct? " + replyQuestionState.getQuestion().getDescription());
        replyQuestionState.setProduct(viewReplyQuestionOutputData.getProduct());
        replyQuestionState.setUser(viewReplyQuestionOutputData.getSeller());

        replyQuestionViewModel.setState(replyQuestionState);

        replyQuestionViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(replyQuestionViewModel.getViewName());
        System.out.println(replyQuestionViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
