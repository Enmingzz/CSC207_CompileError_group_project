package use_case.login;

import java.sql.SQLException;

public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData) throws SQLException;
}
