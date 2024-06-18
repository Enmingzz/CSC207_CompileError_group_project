package use_case;

import data_access.ShoppingCartAddDataAccessInterface;
import entity.Product;
import entity.ShoppingCart;
import data_access.ShoppingCartSaveDataAccessInterface;

public class AddShoppingCartProductInteractor implements AddShoppingCartProductInputBoundary{

    final ShoppingCartSaveDataAccessInterface shoppingCartAddDataAccessObject;
    final AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter;

    public AddShoppingCartProductInteractor(ShoppingCartSaveDataAccessInterface shoppingCartAddDataAccessObject,
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
