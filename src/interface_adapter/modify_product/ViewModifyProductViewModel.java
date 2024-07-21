package interface_adapter.modify_product;

import entity.product.CommonProductFactory;
import entity.product.ProductFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
//TODO understand ALL code reference to ViewProfileViewModel

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

    public ViewModifyProductViewModel() {super("view modify product");}

    public ViewModifyProductState getState() {
        return state;
    }

    public void setState(ViewModifyProductState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}
