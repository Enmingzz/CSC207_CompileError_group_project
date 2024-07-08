package use_case.search_product;

import entity.product.Product;

import java.util.ArrayList;

public class SearchProductByNameOutputData {

    private final ArrayList<Product> products;

    public SearchProductByNameOutputData(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}