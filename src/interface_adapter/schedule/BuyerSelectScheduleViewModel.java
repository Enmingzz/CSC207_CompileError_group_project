package interface_adapter.schedule;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;

public class BuyerSelectScheduleViewModel extends ViewModel {
    public final String TITLE_LABEL = "Select Schedule for Pickup";
    public final String CONFIRM_BUTTON = "Confirm Schedule";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private LocalDateTime selectedTime;
    private boolean success;
    private final PropertyChangeSupport support;

    public BuyerSelectScheduleViewModel() {
        super("BuyerSelectScheduleViewModel");
        this.support = new PropertyChangeSupport(this);
    }

    public LocalDateTime getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(LocalDateTime selectedTime) {
        this.selectedTime = truncateToHour(selectedTime);
        firePropertyChanged();
    }

    private LocalDateTime truncateToHour(LocalDateTime time) {
        return time.withMinute(0).withSecond(0).withNano(0);
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
