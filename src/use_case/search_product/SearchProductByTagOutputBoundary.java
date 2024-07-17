package use_case.search_product;

/**
 * The SearchProductByTagOutputBoundary interface provides a method for preparing the
 * output view based on the result of searching for products by tag.
 */
public interface SearchProductByTagOutputBoundary {
    /**
     * Prepares the successful view with the given output data.
     *
     * @param searchProductByTagOutputData the output data containing the user and list of matching products
     */
    void prepareSuccessfulView(SearchProductByTagOutputData searchProductByTagOutputData);
}
