package interface_adapter.view_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Non_loggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Non-logged in product View";
    public final String ADD_TO_CART = "Add to shopping cart";
    public final String INPUT_QUESTION_TITLE = "My new question as follows:";

    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private Non_loggedInState state = new Non_loggedInState();

    public Non_loggedInViewModel(){
        super("modify_product view");
    }

    public  void setState(Non_loggedInState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public Non_loggedInState getState(){
        return state;
    }
}
