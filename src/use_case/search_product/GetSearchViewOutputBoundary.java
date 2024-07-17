package use_case.search_product;

/**
 * The GetSearchViewOutputBoundary interface provides a method for preparing the
 * output view based on the result of retrieving the search page.
 */
public interface GetSearchViewOutputBoundary {
    /**
     * Prepares the successful view with the given output data.
     *
     * @param getSearchViewOutputData the output data containing the user and list of on sale products
     */
    void prepareSuccessView(GetSearchViewOutputData getSearchViewOutputData);
}
