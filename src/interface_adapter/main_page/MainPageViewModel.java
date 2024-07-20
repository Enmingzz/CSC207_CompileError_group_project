package interface_adapter.main_page;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainPageViewModel extends ViewModel {

    // Add all necessary constant labels for view as attributes here
    public final String TITLE_LABEL = "Products Page";

    private MainPageState state = new MainPageState();

    public MainPageViewModel() {
        super("main page");
    }

    public MainPageState getState() {
        return state;
    }

    public void setState(MainPageState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        System.out.println("MainPageViewModel firePropertyChanged");
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void initFirePropertyChanged() {
        support.firePropertyChange("init", null, this.state);
    }
}
