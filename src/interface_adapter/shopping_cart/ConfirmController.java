package interface_adapter.shopping_cart;

import entity.product.Product;
import entity.user.User;
import use_case.shopping_cart.ConfirmInputData;
import use_case.shopping_cart.ConfirmInputBoundary;

public class ConfirmController {
    private final ConfirmInputBoundary confirmInteractor;

    public ConfirmController(ConfirmInputBoundary confirmInteractor) {
        this.confirmInteractor = confirmInteractor;
    }

    public void execute(User user, Product product) throws Exception {
        ConfirmInputData confirmInputData = new ConfirmInputData(user, product);

        confirmInteractor.confirm(confirmInputData);
    }
}
