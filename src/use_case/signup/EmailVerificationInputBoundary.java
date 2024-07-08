package use_case.signup;

public interface EmailVerificationInputBoundary {

    void execute(EmailVerificationInputData emailVerificationInputData) throws Exception;
}
