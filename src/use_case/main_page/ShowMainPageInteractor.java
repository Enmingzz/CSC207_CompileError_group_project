package use_case.main_page;

import entity.user.User;

public class ShowMainPageInteractor implements ShowMainPageInputBoundary{
    final ShowMainPageOutputBoundary mainPagePresenter;

    public ShowMainPageInteractor(ShowMainPageOutputBoundary mainPagePresenter) {
        this.mainPagePresenter = mainPagePresenter;
    }

    @Override
    public void showMainPage(ShowMainPageInputData showMainPageInputData) {
        User user = showMainPageInputData.getUser();

        ShowMainPageOutputData showMainPageOutputData = new ShowMainPageOutputData(user);
        mainPagePresenter.prepareSuccessView(showMainPageOutputData);

    }
}
