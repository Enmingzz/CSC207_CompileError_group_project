package interface_adapter.schedule;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SellerSelectScheduleViewModel extends ViewModel{
    public final String TITLE_LABEL = "Select Available Times";
    public final String ADD_BUTTON_LABEL = "Add";
    public final String REMOVE_BUTTON_LABEL = "Remove";
    public final String CONFIRM_BUTTON_LABEL = "Confirm";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private String sellerName;
    private String productId;
    private ArrayList<LocalDateTime> availableTimes;
    private boolean success;
    private SellerSelectScheduleState state = new SellerSelectScheduleState();


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SellerSelectScheduleViewModel() {
        super("seller_schedule");
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

    public void setState(SellerSelectScheduleState state) {
        this.state = state;
    }

    public SellerSelectScheduleState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
