package use_case.product_search;

import entity.product.Product;

import java.util.ArrayList;

public class SearchProductByNameOutputData {

    ArrayList<Product> products;

    public SearchProductByNameOutputData(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
