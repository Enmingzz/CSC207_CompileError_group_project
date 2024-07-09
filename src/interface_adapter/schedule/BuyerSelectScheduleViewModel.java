package interface_adapter.schedule;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;

public class BuyerSelectScheduleViewModel extends ViewModel {
    public final String TITLE_LABEL = "Select Schedule";
    public final String CONFIRM_BUTTON_LABEL = "Confirm Schedule";
    public final String CANCEL_BUTTON_LABEL = "Cancel";


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private BuyerSelectScheduleState state = new BuyerSelectScheduleState();

    public BuyerSelectScheduleViewModel() {
        super("buyer_schedule");
    }

    public void setState(BuyerSelectScheduleState state) {
        this.state = state;
    }

    public BuyerSelectScheduleState getState() {
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
