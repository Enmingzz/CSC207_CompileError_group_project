package interface_adapter.profile.ModifyProfile;

import entity.user.User;
import use_case.profile.modify_profile.ModifyProfileInputBoundary;
import use_case.profile.modify_profile.ModifyProfileInputData;

import java.io.IOException;
import java.sql.SQLException;

public class ModifyProfileController {

    private final ModifyProfileInputBoundary modifyProfileInteractor;

    public ModifyProfileController(ModifyProfileInputBoundary modifyProfileInteractor) {
        this.modifyProfileInteractor = modifyProfileInteractor;
    }

    public void execute(User user) throws SQLException, IOException {
        ModifyProfileInputData modifyProfileInputData = new ModifyProfileInputData(user);
        modifyProfileInteractor.execute(modifyProfileInputData);
    }

}
