package use_case;

import entity.Product;
import entity.ShoppingCart;

public class AddShoppingCartProductOutputData {
    private Product addedProduct;
    private ShoppingCart shoppingCart;
    private boolean useCaseFailed;

    public AddShoppingCartProductOutputData(Product addedProduct, ShoppingCart shoppingCart, boolean useCaseFailed) {
        this.addedProduct = addedProduct;
        this.shoppingCart = shoppingCart;
        this.useCaseFailed = useCaseFailed;
    }

    public Product getAddedProduct() {
        return addedProduct;
    }

    public void setAddedProduct(Product addedProduct) {
        this.addedProduct = addedProduct;
    }

    public ShoppingCart getShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCart;
    }
}
