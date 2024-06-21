package use_case;

import java.sql.SQLException;

public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData) throws SQLException;
}
