package use_case.product_search;

import entity.product.Product;

import java.util.ArrayList;

public class SearchProductByTagOutputData {
    private final ArrayList<Product> products;

    public SearchProductByTagOutputData(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
