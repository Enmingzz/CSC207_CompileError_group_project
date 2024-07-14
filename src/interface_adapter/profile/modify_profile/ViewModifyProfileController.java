package interface_adapter.profile.modify_profile;

import entity.user.User;
import use_case.profile.modify_profile.ModifyProfileInputBoundary;
import use_case.profile.modify_profile.ModifyProfileInputData;
import use_case.profile.modify_profile.ViewModifyProfileInputBoundary;
import use_case.profile.modify_profile.ViewModifyProfileInputData;

import java.io.IOException;
import java.sql.SQLException;

public class ViewModifyProfileController {

    private final ViewModifyProfileInputBoundary viewModifyProfileInteractor;

    public ViewModifyProfileController(ViewModifyProfileInputBoundary modifyProfileInteractor) {
        this.viewModifyProfileInteractor = modifyProfileInteractor;
    }

    public void execute(User user) throws SQLException, IOException {
        ViewModifyProfileInputData viewModifyProfileInputData =
                new ViewModifyProfileInputData(user);
        viewModifyProfileInteractor.execute(viewModifyProfileInputData);
    }

}
