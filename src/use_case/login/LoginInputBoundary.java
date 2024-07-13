package use_case.login;

import java.sql.SQLException;

/**
 * Interface of LoginInteractor, for encapsulation
 * @author CompileError group
 */
public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData) throws SQLException;
}
