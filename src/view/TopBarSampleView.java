package view;

import entity.user.User;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.view_product.BuyerViewProductState;
import view.view_product.BuyerViewProductView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TopBarSampleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "top bar sample view";

    private final JButton searchButton;


    public TopBarSampleView(User user, GetSearchPageController getSearchPageController) {


        class SearchButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(searchButton)){
                    try{
                        getSearchPageController.execute(user);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        searchButton.addActionListener(new SearchButtonListener());
        this.add(searchButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
