package use_case.login;

/**
 * Interface of LoginPresenter
 * @author CompileError group
 */

public interface LoginOutputBoundary {

    void prepareSuccessfulView(LoginOutputData response);

    void prepareFailedView(String error);
}
