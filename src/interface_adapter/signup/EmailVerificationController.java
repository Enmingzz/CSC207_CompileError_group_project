package interface_adapter.signup;

import use_case.Signup.EmailVerificationInputBoundary;
import use_case.Signup.EmailVerificationInputData;

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
