package use_case.signup;

import java.sql.SQLException;

public interface SignupInputBoundary {
    void execute(SignupInputData signupInputData) throws SQLException;
}
