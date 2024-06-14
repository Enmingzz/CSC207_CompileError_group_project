package entity;

import java.util.ArrayList;

public class CommonShoppingCartFactory implements ShoppingCartFactory{
    public ShoppingCart createShoppingCart(float totalPrice, CommonUser user, ArrayList<Product> listProducts) {
        return new CommonShoppingCart(totalPrice, user, listProducts);
    }
}
