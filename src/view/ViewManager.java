package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Responsible for jumping page by listening the property changes.
 * It is initialized in the main class.
 * @author CompileError group
 */

public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }

    public void navigateToSchedule(String productId, String userName, boolean isBuyer) {
        viewManagerModel.setProductId(productId);
        if (isBuyer) {
            viewManagerModel.setBuyerName(userName);
            viewManagerModel.setActiveView("BuyerSelectScheduleViewModel");
        } else {
            viewManagerModel.setSellerName(userName);
            viewManagerModel.setActiveView("SellerSelectScheduleViewModel");
        }
        viewManagerModel.firePropertyChanged();
    }
}