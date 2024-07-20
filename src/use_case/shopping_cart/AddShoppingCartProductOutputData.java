package use_case.shopping_cart;

import entity.user.User;
import entity.product.Product;

import java.util.ArrayList;
import java.util.List;

public class AddShoppingCartProductOutputData {
    private final User user;
    private final ArrayList<Product> listProducts;
    private final float totalPrice;
    private final String errorMessage;

    public AddShoppingCartProductOutputData(User user, ArrayList<Product> listProducts, float totalPrice,
                                            String errorMessage) {
        this.user = user;
        this.listProducts = listProducts;
        this.totalPrice = totalPrice;
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
