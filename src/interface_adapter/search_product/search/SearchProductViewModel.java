package interface_adapter.search_product.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SearchProductViewModel class manages the state of the search product view
 * and provides methods to update and listen to changes in the state.
 */
public class SearchProductViewModel extends ViewModel {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private SearchProductState state = new SearchProductState();

    /**
     * Constructs a SearchProductViewModel with the view name "search_product_view".
     */
    public SearchProductViewModel() {
        super("search_product_view");
    }

    public SearchProductState getState() {
        return state;
    }

    public void setState(SearchProductState state) {
        this.state = state;
    }

    /**
     * Fires a property change event to notify listeners that the state has changed.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }
}
