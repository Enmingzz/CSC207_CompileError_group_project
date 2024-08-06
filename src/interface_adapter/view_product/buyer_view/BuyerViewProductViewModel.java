package interface_adapter.view_product.buyer_view;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The BuyerViewProductViewModel class serves as the view model for the buyer's view of a product.
 * It manages the state and notifies listeners of any property changes.
 */
public class BuyerViewProductViewModel extends ViewModel {
    public final String TITLE_LABEL = "Buyer Product View";
    public final String ADD_QUESTION = "Publish Question";
    public final String ADD_TO_CART = "Add to Shopping Cart";
    public final String INPUT_QUESTION_TITLE = "My new question as follows:";
    public final String VIEW_USER_PROFILE_BUTTON = "View Seller's Profile";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private BuyerViewProductState state = new BuyerViewProductState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a BuyerViewProductViewModel with the specified view name.
     */
    public BuyerViewProductViewModel() {
        super("buyer_view_product view");
    }

    /**
     * Sets the state of the view model.
     *
     * @param state the new state to set.
     */
    public void setState(BuyerViewProductState state) {
        this.state = state;
    }

    /**
     * Fires a property change event to notify listeners of a state change.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener the listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Returns the current state of the view model.
     *
     * @return the current state.
     */
    public BuyerViewProductState getState() {
        return state;
    }
}
