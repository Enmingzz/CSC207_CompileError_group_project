package interface_adapter.shopping_cart;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShoppingCartViewModel extends ViewModel {
    public final String TITLE_LABEL = "Shopping Cart";
    public final String PRODUCTS_LABEL = "Products";
    public final String PENDING_SELLER_SCHEDULE_LABEL = "Waiting for Buyer to Choose schedule";
    public final String TOTAL_PRICE_LABEL = "Total Price";
    public String TOTAL_PRICE_VARIABLE = "";

    public final String CHECKOUT_BUTTON_LABEL = "Buy Product";
    public final String DELETE_BUTTON_LABEL = "Remove From Cart";
    public final String BUYER_SCHEDULES_BUTTON_LABEL = "Choose Schedule";
    public final String RECEIVED_PRODUCT_BUTTON_LABEL = "I Have Received Product";

    //TODO: Need extra attributes for the top bar view model.

    private ShoppingCartState state = new ShoppingCartState();

    public ShoppingCartViewModel() {
        super("shopping cart");
    }

    public void setState(ShoppingCartState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ShoppingCartState getState() {
        return state;
    }
}
