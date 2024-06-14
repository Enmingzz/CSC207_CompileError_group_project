package entity;

import java.util.ArrayList;

public class CommonShoppingCart implements ShoppingCart{
    private float totalPrice;
    private CommonUser user;
    private ArrayList<Product> listProducts;

    public CommonShoppingCart(float totalPrice, CommonUser user, ArrayList<Product> listProducts) {
        this.user = user;
        this.listProducts = listProducts;
        this.totalPrice = totalPrice;
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public CommonUser getUser() {
        return user;
    }

    @Override
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }
}
