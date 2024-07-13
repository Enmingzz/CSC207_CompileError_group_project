package interface_adapter.modify_product;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class ViewCreateProductViewModel extends ViewModel {

    public final String TITLE_LABEL = "view create product";
    public final String PRODUCT_IMAGE = "Product image";
    public final String PRODUCT_TITLE_LABEL = "Product Title";
    public final String PRODUCT_DESCRIPTION_LABEL = "Product Description";
    public final String PRODUCT_PRICE_LABEL = "Product Price";
    public final String PRODUCT_ETRANSFER_EMAIL_LABEL = "Product eTransfer Email";
    public final String PRODUCT_ADDRESS = "Product Pickup Address";
    public final String PRODUCT_TAGS = "Product tags";

    public final String CREATE_PRODUCT_BUTTON_LABEL = "Create Product";


    private CreateProductState state = new CreateProductState();

    public ViewCreateProductViewModel() {
        super("view create product");
    }


    public CreateProductState getState() {
        return state;
    }

    public void setState(CreateProductState state) {
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
