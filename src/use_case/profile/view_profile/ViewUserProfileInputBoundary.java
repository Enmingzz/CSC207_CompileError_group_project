package use_case.profile.view_profile;

import java.sql.SQLException;

public interface ViewUserProfileInputBoundary {

    void execute(ViewUserProfileInputData userProfileInputData) throws SQLException;

}
