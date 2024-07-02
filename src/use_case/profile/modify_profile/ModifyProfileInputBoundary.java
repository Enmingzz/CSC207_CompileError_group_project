package use_case.profile.modify_profile;

import java.sql.SQLException;

public interface ModifyProfileInputBoundary {

    public void execute(ModifyProfileInputData modifyProfileInputData) throws SQLException;
}
