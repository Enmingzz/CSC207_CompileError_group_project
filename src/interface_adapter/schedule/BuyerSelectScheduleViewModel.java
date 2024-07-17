package interface_adapter.schedule;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;

/**
 * The BuyerSelectScheduleViewModel class manages the state of the buyer select schedule view
 * and provides methods to update and listen to changes in the state.
 */
public class BuyerSelectScheduleViewModel extends ViewModel {
    public final String TITLE_LABEL = "Select Schedule";
    public final String CONFIRM_BUTTON_LABEL = "Confirm Schedule";
    public final String CANCEL_BUTTON_LABEL = "Cancel";


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private BuyerSelectScheduleState state = new BuyerSelectScheduleState();

    /**
     * Constructs a BuyerSelectScheduleViewModel with the view name "buyer_schedule".
     */
    public BuyerSelectScheduleViewModel() {
        super("buyer_schedule");
    }

    public void setState(BuyerSelectScheduleState state) {
        this.state = state;
    }

    public BuyerSelectScheduleState getState() {
        return state;
    }

    /**
     * Fires a property change event to notify listeners that the state has changed.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
