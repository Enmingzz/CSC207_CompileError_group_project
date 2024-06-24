package interface_adapter.profile;

import entity.user.User;
import use_case.profile.ManageProductInputBoundary;

public class ManageProductController {

    private final ManageProductInputBoundary manageProductInteractor;

    public ManageProductController(ManageProductInputBoundary manageProductInteractor) {
        this.manageProductInteractor = manageProductInteractor;
    }

    public void execute(User user){
        manageProductInteractor.execute(user);
    }
}
