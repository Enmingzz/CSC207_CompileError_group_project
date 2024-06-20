package use_case;

import entity.Product;
import entity.ShoppingCart;
import entity.User;
import data_access.ShoppingCartUpdateDataAccessInterface;
import data_access.ShoppingCartReadDataAccessInterface;

import java.sql.SQLException;

public class AddShoppingCartProductInteractor implements AddShoppingCartProductInputBoundary{

    final ShoppingCartUpdateDataAccessInterface shoppingCartUpdateDataAccessInterface;
    final AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter;
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface;

    public AddShoppingCartProductInteractor(ShoppingCartUpdateDataAccessInterface shoppingCartUpdateDataAccessInterface,
                                            AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter,
                                            ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface) {

        this.shoppingCartUpdateDataAccessInterface = shoppingCartUpdateDataAccessInterface;
        this.addShoppingCartProductPresenter = addShoppingCartProductPresenter;
        this.shoppingCartReadDataAccessInterface = shoppingCartReadDataAccessInterface;
    }

    @Override
    public void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) throws SQLException {
        User user = addShoppingCartProductInputData.getUser();
        Product addProduct = addShoppingCartProductInputData.getProduct();
        ShoppingCart shoppingCart = shoppingCartReadDataAccessInterface.getShoppingCart(user);

        shoppingCartUpdateDataAccessInterface.updateShoppingCart(shoppingCart, addProduct);
        AddShoppingCartProductOutputData addShoppingCartProductOutputData = new AddShoppingCartProductOutputData(user);
        addShoppingCartProductPresenter.prepareSuccessView(addShoppingCartProductOutputData);

    }


}
