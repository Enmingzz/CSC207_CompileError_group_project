package interface_adapter.signup;

import use_case.signup.EmailVerificationInputBoundary;
import use_case.signup.EmailVerificationInputData;

/**
 * Controller class for email verification during the signup process.
 * It interacts with the use case interactor to execute the email verification action.
 */

public class EmailVerificationController {

    final EmailVerificationInputBoundary emailVerificationUsecaseInteractor;

    /**
     * Constructs an EmailVerificationController with the given use case interactor.
     *
     * @param emailVerificationUsecaseInteractor the interactor for the email verification use case
     */
    public EmailVerificationController(EmailVerificationInputBoundary emailVerificationUsecaseInteractor) {
        this.emailVerificationUsecaseInteractor = emailVerificationUsecaseInteractor;
    }

    /**
     * Executes the email verification process.
     * Creates an email verification input data object with the provided email and passes it to the interactor for processing.
     *
     * @param email the email address to verify
     * @throws Exception if an error occurs during the email verification process
     */

    public void execute(String email) throws Exception {
        EmailVerificationInputData emailVerificationInputData = new EmailVerificationInputData(email);
        emailVerificationUsecaseInteractor.execute(emailVerificationInputData);
    }

}
