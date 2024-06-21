package interface_adapter;

import entity.user.User;
import entity.product.Product;
import entity.shopping_cart.ShoppingCart;

public class AddToCartState {
    private ShoppingCart shoppingCart = null;
    private User user = null;
    private Product product = null;

    public AddToCartState(AddToCartState copy){
        shoppingCart = copy.shoppingCart;
        user = copy.user;
        product = copy.product;
    }

    public AddToCartState() {}

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
