package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Manages the switching of views in a user interface using a CardLayout.
 * This class listens for property changes in the ViewManagerModel and updates the displayed view accordingly.
 */
public class ViewManager implements PropertyChangeListener {

    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewManager with the specified CardLayout, JPanel, and ViewManagerModel.
     *
     * @param views the JPanel containing the views managed by this ViewManager
     * @param cardLayout the CardLayout used to switch between views
     * @param viewManagerModel the model that provides view names and notifies property changes
     */
    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    /**
     * Handles property change events from the ViewManagerModel.
     * When the "view" property changes, this method updates the displayed view using CardLayout.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}
