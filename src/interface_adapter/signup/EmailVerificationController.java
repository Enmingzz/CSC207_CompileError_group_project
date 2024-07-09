package interface_adapter.signup;

import use_case.signup.EmailVerificationInputBoundary;
import use_case.signup.EmailVerificationInputData;

public class EmailVerificationController {

    final EmailVerificationInputBoundary emailVerificationUsecaseInteractor;

    public EmailVerificationController(EmailVerificationInputBoundary emailVerificationUsecaseInteractor) {
        this.emailVerificationUsecaseInteractor = emailVerificationUsecaseInteractor;
    }

    public void execute(String email) throws Exception {
        EmailVerificationInputData emailVerificationInputData = new EmailVerificationInputData(email);
        emailVerificationUsecaseInteractor.execute(emailVerificationInputData);
    }
}
