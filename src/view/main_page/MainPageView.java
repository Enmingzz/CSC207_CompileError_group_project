package view.main_page;

import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.main_page.MainPageState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainPageView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "main page";

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
