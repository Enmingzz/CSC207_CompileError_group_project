package interface_adapter.view_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SellerViewProductViewModel extends ViewModel {
    public final String TITLE_LABEL = "Seller product View";
    public final String QUESTION_LABEL = "Questions";

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