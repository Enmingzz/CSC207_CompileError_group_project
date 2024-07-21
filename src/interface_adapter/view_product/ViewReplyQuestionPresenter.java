package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import use_case.view_product.ViewReplyQuestionOutputBoundary;
import use_case.view_product.ViewReplyQuestionOutputData;

public class ViewReplyQuestionPresenter implements ViewReplyQuestionOutputBoundary {
    private final ReplyQuestionViewModel replyQuestionViewModel;
    ViewManagerModel viewManagerModel;

    public ViewReplyQuestionPresenter(ReplyQuestionViewModel replyQuestionViewModel,
                                      ViewManagerModel viewManagerModel) {
        this.replyQuestionViewModel = replyQuestionViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    public void prepareSuccessView(ViewReplyQuestionOutputData viewReplyQuestionOutputData){
        ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
        replyQuestionState.setQuestion(viewReplyQuestionOutputData.getQuestion());
        System.out.println("this is the presenter viewreplyquesitonpresenter::::: is set question correct?"+ replyQuestionState.getQuestion().getDescription());
        replyQuestionState.setProduct(viewReplyQuestionOutputData.getProduct());
        replyQuestionState.setUser(viewReplyQuestionOutputData.getSeller());

        this.replyQuestionViewModel.setState(replyQuestionState);

        replyQuestionViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(replyQuestionViewModel.getViewName());
        System.out.println(replyQuestionViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
