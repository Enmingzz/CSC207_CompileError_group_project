package use_case.shopping_cart;

import entity.product.Product;
import entity.user.User;
import entity.shopping_cart.ShoppingCart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interactor implementation for deleting a product from the shopping cart.
 * Implements {@link DeleteShoppingCartProductInputBoundary}.
 */

public class DeleteShoppingCartProductInteractor implements DeleteShoppingCartProductInputBoundary {
    final ShoppingCartUpdateDeleteDataAccessInterface shoppingCartUpdateDeleteDataAccessObject;
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject;
    final DeleteShoppingCartProductOutputBoundary deleteShoppingCartProductOutputBoundary;

    /**
     * Constructs a {@code DeleteShoppingCartProductInteractor} with the specified dependencies.
     *
     * @param shoppingCartUpdateDeleteDataAccessObject the data access object for updating the shopping cart by deleting a product
     * @param shoppingCartReadDataAccessObject         the data access object for reading the shopping cart
     * @param deleteShoppingCartProductOutputBoundary  the presenter for handling output of deleting a product from the shopping cart
     */

    public DeleteShoppingCartProductInteractor(ShoppingCartUpdateDeleteDataAccessInterface
                                                       shoppingCartUpdateDeleteDataAccessObject,
                                               ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject,
                                               DeleteShoppingCartProductOutputBoundary deleteShoppingCartProductOutputBoundary)
    {
        this.shoppingCartUpdateDeleteDataAccessObject = shoppingCartUpdateDeleteDataAccessObject;
        this.deleteShoppingCartProductOutputBoundary = deleteShoppingCartProductOutputBoundary;
        this.shoppingCartReadDataAccessObject = shoppingCartReadDataAccessObject;
    }

    /**
     * Deletes a product from the shopping cart based on the input data.
     *
     * @param deleteShoppingCartProductInputData the input data containing user and product information to delete
     * @throws SQLException if there's an error accessing the database
     * @throws IOException  if there's an error handling input/output
     */

    @Override
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException, IOException {
        User user = deleteShoppingCartProductInputData.getUser();
        Product deletedProduct = deleteShoppingCartProductInputData.getProduct();

        shoppingCartUpdateDeleteDataAccessObject.updateShoppingCart(user, deletedProduct);

        ShoppingCart shoppingCart = shoppingCartReadDataAccessObject.getShoppingCart(user.getStudentNumber());
        ArrayList<Product> listProducts = shoppingCart.getListProducts();
        float totalPrice = shoppingCart.getTotalPrice();

        DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData = new DeleteShoppingCartProductOutputData(user, listProducts, totalPrice);
        deleteShoppingCartProductOutputBoundary.prepareSuccessView(deleteShoppingCartProductOutputData);

    }
}
