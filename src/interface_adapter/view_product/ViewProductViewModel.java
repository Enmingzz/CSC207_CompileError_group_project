package interface_adapter.view_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewProductViewModel extends ViewModel {
    public final String TITLE_LABEL = "Product View";
    public final String ADD_QUESTION = "add question";

    public final String ADD_ANSWER = "add answer";
    public final String CANCEL_BUTTON_LABEL = "cancel";

    private ViewProductState state = new ViewProductState();

    public ViewProductViewModel(){
        super("modify_product view");
    }

    public  void setState(ViewProductState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public ViewProductState getState(){
        return state;
    }

}
