package use_case.login;

public interface LoginOutputBoundary {

    void prepareSuccessfulView(LoginOutputData response);

    void prepareFailedView(String error);
}
