package interface_adapter.modify_product;

import entity.product.Product;
import entity.product.ProductFactory;
import entity.user.User;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeSupport;

public class ViewModifyProductState {
    private User user;
    private Product product;

    public ViewModifyProductState(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public ViewModifyProductState() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
