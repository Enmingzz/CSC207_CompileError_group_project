package use_case.Signup;

import java.sql.SQLException;

public interface SignupInputBoundary {
    void execute(SignupInputData signupInputData) throws SQLException;
}
