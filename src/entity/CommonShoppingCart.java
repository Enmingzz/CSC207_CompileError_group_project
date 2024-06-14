package entity;

import java.util.ArrayList;

public class CommonShoppingCart {
    float totalPrice;
    CommonUser user;
    ArrayList<Product> listProducts;

    public CommonShoppingCart(CommonUser user, ArrayList<Product> listProducts) {
        this.user = user;
        this.listProducts = listProducts;
        this.totalPrice = 0;
    }
    public float getTotalPrice() {
        return totalPrice;
    }

    public CommonUser getUser() {
        return user;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }
}
