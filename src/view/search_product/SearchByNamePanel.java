package view.search_product;

import interface_adapter.search_product.SearchProductByNameController;
import entity.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByNamePanel extends JPanel {
    private final JTextField searchBox;
    private final JButton searchButton;

    public SearchByNamePanel(SearchProductByNameController searchByNameController) {
        searchBox = new JTextField(20);
        searchButton = new JButton("Search");

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(searchBox);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = searchBox.getText();
                searchByNameController.execute(new User(), productName);
            }
        });
    }
}
