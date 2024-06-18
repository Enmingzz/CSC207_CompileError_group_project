package use_case;

import entity.Product;
import entity.ShoppingCart;

public class AddShoppingCartProductInputData {
    private Product product;
    private ShoppingCart shoppingCart;

    public AddShoppingCartProductInputData(Product product, ShoppingCart shoppingCart) {
        this.product = product;
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
