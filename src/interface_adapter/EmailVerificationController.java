package interface_adapter;

import use_case.EmailVerificationInputBoundary;

public class EmailVerificationController {

    final EmailVerificationInputBoundary emailVerificationUsecaseInteractor;

    public EmailVerificationController(EmailVerificationInputBoundary emailVerificationUsecaseInteractor) {
        this.emailVerificationUsecaseInteractor = emailVerificationUsecaseInteractor;
    }

    public void execute(String email) throws Exception {
        emailVerificationUsecaseInteractor.execute(email);
    }
}
