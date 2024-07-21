package interface_adapter.view_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UnloggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Non-logged in product View";
    public final String ADD_TO_CART = "Add to shopping cart";
    public final String INPUT_QUESTION_TITLE = "My new question as follows:";
    public final String VIEW_USER_PROFILE_BUTTON = "View Seller's Profile";

    public final String PRODUCTTITLE_LABEL = "Title";
    public final String PRICE_LABEL = "Price";
    public final String STATE_LABEL = "State";
    public final String RATING_LABEL = "Rating";
    public final String IMAGE_LABEL = "Image";
    public final String PRODUCTID_LABEL = "ProductID";
    public final String TRANSFEREMAIL_LABEL = "TransferEmail";
    public final String SELLERID_LABEL = "SellerID";
    public final String ADDRESS_LABEL = "Address";
    public final String LISTTAGS_LABEL = "Tags";
    public final String LISTSLEERTIMES_LABEL = "SellerSchedules";
    public final String BUYERTIME_LABEL = "BuyerSchedule";
    public final String DESCRIPTION_LABEL = "Description";

    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private UnloggedInState state = new UnloggedInState();

    public UnloggedInViewModel(){
        super("non login view product view");
    }

    public  void setState(UnloggedInState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public UnloggedInState getState(){
        return state;
    }
}
