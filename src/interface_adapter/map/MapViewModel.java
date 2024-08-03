package interface_adapter.map;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MapViewModel extends ViewModel {
    private MapState state = new MapState();

    public MapViewModel(){super("map view");}

    public MapState getMapState() {return state;}

    public void setMapState(MapState mapState) {this.state = mapState;}

    PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
