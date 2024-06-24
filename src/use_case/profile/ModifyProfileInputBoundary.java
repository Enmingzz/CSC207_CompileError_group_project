package use_case.profile;

import java.sql.SQLException;

public interface ModifyProfileInputBoundary {

    public void execute(ModifyProfileInputData modifyProfileInputData) throws SQLException;
}
