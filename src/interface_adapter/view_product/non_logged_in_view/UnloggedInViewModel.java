package interface_adapter.view_product.non_logged_in_view;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The UnloggedInViewModel class serves as the view model for the product view when the user is not logged in.
 * It manages the state and notifies listeners of any property changes.
 */
public class UnloggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Non-logged in Product View";
    public final String ADD_TO_CART = "Add to Shopping Cart";
    public final String INPUT_QUESTION_TITLE = "My New Question As Follows:";
    public final String VIEW_USER_PROFILE_BUTTON = "View Seller's Profile";

    public final String PRODUCTTITLE_LABEL = "Title";
    public final String PRICE_LABEL = "Price";
    public final String STATE_LABEL = "State";
    public final String RATING_LABEL = "Rating";
    public final String IMAGE_LABEL = "Image";
    public final String PRODUCTID_LABEL = "ProductID";
    public final String TRANSFEREMAIL_LABEL = "Transfer Email";
    public final String SELLERID_LABEL = "SellerID";
    public final String ADDRESS_LABEL = "Address";
    public final String LISTTAGS_LABEL = "Tags";
    public final String LISTSLEERTIMES_LABEL = "Seller Schedules";
    public final String BUYERTIME_LABEL = "Buyer Schedule";
    public final String DESCRIPTION_LABEL = "Description";

    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private UnloggedInState state = new UnloggedInState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs an UnloggedInViewModel with the specified view name.
     */
    public UnloggedInViewModel() {
        super("non login view product view");
    }

    /**
     * Sets the state of the view model.
     *
     * @param state the new state to set.
     */
    public void setState(UnloggedInState state) {
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
    public UnloggedInState getState() {
        return state;
    }
}
