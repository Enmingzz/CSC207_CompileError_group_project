package use_case.Signup;

public interface EmailVerificationInputBoundary {

    void execute(EmailVerificationInputData emailVerificationInputData) throws Exception;
}
