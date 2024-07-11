package view.search_product;

import interface_adapter.main_page.MainPageController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchByTagPanel extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "search by tag";


    private final MainPageController mainPageController;

    public SearchByTagPanel(MainPageController mainPageController) {
        this.mainPageController = mainPageController;

        //TODO implements this method
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
