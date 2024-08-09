package use_case.shopping_cart;

import entity.product.Product;
import entity.shopping_cart.ShoppingCart;
import entity.user.User;
import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Interactor implementation for adding a product to the shopping cart.
 * Implements {@link AddShoppingCartProductInputBoundary}.
 */

public class AddShoppingCartProductInteractor implements AddShoppingCartProductInputBoundary{

    final ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessObject;
    final AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter;
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject;

    /**
     * Constructs an {@code AddShoppingCartProductInteractor} with the specified dependencies.
     *
     * @param shoppingCartUpdateAddDataAccessObject the data access object for updating the shopping cart
     * @param addShoppingCartProductPresenter      the presenter for handling output of adding a product
     * @param shoppingCartReadDataAccessObject     the data access object for reading the shopping cart
     */

    public AddShoppingCartProductInteractor(ShoppingCartUpdateAddDataAccessInterface shoppingCartUpdateAddDataAccessObject,
                                            AddShoppingCartProductOutputBoundary addShoppingCartProductPresenter,
                                            ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject) {

        this.shoppingCartUpdateAddDataAccessObject = shoppingCartUpdateAddDataAccessObject;
        this.addShoppingCartProductPresenter = addShoppingCartProductPresenter;
        this.shoppingCartReadDataAccessObject = shoppingCartReadDataAccessObject;
    }

    /**
     * Adds a product to the shopping cart based on the input data.
     *
     * @param addShoppingCartProductInputData the input data containing user and product information
     * @throws SQLException if there's an error accessing the database
     * @throws IOException  if there's an error handling input/output
     */

    @Override
    public void addProductToShoppingCart(AddShoppingCartProductInputData addShoppingCartProductInputData) throws SQLException, IOException {
        User user = addShoppingCartProductInputData.getUser();
        Product addProduct = addShoppingCartProductInputData.getProduct();
        ShoppingCart shoppingCart = shoppingCartReadDataAccessObject.getShoppingCart(user.getStudentNumber());
        ArrayList<Product> initialListProducts = shoppingCart.getListProducts();
        boolean isFailed = false;
        for (Product product : initialListProducts) {
            if (product instanceof Product) {
                if (Objects.equals(product.getProductID(), addProduct.getProductID())) {
                    isFailed = true;
                    addShoppingCartProductPresenter.prepareFailedView("Product already in Shopping Cart");
                }
            }
        }
        if (!Objects.equals(addProduct.getState(), 0)) {
            addShoppingCartProductPresenter.prepareFailedView("Product has already been sold");
            isFailed = true;
        }

        if (!isFailed) {
            shoppingCartUpdateAddDataAccessObject.updateShoppingCart(user, addProduct);

            float totalPrice = addProduct.getPrice();
            ShoppingCart newShoppingCart = shoppingCartReadDataAccessObject.getShoppingCart(user.getStudentNumber());
            ArrayList<Product> listProducts = newShoppingCart.getListProducts();
            AddShoppingCartProductOutputData addShoppingCartProductOutputData = new AddShoppingCartProductOutputData(user, listProducts, totalPrice, "");
            addShoppingCartProductPresenter.prepareSuccessView(addShoppingCartProductOutputData);

        }

    }


}
