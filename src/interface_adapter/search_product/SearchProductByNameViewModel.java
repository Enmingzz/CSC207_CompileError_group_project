package interface_adapter.search_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class SearchProductByNameViewModel extends ViewModel {

    public SearchProductByNameViewModel() {
        super("search by name");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
