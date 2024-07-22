package use_case.view_product;

import java.sql.SQLException;

/**
 * This interface defines the output boundary for the use case of publishing a question.
 * It acts as a contract for any class that wants to implement the presentation of the result of publishing a question.
 */
public interface PublishQuestionOutputBoundary {

    /**
     * Prepares the success view for the publish question use case.
     *
     * @param publishQuestionOutputData the output data containing the result of the publish question use case.
     * @throws SQLException if there is an error while interacting with the database.
     */
    void prepareSuccessView(PublishQuestionOutputData publishQuestionOutputData) throws SQLException;
}
