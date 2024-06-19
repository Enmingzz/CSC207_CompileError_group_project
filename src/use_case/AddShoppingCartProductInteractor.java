package use_case;

import entity.Product;
import entity.ShoppingCart;
import entity.User;
import data_access.ShoppingCartSaveDataAccessInterface;
import data_access.ShoppingCartLoadDataAccessInterface;

public class AddShoppingCartProductInteractor implements AddShoppingCartProductInputBoundary{

    final ShoppingCartSaveDataAccessInterface shoppingCartAddDataAccessObject;
    final AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter;
    final ShoppingCartLoadDataAccessInterface shoppingCartLoadDataAccessObject;

    public AddShoppingCartProductInteractor(ShoppingCartSaveDataAccessInterface shoppingCartAddDataAccessObject,
                                            AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter,
                                            ShoppingCartLoadDataAccessInterface shoppingCartLoadDataAccessObject) {
        this.shoppingCartAddDataAccessObject = shoppingCartAddDataAccessObject;
        this.addShoppingCartProductPresenter = addShoppingCartProductPresenter;
        this.shoppingCartLoadDataAccessObject = shoppingCartLoadDataAccessObject;
    }

    @Override
    public void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) {
        User user = addShoppingCartProductInputData.getUser();
        Product addProduct = addShoppingCartProductInputData.getProduct();
        ShoppingCart shoppingCart = shoppingCartLoadDataAccessObject.load(user);

        shoppingCart.getListProducts().add(addProduct);
        shoppingCartAddDataAccessObject.save(shoppingCart, addProduct);
        AddShoppingCartProductOutputData addShoppingCartProductOutputData = new AddShoppingCartProductOutputData(user);
        addShoppingCartProductPresenter.prepareSuccessView(addShoppingCartProductOutputData);

    }


}
