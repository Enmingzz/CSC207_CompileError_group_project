package use_case.view_product;

import java.sql.SQLException;

/**
 * This interface defines the input boundary for the use case of viewing the reply to a question.
 * It acts as a contract for any class that wants to implement the functionality of viewing a reply to a question.
 */
public interface ViewReplyQuestionInputBoundary {

    /**
     * Executes the use case of viewing the reply to a question.
     *
     * @param viewReplyQuestionInputData the input data required to view the reply to a question.
     * @throws SQLException if there is an error while interacting with the database.
     */
    void execute(ViewReplyQuestionInputData viewReplyQuestionInputData) throws SQLException;
}
