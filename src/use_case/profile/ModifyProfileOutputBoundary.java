package use_case.profile;

public interface ModifyProfileOutputBoundary {

    public void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData);

    public void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData);
}
