package interface_adapter.view_product;

import interface_adapter.ViewManagerModel;
import use_case.view_product.PublishQuestionOutputBoundary;
import use_case.view_product.PublishQuestionOutputData;

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
        buyerViewProductState.setPrompt_words(publishQuestionOutputData.getOutputStr());

        this.buyerViewProductViewModel.setState(buyerViewProductState);
        buyerViewProductViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(buyerViewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
