package use_case;

public interface EmailVerificationInputBoundary {

    void execute(String email) throws Exception;
}
