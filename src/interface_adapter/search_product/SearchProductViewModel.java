package interface_adapter.search_product;

import interface_adapter.ViewModel;
import entity.product.Product;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class SearchProductViewModel extends ViewModel {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private SearchProductState state = new SearchProductState();

    public SearchProductViewModel() {
        super("search_product_view");
    }

    public SearchProductState getState() {
        return state;
    }

    public void setState(SearchProductState state) {
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
