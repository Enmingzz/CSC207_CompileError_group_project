package use_case.search_product;

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
