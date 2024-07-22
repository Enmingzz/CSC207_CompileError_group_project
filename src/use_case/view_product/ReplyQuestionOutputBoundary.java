package use_case.view_product;

/**
 * This interface defines the output boundary for the use case of replying to a question.
 * It acts as a contract for any class that wants to implement the presentation of the result of replying to a question.
 */
public interface ReplyQuestionOutputBoundary {

    /**
     * Prepares the success view for the reply question use case.
     *
     * @param replyQuestionOutputData the output data containing the result of the reply question use case.
     */
    void prepareSuccessView(ReplyQuestionOutputData replyQuestionOutputData);
}
