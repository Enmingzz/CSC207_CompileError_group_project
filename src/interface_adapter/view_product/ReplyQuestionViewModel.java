package interface_adapter.view_product;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The ReplyQuestionViewModel class serves as the view model for replying to a question.
 * It manages the state and notifies listeners of any property changes.
 */
public class ReplyQuestionViewModel extends ViewModel {
    public final String TITLE_LABEL = "My answers are as follows:";
    public final String QUESTION_LABEL = "Question you are answering:";
    public final String REPLY_BUTTON_LABEL = "Reply";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private ReplyQuestionState state = new ReplyQuestionState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a ReplyQuestionViewModel with the specified view name.
     */
    public ReplyQuestionViewModel() {
        super("reply question");
    }

    /**
     * Sets the state of the view model.
     *
     * @param state the new state to set.
     */
    public void setState(ReplyQuestionState state) {
        this.state = state;
    }

    /**
     * Fires a property change event to notify listeners of a state change.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener the listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Returns the current state of the view model.
     *
     * @return the current state.
     */
    public ReplyQuestionState getState() {
        return state;
    }
}
