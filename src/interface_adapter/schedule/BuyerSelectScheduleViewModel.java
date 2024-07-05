package interface_adapter.schedule;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;

public class BuyerSelectScheduleViewModel extends ViewModel {
    private String buyerName;
    private String productId;
    private LocalDateTime selectedTime;
    private boolean success;
    private PropertyChangeSupport support;

    public BuyerSelectScheduleViewModel() {
        super("BuyerSelectScheduleViewModel");
        this.support = new PropertyChangeSupport(this);
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LocalDateTime getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(LocalDateTime selectedTime) {
        this.selectedTime = selectedTime;
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
        support.firePropertyChange("BuyerSelectScheduleViewModel", null, this);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
