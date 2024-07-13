package use_case.profile.modify_profile;

public interface ModifyProfileOutputBoundary {
    public void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData);
    public void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData);
}
