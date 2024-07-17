package use_case.search_product;

import entity.user.User;

/**
 * The GetSearchViewInputData class holds the data required to retrieve the search page,
 * including the user information.
 */
public class GetSearchViewInputData {
    private final User user;

    /**
     * Constructs a GetSearchViewInputData object.
     *
     * @param user the user requesting the search page
     */
    public GetSearchViewInputData(User user) {
        this.user = user;
    }

    User getUser() {
        return user;
    }
}
