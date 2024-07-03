package interface_adapter.schedule;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SellerSelectScheduleViewModel extends ViewModel{
    private String sellerName;
    private String productId;
    private ArrayList<LocalDateTime> availableTimes;
    private boolean success;

    private PropertyChangeSupport support;

    public SellerSelectScheduleViewModel() {
        super("SellerSelectScheduleViewModel");
        this.support = new PropertyChangeSupport(this);
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ArrayList<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(ArrayList<LocalDateTime> availableTimes) {
        this.availableTimes = availableTimes;
        firePropertyChanged();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
        firePropertyChanged();
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("SellerSelectScheduleViewModel", null, this);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
