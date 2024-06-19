package use_case;

import java.sql.SQLException;

public interface SignupInputBoundary {
    void execute(SignupInputData signupInputData) throws SQLException;
}
