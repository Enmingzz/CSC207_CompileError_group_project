package interface_adapter.search_product;

import interface_adapter.ViewModel;
import entity.product.Product;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;



public class SearchProductByTagViewModel extends ViewModel {
    private List<Product> products;
    private final PropertyChangeSupport support;

    public SearchProductByTagViewModel() {
        super("search by tag");
        this.support = new PropertyChangeSupport(this);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        firePropertyChanged();
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("products", null, this.products);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
