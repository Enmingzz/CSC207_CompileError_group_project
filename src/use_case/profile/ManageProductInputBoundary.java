package use_case.profile;

import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface ManageProductInputBoundary {

    public void execute(User user) throws SQLException, IOException;
}
