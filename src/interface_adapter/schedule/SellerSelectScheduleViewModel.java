package interface_adapter.schedule;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The SellerSelectScheduleViewModel class manages the state of the seller select schedule view
 * and provides methods to update and listen to changes in the state.
 */
public class SellerSelectScheduleViewModel extends ViewModel{
    public final String TITLE_LABEL = "Select Available Times";
    public final String ADD_BUTTON_LABEL = "Add";
    public final String REMOVE_BUTTON_LABEL = "Remove";
    public final String CONFIRM_BUTTON_LABEL = "Confirm";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private SellerSelectScheduleState state = new SellerSelectScheduleState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a SellerSelectScheduleViewModel with the view name "seller_schedule".
     */
    public SellerSelectScheduleViewModel() {
        super("seller_schedule");
    }

    public void setState(SellerSelectScheduleState state) {
        this.state = state;
    }

    public SellerSelectScheduleState getState() {
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
