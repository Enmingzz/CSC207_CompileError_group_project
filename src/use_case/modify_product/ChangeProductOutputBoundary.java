package use_case.modify_product;

import use_case.profile.modify_profile.ModifyProfileOutputData;

public interface ChangeProductOutputBoundary {
    public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData);

}
