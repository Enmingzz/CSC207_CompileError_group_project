package use_case.profile.view_profile;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

public class ViewUserProfileOutputData {

    private final User seller;
    private final User buyer;
    private final ArrayList<Product> productList;

    public ViewUserProfileOutputData(User seller, User buyer, ArrayList<Product> productList) {
        this.seller = seller;
        this.buyer = buyer;
        this.productList = productList;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

}
