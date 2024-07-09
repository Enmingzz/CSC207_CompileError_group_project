package use_case.signup;

public interface SignupOutputBoundary {

    public void presentSuccessfulView(SignupOutputData response);

    public void presentFailedView(SignupOutputData response);

}
