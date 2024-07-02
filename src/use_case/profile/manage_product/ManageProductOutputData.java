package use_case.profile.manage_product;


import entity.product.Product;

import java.util.ArrayList;

public class ManageProductOutputData {
    private ArrayList<Product> products;

    public ManageProductOutputData(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
