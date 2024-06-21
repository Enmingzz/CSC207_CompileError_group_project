package use_case;

import entity.product.Product;
import entity.user.User;
import entity.shopping_cart.ShoppingCart;

import data_access.interfaces.ShoppingCartUpdateDeleteDataAccessInterface;
import data_access.interfaces.ShoppingCartReadDataAccessInterface;

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
    public void deleteShoppingCartProduct(DeleteShoppingCartProductInputData deleteShoppingCartProductInputData) throws SQLException{
        User user = deleteShoppingCartProductInputData.getUser();
        Product deletedProduct = deleteShoppingCartProductInputData.getProduct();
        shoppingCartUpdateDeleteDataAccessObject.updateShoppingCart(user, deletedProduct);
        ArrayList<Product> listProducts = shoppingCartReadDataAccessObject.getShoppingCart(user.getStudentNumber()).getListProducts();

        DeleteShoppingCartProductOutputData deleteShoppingCartProductOutputData = new DeleteShoppingCartProductOutputData(user, listProducts);

        deleteShoppingCartProductOutputBoundary.prepareSuccessView(deleteShoppingCartProductOutputData);

    }
}
