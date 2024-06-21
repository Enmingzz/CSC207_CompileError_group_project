package interface_adapter;

public class ShoppingCartViewModel extends ViewModel {
    private final String TITLE_LABEL = "Shopping Cart";
    private final String PRODUCTS_LABEL = "Products";

    private final String CHECKOUT_BUTTON_LABEL = "Buy Product";
    private final String DELETE_BUTTON_LABEL = "Remove From Cart";

    private ShoppingCartState state = new ShoppingCartState();

    public ShoppingCartViewModel() {
        super("shopping cart");
    }

    public void setState(ShoppingCartState state) {
        this.state = state;
    }

    public ShoppingCartState getState() {
        return state;
    }
}
