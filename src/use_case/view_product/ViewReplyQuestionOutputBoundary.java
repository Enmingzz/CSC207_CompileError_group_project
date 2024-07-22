package use_case.view_product;

/**
 * This interface defines the output boundary for the use case of viewing the reply to a question.
 * It acts as a contract for any class that wants to implement the presentation of the result of viewing a reply to a question.
 */
public interface ViewReplyQuestionOutputBoundary {

    /**
     * Prepares the success view for the view reply question use case.
     *
     * @param viewReplyQuestionOutputData the output data containing the result of the view reply question use case.
     */
    void prepareSuccessView(ViewReplyQuestionOutputData viewReplyQuestionOutputData);
}
