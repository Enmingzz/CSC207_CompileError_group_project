package view.schedule;

import entity.product.Product;
import entity.user.User;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.schedule.SellerSelectScheduleController;
import interface_adapter.schedule.SellerSelectScheduleState;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class SellerScheduleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "seller_schedule";
    private SellerSelectScheduleController controller;
    private SellerSelectScheduleViewModel viewModel;
    private ViewProfileController viewProfileController;

    private GetSearchPageController getSearchPageController;
    private ViewSignupPageController viewSignupPageController;
    private ViewLoginPageController viewLoginPageController;
    private ShoppingCartController shoppingCartController;
    private LogOutController logOutController;

    private JComboBox<String> dateComboBox;
    private JComboBox<String> hourComboBox;
    private DefaultListModel<String> timesListModel;
    private JList<String> timesList;
    private JButton addButton;
    private JButton removeButton;
    private JButton submitButton;
    private JButton cancelButton;
    private DefaultListModel<LocalDateTime> listModel;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm");


    public SellerScheduleView(SellerSelectScheduleController controller,
                              SellerSelectScheduleViewModel viewModel,
                              ViewProfileController viewProfileController,
                              GetSearchPageController getSearchPageController,
                              ViewSignupPageController viewSignupPageController,
                              ViewLoginPageController viewLoginPageController,
                              ShoppingCartController shoppingCartController,
                              LogOutController logOutController) {
        this.controller = controller;
        this.viewModel = viewModel;
        this.viewProfileController = viewProfileController;

        // for top bar
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;

        viewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(viewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        dateComboBox = new JComboBox<>(getDates());
        hourComboBox = new JComboBox<>(getHours());

        JPanel dateTimePanel = new JPanel();
        dateTimePanel.setLayout(new FlowLayout());
        dateTimePanel.add(new JLabel("Date:"));
        dateTimePanel.add(dateComboBox);
        dateTimePanel.add(new JLabel("Hour:"));
        dateTimePanel.add(hourComboBox);

        timesListModel = new DefaultListModel<>();
        timesList = new JList<>(timesListModel);
        timesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel timesListPanel = new JPanel();
        timesListPanel.setLayout(new BorderLayout());
        timesListPanel.add(new JLabel("Scheduled Times:"), BorderLayout.NORTH);
        timesListPanel.add(new JScrollPane(timesList), BorderLayout.CENTER);

        addButton = new JButton(viewModel.ADD_BUTTON_LABEL);
        removeButton = new JButton(viewModel.REMOVE_BUTTON_LABEL);
        submitButton = new JButton(viewModel.CONFIRM_BUTTON_LABEL);
        cancelButton = new JButton(viewModel.CANCEL_BUTTON_LABEL);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(addButton)) {
                    String date = (String) dateComboBox.getSelectedItem();
                    String hour = (String) hourComboBox.getSelectedItem();
                    if (date != null && hour != null) {
                        LocalDateTime dateTime = LocalDateTime.parse(date + "T" + hour);
                        timesListModel.addElement(dateTime.format(dateTimeFormatter));
                    }
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(removeButton)) {
                    int selectedIndex = timesList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        timesListModel.remove(selectedIndex);
                    }
                }

            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(submitButton)) {
                    User seller = viewModel.getState().getSeller();
                    Product product = viewModel.getState().getProduct();
                    ArrayList<LocalDateTime> times = new ArrayList<>();
                    for (int i = 0; i < timesListModel.size(); i++) {
                        times.add(LocalDateTime.parse(timesListModel.getElementAt(i), dateTimeFormatter));
                    }
                    try {
                        controller.execute(seller, product, times);
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(cancelButton)) {
                    User seller = viewModel.getState().getSeller();
                    viewProfileController.execute(seller);
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(dateTimePanel);
        this.add(timesListPanel);
        this.add(buttonPanel);


    }

    private String [] getDates() {
        LocalDateTime now = LocalDateTime.now();
        return Stream.iterate(now, date -> date.plusDays(1))
                .limit(30)
                .map(date -> date.toLocalDate().toString())
                .toArray(String[]::new);
    }

    private String [] getHours() {
        return IntStream.range(8, 22) // Hours from 09:00 to 17:00
                .mapToObj(hour -> LocalTime.of(hour, 0).toString())
                .toArray(String[]::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SellerSelectScheduleState state = (SellerSelectScheduleState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError());
        }
        dateComboBox = new JComboBox<>(getDates());
        hourComboBox = new JComboBox<>(getHours());

    }
}
