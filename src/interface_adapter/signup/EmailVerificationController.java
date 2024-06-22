package interface_adapter.signup;

import use_case.Signup.EmailVerificationInputBoundary;

public class EmailVerificationController {

    final EmailVerificationInputBoundary emailVerificationUsecaseInteractor;

    public EmailVerificationController(EmailVerificationInputBoundary emailVerificationUsecaseInteractor) {
        this.emailVerificationUsecaseInteractor = emailVerificationUsecaseInteractor;
    }

    public void execute(String email) throws Exception {
        emailVerificationUsecaseInteractor.execute(email);
    }
}
