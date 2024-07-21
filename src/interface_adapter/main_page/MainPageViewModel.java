package interface_adapter.main_page;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the main page, responsible for managing the state and notifying listeners of changes.
 */
public class MainPageViewModel extends ViewModel {

    // Add all necessary constant labels for view as attributes here
    public final String TITLE_LABEL = "Products Page";

    private MainPageState state = new MainPageState();

    /**
     * Constructs a {@link MainPageViewModel} with the specified view name.
     */
    public MainPageViewModel() {
        super("main page");
    }

    /**
     * Gets the current state of the main page.
     *
     * @return the current state
     */
    public MainPageState getState() {
        return state;
    }
    /**
     * Sets the state of the main page.
     *
     * @param state the new state to set
     */
    public void setState(MainPageState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    /**
     * Fires a property change event to notify listeners of state changes.
     */
    @Override
    public void firePropertyChanged() {
        System.out.println("MainPageViewModel firePropertyChanged");
        support.firePropertyChange("state", null, this.state);
    }
    /**
     * Adds a property change listener to listen for state changes.
     *
     * @param listener the listener to add
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * Fires an initial property change event to notify listeners.
     */
    public void initFirePropertyChanged() {
        support.firePropertyChange("init", null, this.state);
    }
}
