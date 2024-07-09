package interface_adapter.search_product;

import use_case.product_search.SearchProductByTagOutputBoundary;
import use_case.product_search.SearchProductByTagOutputData;

public class SearchProductByTagPresenter implements SearchProductByTagOutputBoundary {
    private final SearchProductViewModel viewModel;

    public SearchProductByTagPresenter(SearchProductViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessfulView(SearchProductByTagOutputData searchProductByTagOutputData) {
        viewModel.setProducts(searchProductByTagOutputData.getProducts());
    }

}
