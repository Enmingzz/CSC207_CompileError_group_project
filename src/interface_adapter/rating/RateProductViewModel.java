package interface_adapter.rating;

import interface_adapter.ViewModel;
import interface_adapter.modify_product.CreateProductState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RateProductViewModel extends ViewModel {
    public final String TITLE_LABEL = "Rate Product";
    public final String PRODUCT_IMAGE = "Product image";
    public final String PRODUCT_TITLE_LABEL = "Product Title";

    public final String PRODUCT_RATING_LABEL = "Rate the product";
    public final String CREATE_RATING_BUTTON_LABEL = "Complete Rating";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private RateProductState state = new RateProductState();

    public RateProductViewModel() {
        super("view rate product");
    }

    public RateProductState getState() {
        return state;
    }

    public void setState(RateProductState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
