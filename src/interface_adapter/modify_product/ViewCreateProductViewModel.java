package interface_adapter.modify_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for managing the state of the view used to create a product.
 *
 * This view model holds the state related to product creation and provides
 * properties and methods to manage and notify changes in this state.
 */
public class ViewCreateProductViewModel extends ViewModel {

    public final String TITLE_LABEL = "view create product";
    public final String PRODUCT_IMAGE = "Product image";
    public final String PRODUCT_TITLE_LABEL = "Product Title";
    public final String PRODUCT_DESCRIPTION_LABEL = "Product Description";
    public final String PRODUCT_PRICE_LABEL = "Product Price";
    public final String PRODUCT_ETRANSFER_EMAIL_LABEL = "Product eTransfer Email";
    public final String PRODUCT_ADDRESS_LABEL = "Product Pickup Address";
    public final String PRODUCT_TAGS_LABEL = "Product tags";

    public final String CREATE_PRODUCT_BUTTON_LABEL = "Create Product";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private CreateProductState state = new CreateProductState();

    /**
     * Constructs a ViewCreateProductViewModel with a predefined view name.
     */
    public ViewCreateProductViewModel() {
        super("view create product");
    }

    /**
     * Gets the current state of the create product view.
     *
     * @return The current state of the view.
     */
    public CreateProductState getState() {
        return state;
    }

    /**
     * Sets the state of the create product view.
     *
     * @param state The new state to be set.
     */
    public void setState(CreateProductState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners of changes to the state of the view.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to be notified of changes.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
