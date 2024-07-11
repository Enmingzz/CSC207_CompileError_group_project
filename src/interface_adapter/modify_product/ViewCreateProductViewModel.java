package interface_adapter.modify_product;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class ViewCreateProductViewModel extends ViewModel {

    public final String TITLE_LABEL = "view create product";

    //TODO Complete this part by initiating all the required Strings

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
