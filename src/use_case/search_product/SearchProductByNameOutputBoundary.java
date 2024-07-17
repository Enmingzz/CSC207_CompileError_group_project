package use_case.search_product;

/**
 * The SearchProductByNameOutputBoundary interface provides a method for preparing the
 * output view based on the result of searching for products by name.
 */
public interface SearchProductByNameOutputBoundary {

    /**
     * Prepares the successful view with the given output data.
     *
     * @param searchProductByNameOutputData the output data containing the user and list of matching products
     */
    void prepareSuccessfulView(SearchProductByNameOutputData searchProductByNameOutputData);
}
