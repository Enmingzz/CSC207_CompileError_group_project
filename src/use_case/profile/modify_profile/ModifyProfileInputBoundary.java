package use_case.profile.modify_profile;

import java.sql.SQLException;

/**
 * Interface for modifying the profile.
 * Provides a method to execute the action of modifying a profile with the given input data.
 */
public interface ModifyProfileInputBoundary {

    /**
     * Executes the action of modifying a profile.
     *
     * @param modifyProfileInputData the input data for modifying the profile
     * @throws SQLException if a database access error occurs
     */
    void execute(ModifyProfileInputData modifyProfileInputData) throws SQLException;
}
