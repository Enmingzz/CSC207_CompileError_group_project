package use_case.view_product;

import java.sql.SQLException;

/**
 * This interface defines the input boundary for the use case of replying to a question.
 * It acts as a contract for any class that wants to implement the functionality of replying to a question.
 */
public interface ReplyQuestionInputBoundary {

    /**
     * Executes the use case of replying to a question.
     *
     * @param replyQuestionInputData the input data required to reply to a question.
     * @throws SQLException if there is an error while interacting with the database.
     */
    void execute(ReplyQuestionInputData replyQuestionInputData) throws SQLException;
}
