package interface_adapter.profile.manage_product;

import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for managing products in the user's profile, responsible for managing the state and notifying listeners of changes.
 */
public class ManageProductViewModel extends ViewModel {
    private final ProductFactory productFactory = new CommonProductFactory();

    public final String TITLE_LABEL = "Mange Product View";
    public final String PRODUCTTITLE_LABEL = "Title";
    public final String PRICE_LABEL = "Price";
    public final String STATE_LABEL = "State";
    public final String RATING_LABEL = "Rating";
    public final String IMAGE_LABEL = "Image";

    public final String ADD_BUTTON_LABEL = "Add Product";
    public final String MODIFY_BUTTON_LABEL = "Modify";
    public final String DELETE_BUTTON_LABEL = "Delete Product";
    public final String SHOW_BUTTON_LABEL = "Show Detail";
    public final String SELECTTIME_BUTTON_LABEL = "Scheduling Meeting Times";

    private ManageProductState manageProductState = new ManageProductState(productFactory);

    /**
     * Constructs a {@link ManageProductViewModel} with the specified view name.
     */
    public ManageProductViewModel() {super("Manage Product View");}

    /**
     * Sets the state of the manage product view model.
     *
     * @param manageProductState the new state to set
     */
    public void setState(ManageProductState manageProductState) {
        this.manageProductState = manageProductState;
    }

    /**
     * Gets the current state of the manage product view model.
     *
     * @return the current state
     */
    public ManageProductState getState() {
        return manageProductState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify listeners of state changes.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.manageProductState);
    }

    /**
     * Adds a property change listener to listen for state changes.
     *
     * @param listener the listener to add
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
