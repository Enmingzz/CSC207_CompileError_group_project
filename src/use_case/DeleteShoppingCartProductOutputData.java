package use_case;

import entity.user.User;

public class DeleteShoppingCartProductOutputData {
    private final User user;

    public DeleteShoppingCartProductOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
