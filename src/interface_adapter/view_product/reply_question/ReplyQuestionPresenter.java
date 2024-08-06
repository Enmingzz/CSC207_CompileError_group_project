package interface_adapter.view_product.reply_question;

import interface_adapter.ViewManagerModel;
import interface_adapter.view_product.seller_view.SellerViewProductState;
import interface_adapter.view_product.seller_view.SellerViewProductViewModel;
import use_case.view_product.ReplyQuestionOutputBoundary;
import use_case.view_product.ReplyQuestionOutputData;

/**
 * The ReplyQuestionPresenter class implements the ReplyQuestionOutputBoundary
 * and handles the presentation logic for replying to a question.
 */
public class ReplyQuestionPresenter implements ReplyQuestionOutputBoundary {
    private final ReplyQuestionViewModel replyQuestionViewModel;
    private final SellerViewProductViewModel sellerViewProductViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ReplyQuestionPresenter with the specified view models and view manager model.
     *
     * @param replyQuestionViewModel the view model for the reply question.
     * @param sellerViewProductViewModel the view model for the seller view product.
     * @param viewManagerModel the view manager model to manage active views.
     */
    public ReplyQuestionPresenter(ReplyQuestionViewModel replyQuestionViewModel,
                                  SellerViewProductViewModel sellerViewProductViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.replyQuestionViewModel = replyQuestionViewModel;
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view for replying to a question.
     *
     * @param replyQuestionOutputData the output data containing the result of replying to a question.
     */
    @Override
    public void prepareSuccessView(ReplyQuestionOutputData replyQuestionOutputData) {
//        ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();

//        // Update the question in the reply question state
//        replyQuestionState.setQuestion(replyQuestionOutputData.getQuestions());

//        // Add the replied question to the list of questions in the seller view product state
//        ArrayList<Question> old_lst = sellerViewProductState.getQuestion();
//        old_lst.add(replyQuestionOutputData.getQuestion());

        // Update the seller view product state
        System.out.println("sellerViewProductState: first question description" + sellerViewProductState.getQuestion().get(0).getDescription());
        sellerViewProductState.setLst_question(replyQuestionOutputData.getQuestions());
        sellerViewProductState.setPromptStr("Successfully replied question");
        sellerViewProductState.setIsChanged(true);

        // Set the updated states
//        this.replyQuestionViewModel.setState(replyQuestionState);
        this.sellerViewProductViewModel.setState(sellerViewProductState);

        // Notify the views of the state changes
        sellerViewProductViewModel.firePropertyChanged();
        System.out.println("ReplyQuestionPresenter called");
        viewManagerModel.setActiveView(sellerViewProductViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
