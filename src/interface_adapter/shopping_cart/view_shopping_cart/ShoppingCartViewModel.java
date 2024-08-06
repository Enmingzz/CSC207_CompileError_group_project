package interface_adapter.shopping_cart.view_shopping_cart;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * ViewModel for the shopping cart view, responsible for holding the state of the shopping cart and notifying listeners of changes.
 */
public class ShoppingCartViewModel extends ViewModel {
    public final String TITLE_LABEL = "Shopping Cart";
    public final String PRODUCTS_LABEL = "Products";
    public final String PENDING_SELLER_SCHEDULE_LABEL = "Waiting for Seller to Choose schedule";
    public final String TOTAL_PRICE_LABEL = "Total Price";
    public String TOTAL_PRICE_VARIABLE = "";

    public final String CHECKOUT_BUTTON_LABEL = "Buy product";
    public final String DELETE_BUTTON_LABEL = "Remove From Cart";
    public final String BUYER_SCHEDULES_BUTTON_LABEL = "Choose Schedule";
    public final String RECEIVED_PRODUCT_BUTTON_LABEL = "I Have Received product";
    public final String RATE_PRODUCT_BUTTON_LABEL = "Rate product";

    //TODO: Need extra attributes for the top bar view model.

    private ShoppingCartState state = new ShoppingCartState();
    /**
     * Constructs a {@link ShoppingCartViewModel} with the view name set to "shopping cart".
     */
    public ShoppingCartViewModel() {
        super("shopping cart");
    }
    /**
     * Sets the state of the shopping cart.
     *
     * @param state the new state of the shopping cart
     */
    public void setState(ShoppingCartState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    /**
     * Notifies listeners that the state of the shopping cart has changed.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    /**
     * Adds a property change listener to listen for changes to the state of the shopping cart.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * Gets the current state of the shopping cart.
     *
     * @return the current state of the shopping cart
     */
    public ShoppingCartState getState() {
        return state;
    }
}
