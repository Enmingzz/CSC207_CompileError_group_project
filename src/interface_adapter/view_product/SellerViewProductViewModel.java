package interface_adapter.view_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SellerViewProductViewModel extends ViewModel {
    public final String TITLE_LABEL = "Seller product View";
    public final String QUESTION_LABEL = "Questions";

    public final String ADD_ANSWER = "Reply question";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private SellerViewProductState state = new SellerViewProductState();

    public SellerViewProductViewModel(){
        super("seller_view_product view");
    }

    public  void setState(SellerViewProductState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public SellerViewProductState getState(){
        return state;
    }

}