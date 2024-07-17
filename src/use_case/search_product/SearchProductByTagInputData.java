package use_case.search_product;

import entity.user.User;

/**
 * The SearchProductByTagInputData class holds the data required for searching products by tag,
 * including the user and the tag to search for.
 */
public class SearchProductByTagInputData {
    private final User user;
    private final String tag;

    /**
     * Constructs a SearchProductByTagInputData object.
     *
     * @param user the user performing the search
     * @param tag the tag to search for
     */
    public SearchProductByTagInputData(User user, String tag) {
        this.user = user;
        this.tag = tag;
    }

    /**
     * Returns the user performing the search.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the tag to search for.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
}

