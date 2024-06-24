package interface_adapter.view_product;

import entity.comment.Question;
import interface_adapter.ViewManagerModel;
import use_case.view_product.ReplyQuestionOutputData;

import java.util.ArrayList;


public class ReplyQuestionPresenter {
    private final ReplyQuestionViewModel replyQuestionViewModel;
    private final SellerViewProductViewModel sellerViewProductViewModel;
    ViewManagerModel viewManagerModel;

    public ReplyQuestionPresenter(ReplyQuestionViewModel replyQuestionViewModel,
                                   SellerViewProductViewModel sellerViewProductViewModel,
                                   ViewManagerModel viewManagerModel){
        this.replyQuestionViewModel = replyQuestionViewModel;
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(ReplyQuestionOutputData replyQuestionOutputData){
        ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();

        replyQuestionState.setQuestion(replyQuestionOutputData.getQuestion());
        ArrayList<Question> old_lst = sellerViewProductState.getQuestion();
        old_lst.add(replyQuestionOutputData.getQuestion());

        sellerViewProductState.setLst_question(old_lst);

        this.replyQuestionViewModel.setState(replyQuestionState);
        this.sellerViewProductViewModel.setState(sellerViewProductState);

        sellerViewProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(sellerViewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
