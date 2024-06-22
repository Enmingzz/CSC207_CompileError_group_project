package use_case.Signup;

public interface SignupOutputBoundary {

    public void presentSuccessfulView(SignupOutputData response);

    public void presentFailedView(String error);
}
