package use_case.modify_product;

import entity.user.User;

public class ViewCreateProductInputData {

    private final User user;

    public ViewCreateProductInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
