package interface_adapter.profile.manage_product;

import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

    private ManageProductState manageProductState = new ManageProductState(productFactory);

    public ManageProductViewModel() {super("Product View");}

    public void setState(ManageProductState manageProductState) {
        this.manageProductState = manageProductState;
    }

    public ManageProductState getState() {
        return manageProductState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.manageProductState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
