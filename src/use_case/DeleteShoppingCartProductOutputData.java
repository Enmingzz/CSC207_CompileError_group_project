package use_case;

import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;

public class DeleteShoppingCartProductOutputData {
    private final User user;
    private final ArrayList<Product> listProducts;

    public DeleteShoppingCartProductOutputData(User user, ArrayList<Product> listProducts) {
        this.user = user;
        this.listProducts = listProducts;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }
}
