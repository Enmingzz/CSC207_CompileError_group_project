package use_case.modify_product;

import entity.user.User;

public class ViewCreateProductOutputData {

    private final User user;

    public ViewCreateProductOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
