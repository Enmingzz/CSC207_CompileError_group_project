package interface_adapter.modify_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewModifyProductViewModel extends ViewModel {
    //TODO complete all required String initations

    private ViewModifyProductState state = new ViewModifyProductState();

    public ViewModifyProductViewModel() {super("view modify product");}

    public ViewModifyProductState getState() {
        return state;
    }

    public void setState(ViewModifyProductState state) {
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
