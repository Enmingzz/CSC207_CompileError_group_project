package use_case.profile.view_profile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Input boundary interface for viewing a user's profile use case.
 * This interface defines the method to execute the use case.
 */
public interface ViewUserProfileInputBoundary {

    /**
     * Executes the use case to view a user's profile.
     *
     * @param userProfileInputData the input data containing the seller's student number and the buyer's information
     * @throws SQLException if there is an error accessing the database
     * @throws IOException if there is an I/O error
     */
    void execute(ViewUserProfileInputData userProfileInputData) throws SQLException, IOException;

}
