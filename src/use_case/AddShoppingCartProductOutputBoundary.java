package use_case;

public interface AddShoppingCartProductOutputBoundary {
    void prepareSuccessView(AddShoppingCartProductOutputData addShoppingCartProductOutputData);
    void prepareFailView(String errorMessage);
}
