package use_case.shopping_cart;

import entity.product.Product;
import entity.user.User;
import entity.shopping_cart.ShoppingCart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class DeleteShoppingCartProductInteractor implements DeleteShoppingCartProductInputBoundary {
    final ShoppingCartUpdateDeleteDataAccessInterface shoppingCartUpdateDeleteDataAccessObject;
    final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject;
    final DeleteShoppingCartProductOutputBoundary deleteShoppingCartProductOutputBoundary;


    public DeleteShoppingCartProductInteractor(ShoppingCartUpdateDeleteDataAccessInterface
                                                       shoppingCartUpdateDeleteDataAccessObject,
                                               ShoppingCartReadDataAccessInterface shoppingCartReadDataAccessObject,
                                               DeleteShoppingCartProductOutputBoundary deleteShoppingCartProductOutputBoundary)
    {
        this.shoppingCartUpdateDeleteDataAccessObject = shoppingCartUpdateDeleteDataAccessObject;
        this.deleteShoppingCartProductOutputBoundary = deleteShoppingCartProductOutputBoundary;
        this.shoppingCartReadDataAccessObject = shoppingCartReadDataAccessObject;
    }

    @Override
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException, IOException {
        User user = deleteShoppingCartProductInputData.getUser();
        Product deletedProduct = deleteShoppingCartProductInputData.getProduct();
        ShoppingCart shoppingCart = shoppingCartReadDataAccessObject.getShoppingCart(user.getStudentNumber());

        shoppingCartUpdateDeleteDataAccessObject.updateShoppingCart(user, deletedProduct);
        ArrayList<Product> listProducts = shoppingCart.getListProducts();
        float totalPrice = shoppingCart.getTotalPrice() - deletedProduct.getPrice();

        DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData = new DeleteShoppingCartProductOutputData(user, listProducts, totalPrice);
        deleteShoppingCartProductOutputBoundary.prepareSuccessView(deleteShoppingCartProductOutputData);

    }
}
