package use_case.view_product;

import java.sql.SQLException;
/**
 * This interface defines the input boundary for the use case of publishing a question.
 * It acts as a contract for any class that wants to implement the functionality of publishing a question.
 */

public interface PublishQuestionInputBoundary {

    /**
     * Executes the use case of publishing a question.
     *
     * @param publishQuestionInputData the input data required to publish a question.
     * @throws SQLException if there is an error while interacting with the database.
     */
    void execute(PublishQuestionInputData publishQuestionInputData) throws SQLException;
}
