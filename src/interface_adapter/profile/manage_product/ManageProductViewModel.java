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
    public final String DESCRIPTION_LABEL = "Description";
    public final String PRICE_LABEL = "Price";
    public final String STATE_LABEL = "State";
    public final String RATING_LABEL = "Rating";
    public final String EMAIL_LABEL = "TransferEmail";
    public final String ADDRESS_LABEL = "Address";
    public final String TAGS_LABEL = "Tags";
    public final String IMAGE_LABEL = "Image";
    public final String SELLERTIMES_LABEL = "Seller Schedules";
    public final String BUYERTIME_LABEL = "Buyer Schedule";

    public final String ADD_BUTTON_LABEL = "Add Product";
    public final String MODIFY_BUTTON_LABEL = "Modify";
    public final String DELETE_BUTTON_LABEL = "Delete Product";

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
