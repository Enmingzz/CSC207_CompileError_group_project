package use_case.product_search;

import entity.user.User;

public class GetSearchViewInputData {
    private final User user;

    public GetSearchViewInputData(User user) {
        this.user = user;
    }

    User getUser() {
        return user;
    }
}
