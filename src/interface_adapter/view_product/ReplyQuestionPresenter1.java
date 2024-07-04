package interface_adapter.view_product;

import entity.comment.Question;
import interface_adapter.ViewManagerModel;
import use_case.view_product.ReplyQuestionOutputData1;
import use_case.view_product.ReplyQuestionOutputData2;

import java.util.ArrayList;

public class ReplyQuestionPresenter1 {
    private final ReplyQuestionViewModel replyQuestionViewModel;
    ViewManagerModel viewManagerModel;

    public ReplyQuestionPresenter1(ReplyQuestionViewModel replyQuestionViewModel,
                                   ViewManagerModel viewManagerModel) {
        this.replyQuestionViewModel = replyQuestionViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    public void prepareSuccessView(ReplyQuestionOutputData1 replyQuestionOutputData1){
        ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
        replyQuestionState.setQuestion(replyQuestionState.getQuestion());
        replyQuestionState.setProduct(replyQuestionOutputData1.getProduct());
        replyQuestionState.setUser(replyQuestionOutputData1.getSeller());

        this.replyQuestionViewModel.setState(replyQuestionState);

        replyQuestionViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(replyQuestionViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
