package use_case.profile;

public interface ModifyProfileOutputBoundary {

    public void prepareSuccessfulView(String message);

    public void prepareFailedView(String message);
}
