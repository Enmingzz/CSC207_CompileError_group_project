package use_case.product_search;

import entity.user.User;

public class SearchProductByTagInputData {
    private final User user;
    private final String tag;

    public SearchProductByTagInputData(User user, String tag) {
        this.user = user;
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public String getTag() {
        return tag;
    }
}

