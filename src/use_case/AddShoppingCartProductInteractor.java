package use_case;

import entity.Product;
import entity.ShoppingCart;
import entity.User;
import data_access.ShoppingCartUpdateAddDataAccessInterface;
import data_access.ShoppingCartReadDataAccessInterface;

import java.sql.SQLException;

public class AddShoppingCartProductInteractor implements AddShoppingCartProductInputBoundary{

    final ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessInterface;
    final AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter;
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface;

    public AddShoppingCartProductInteractor(ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessInterface,
                                            AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter,
                                            ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessInterface) {

        this.shoppingCartUpdateAddDataAccessInterface = shoppingCartUpdateAddDataAccessInterface;
        this.addShoppingCartProductPresenter = addShoppingCartProductPresenter;
        this.shoppingCartReadDataAccessInterface = shoppingCartReadDataAccessInterface;
    }

    @Override
    public void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) throws SQLException {
        User user = addShoppingCartProductInputData.getUser();
        Product addProduct = addShoppingCartProductInputData.getProduct();
        String shoppingCartUser = shoppingCartReadDataAccessInterface.getShoppingCart(user.getStudentNumber(), );

        shoppingCartUpdateAddDataAccessInterface.updateShoppingCart(shoppingCartUser, addProduct.get);
        AddShoppingCartProductOutputData addShoppingCartProductOutputData = new AddShoppingCartProductOutputData(user);
        addShoppingCartProductPresenter.prepareSuccessView(addShoppingCartProductOutputData);

    }


}
