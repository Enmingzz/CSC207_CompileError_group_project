package use_case;

import entity.User;

public class AddShoppingCartProductOutputData {
    private final User user;

    public AddShoppingCartProductOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
