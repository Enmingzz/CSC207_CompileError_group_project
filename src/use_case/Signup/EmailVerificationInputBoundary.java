package use_case.Signup;

public interface EmailVerificationInputBoundary {

    void execute(String email) throws Exception;
}
