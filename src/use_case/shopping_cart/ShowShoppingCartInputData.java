package use_case.shopping_cart;

import entity.user.User;

public class ShowShoppingCartInputData {
    User user;

    public ShowShoppingCartInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
