package interface_adapter.view_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ReplyQuestionViewModel extends ViewModel {
    public final String TITLE_LABEL = "My answers are as follows:";
    public final String QUESTION_LABEL = "Question to be answered:";
    public final String ANSWER_LABEL = "Enter your answer here:";

    public final String REPLY_BUTTON_LABEL = "Reply";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    public ReplyQuestionViewModel(){
        super("reply question");
    }

    ReplyQuestionState state = new ReplyQuestionState();

    public void setState(ReplyQuestionState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public ReplyQuestionState getState(){
        return state;
    }

}
