package interface_adapter.view_product;

import entity.comment.Question;
import interface_adapter.ViewManagerModel;
import use_case.view_product.ReplyQuestionOutputData2;

import java.util.ArrayList;


public class ReplyQuestionPresenter2 {
    private final ReplyQuestionViewModel replyQuestionViewModel;
    private final SellerViewProductViewModel sellerViewProductViewModel;
    ViewManagerModel viewManagerModel;

    public ReplyQuestionPresenter2(ReplyQuestionViewModel replyQuestionViewModel,
                                   SellerViewProductViewModel sellerViewProductViewModel,
                                   ViewManagerModel viewManagerModel){
        this.replyQuestionViewModel = replyQuestionViewModel;
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(ReplyQuestionOutputData2 replyQuestionOutputData2){
        ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();

        replyQuestionState.setQuestion(replyQuestionOutputData2.getQuestion());
        ArrayList<Question> old_lst = sellerViewProductState.getQuestion();
        old_lst.add(replyQuestionOutputData2.getQuestion());

        sellerViewProductState.setLst_question(old_lst);
        sellerViewProductState.setPromptStr("Successfully replied question");

        this.replyQuestionViewModel.setState(replyQuestionState);
        this.sellerViewProductViewModel.setState(sellerViewProductState);

        sellerViewProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(sellerViewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
