package interface_adapter.rating;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the RateProduct view. Contains state and labels for the view.
 */
public class RateProductViewModel extends ViewModel {
    public final String TITLE_LABEL = "Rate Product";
    public final String PRODUCT_IMAGE = "Product image";
    public final String PRODUCT_TITLE_LABEL = "Product Title";

    public final String PRODUCT_RATING_LABEL = "Rate the product";
    public final String CREATE_RATING_BUTTON_LABEL = "Complete Rating";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private RateProductState state = new RateProductState();

    /**
     * Constructs a RateProductViewModel with a default view name.
     */
    public RateProductViewModel() {
        super("view rate product");
    }

    /**
     * Gets the current state of the RateProductViewModel.
     *
     * @return The current RateProductState.
     */
    public RateProductState getState() {
        return state;
    }

    /**
     * Sets the state of the RateProductViewModel.
     *
     * @param state The new RateProductState.
     */
    public void setState(RateProductState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies all listeners that the state property has changed.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to the listener list.
     *
     * @param listener The PropertyChangeListener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
