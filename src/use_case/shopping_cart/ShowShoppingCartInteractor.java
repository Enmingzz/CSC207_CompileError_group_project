package use_case.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import entity.shopping_cart.ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interactor implementation for showing the shopping cart.
 * Implements {@link ShowShoppingCartInputBoundary}.
 */

public class ShowShoppingCartInteractor implements ShowShoppingCartInputBoundary{

    private final ShowShoppingCartOutputBoundary presenter;
    private final ShoppingCartReadDataAccessInterface shoppingCartReadDataAccess;

    /**
     * Constructs a {@code ShowShoppingCartInteractor} with the specified dependencies.
     *
     * @param presenter              the presenter for handling output of the shopping cart
     * @param shoppingCartReadDataAccess the data access object for reading the shopping cart
     */

    public ShowShoppingCartInteractor(ShowShoppingCartOutputBoundary presenter, ShoppingCartReadDataAccessInterface
            shoppingCartReadDataAccess) {
        this.presenter = presenter;
        this.shoppingCartReadDataAccess = shoppingCartReadDataAccess;
    }

    /**
     * Executes the operation to retrieve and present the shopping cart.
     *
     * @param showShoppingCartInputData the input data containing user information
     * @throws SQLException if there's an error accessing the database
     * @throws IOException  if there's an error handling input/output
     */

    public void execute(ShowShoppingCartInputData showShoppingCartInputData) throws SQLException, IOException {
        ShoppingCart shoppingCart =
                shoppingCartReadDataAccess.getShoppingCart(showShoppingCartInputData.getUser().getStudentNumber());
        ShowShoppingCartOutputData showShoppingCartOutputData =
                new ShowShoppingCartOutputData(showShoppingCartInputData.getUser(), shoppingCart);
        presenter.prepareSuccessfulView(showShoppingCartOutputData);

    }
}
