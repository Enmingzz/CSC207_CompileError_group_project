package use_case.signup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailVerificationInteractorTest {

    private EmailVerificationInteractor emailVerificationInteractor;
    private EmailVerificationInputData emailVerificationInputData;
    private EmailVerificationOutputBoundary emailVerificationPresenter;

    @BeforeEach
    void setUp() {
        emailVerificationInputData = new EmailVerificationInputData("hanrui@gmail");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        
        emailVerificationPresenter = new EmailVerificationOutputBoundary(){

            @Override
            public void prepareView(EmailVerificationOutputData emailVerificationOutputData) {
//                assertEquals(emailVerificationOutputData.getVerificationCode());
            }
        };
    }

    @Test
    void createMimeMessage() {
    }
}