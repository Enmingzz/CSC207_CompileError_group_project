package use_case.profile.modify_profile;

public class ViewModifyProfileInteractor implements ViewModifyProfileInputBoundary{

    private final ViewModifyProfileOutputBoundary viewModifyProfilePresenter;

    public ViewModifyProfileInteractor(ViewModifyProfileOutputBoundary viewModifyProfilePresenter) {
        this.viewModifyProfilePresenter = viewModifyProfilePresenter;
    }

    public void execute(ViewModifyProfileInputData viewModifyProfileInputData){
        ViewModifyProfileOutputData viewModifyProfileOutputData=
                new ViewModifyProfileOutputData(viewModifyProfileInputData.getUser());
        viewModifyProfilePresenter.prepareSuccessfulView(viewModifyProfileOutputData);
    }
}
