package interface_adapter;

import java.beans.PropertyChangeListener;

/**
 * The abstract class for all ViewModel, every view models should be inherited from this class.
 * String viewName indicate the name of each view model.
 * provides two abstract method firePropertyChanged and addPropertyChangeListener.
 */

public abstract class ViewModel {
    private String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return this.viewName;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);

}