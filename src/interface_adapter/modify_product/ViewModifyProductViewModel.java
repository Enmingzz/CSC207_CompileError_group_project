package interface_adapter.modify_product;

import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the view that allows modification of a product.
 *
 * This class manages the state related to modifying a product and provides properties and methods
 * for interacting with the product's view. It also handles property change notifications to update
 * the view when the state changes.
 */
public class ViewModifyProductViewModel extends ViewModel {
    private final ProductFactory commonProductFactory = new CommonProductFactory();

    public final String TITLE_LABEL = "Product View";
    public final String PRODUCT_PICTURE = "Product image";
    public final String PRODUCT_TITLE_LABEL = "Product Title";
    public final String PRODUCT_DESCRIPTION_LABEL = "Product Description";
    public final String PRODUCT_PRICE_LABEL = "Product Price";
    public final String PRODUCT_ETRANSFER_EMAIL_LABEL = "Product eTransfer Email";
    public final String PRODUCT_ADDRESS = "Product Pickup Address";
    public final String PRODUCT_TAGS = "Product tags";

    public final String OLD_PRICE_LABEL = "Old-Price";
    public final String OLD_DESCRIPTION_LABEL = "Old-Description";
    public final String OLD_EMAIL_LABEL = "Old-TransferEmail";
    public final String OLD_TITLE_LABEL = "Old-Title";
    public final String OLD_ADDRESS_LABEL = "Old-Address";

    public final String CHANGEPRODUCT_BUTTON_LABEL = "Modify product";
    public final String CANCEL_BUTTON_LABEL = "Cancel";
    public final String UPDATE_IMAGE_BUTTON_LABEL = "Upload Image";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private ViewModifyProductState state = new ViewModifyProductState();

    /**
     * Constructs a ViewModifyProductViewModel with the view name set to "view modify product".
     */
    public ViewModifyProductViewModel() {
        super("view modify product");
    }

    /**
     * Gets the current state of the view.
     *
     * @return The current ViewModifyProductState.
     */
    public ViewModifyProductState getState() {
        return state;
    }

    /**
     * Sets the state of the view.
     *
     * @param state The new ViewModifyProductState to set.
     */
    public void setState(ViewModifyProductState state) {
        this.state = state;
    }

    /**
     * Notifies listeners that the state has changed.
     * This method is used to update the view when the state changes.
     */
    @Override
    public void firePropertyChanged() {
        System.out.println("view modify product view model fire property changed");
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to this ViewModel.
     *
     * @param listener The PropertyChangeListener to add.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
