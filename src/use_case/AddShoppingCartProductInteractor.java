package use_case;

import entity.Product;
import entity.ShoppingCart;
import data_access.ShoppingCartUpdateDataAccessInterface;

public class AddShoppingCartProductInteractor implements AddShoppingCartProductInputBoundary{

    final ShoppingCartUpdateDataAccessInterface shoppingCartAddDataAccessObject;
    final AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter;

    public AddShoppingCartProductInteractor(ShoppingCartUpdateDataAccessInterface shoppingCartAddDataAccessObject,
                                            AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter) {
        this.shoppingCartAddDataAccessObject = shoppingCartAddDataAccessObject;
        this.addShoppingCartProductPresenter = addShoppingCartProductPresenter;
    }

    public void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) {
        ShoppingCart shoppingCart = addShoppingCartProductInputData.getShoppingCart();
        Product addProduct = addShoppingCartProductInputData.getProduct();
        boolean isRepeated = false;
        for (Product product: shoppingCart.getListProducts()) {
            if (addProduct.equals(product)) {
                isRepeated = true;
                break;
            }
        }
        if (isRepeated) {
            addShoppingCartProductPresenter.prepareFailView("Product Already Exists In Cart");
        }
        else {
            shoppingCart.getListProducts().add(addProduct);
            shoppingCartAddDataAccessObject.save(shoppingCart, addProduct);
            AddShoppingCartProductOutputData addShoppingCartProductOutputData = new AddShoppingCartProductOutputData(addProduct, shoppingCart, false);
            addShoppingCartProductPresenter.prepareSuccessView(addShoppingCartProductOutputData);
        }

    }


}
