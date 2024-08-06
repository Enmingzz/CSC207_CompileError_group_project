package view.schedule;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.schedule.seller_select_schedule.SellerSelectScheduleController;
import interface_adapter.schedule.seller_select_schedule.SellerSelectScheduleState;
import interface_adapter.schedule.seller_select_schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import view.TopBarSampleView;

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


/**
 * The SellerScheduleView class represents the UI for sellers to select and manage their available schedules.
 * It allows sellers to add, remove, and confirm available times, and provides navigation buttons.
 */
public class SellerScheduleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "seller_schedule";
    private final SellerSelectScheduleController controller;
    private final SellerSelectScheduleViewModel viewModel;
    private final ManageProductController manageProductController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private JComboBox<String> dateComboBox;
    private JComboBox<String> hourComboBox;
    private JPanel dateTimePanel;
    private DefaultListModel<String> timesListModel;
    private JList<String> timesList;
    private JPanel timesListPanel;
    private final JButton addButton;
    private final JButton removeButton;
    private final JButton submitButton;
    private final JButton cancelButton;
//    private DefaultListModel<LocalDateTime> listModel;
    private final DateTimeFormatter isoDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm");
    private JPanel topBar;


    /**
     * Constructs a SellerScheduleView with the specified controllers and view model.
     *
     * @param controller the controller for seller select schedule
     * @param viewModel the view model for seller select schedule
     * @param manageProductController the controller for managing products
     * @param getSearchPageController the controller for the search page
     * @param viewSignupPageController the controller for the signup page
     * @param viewLoginPageController the controller for the login page
     * @param shoppingCartController the controller for the shopping cart
     * @param logOutController the controller for logging out
     * @param viewProfileController the controller for the profile view
     * @param mainPageController the controller for the main page
     */
    public SellerScheduleView(SellerSelectScheduleController controller,
                              SellerSelectScheduleViewModel viewModel,
                              ManageProductController manageProductController,
                              GetSearchPageController getSearchPageController,
                              ViewSignupPageController viewSignupPageController,
                              ViewLoginPageController viewLoginPageController,
                              ShoppingCartController shoppingCartController,
                              LogOutController logOutController,
                              ViewProfileController viewProfileController,
                              MainPageController mainPageController) {
        this.controller = controller;
        this.viewModel = viewModel;
        this.manageProductController = manageProductController;

        // for top bar
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
//        this.add(topBar);

        viewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(viewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        dateComboBox = new JComboBox<>(getDates());
        hourComboBox = new JComboBox<>(getHours());

        dateTimePanel = new JPanel();
        dateTimePanel.setLayout(new FlowLayout());
        dateTimePanel.add(new JLabel("Date:"));
        dateTimePanel.add(dateComboBox);
        dateTimePanel.add(new JLabel("Hour:"));
        dateTimePanel.add(hourComboBox);

        timesListModel = new DefaultListModel<>();
        timesList = new JList<>(timesListModel);
        timesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        timesListPanel = new JPanel();
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
            /**
             * Handles the action event when the add button is clicked.
             * Adds the selected date and hour to the list of scheduled times.
             *
             * @param evt the action event
             */
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
            /**
             * Handles the action event when the remove button is clicked.
             * Removes the selected time from the list of scheduled times.
             *
             * @param evt the action event
             */
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
            /**
             * Handles the action event when the submit button is clicked.
             * Submits the selected times for the seller's schedule.
             *
             * @param evt the action event
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(submitButton)) {
                    User seller = viewModel.getState().getSeller();
                    Product product = viewModel.getState().getProduct();
                    ArrayList<LocalDateTime> times = new ArrayList<>();
                    for (int i = 0; i < timesListModel.size(); i++) {
                        String dateTimeStr = timesListModel.getElementAt(i);
                        // e.g., "July 19, 2024, 08:00"
                        // Parse it back to LocalDateTime using dateTimeFormatter
                        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter);
                        // Add the formatted LocalDateTime to the times list. e.g., 2024-07-19T08:00:00
                        times.add(LocalDateTime.parse(dateTime.format(isoDateTimeFormatter)));                    }
                    try {
                        controller.execute(seller, product, times);
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            /**
             * Handles the action event when the cancel button is clicked.
             * Navigates back to the manage product view.
             *
             * @param evt the action event
             */
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(cancelButton)) {
                    User seller = viewModel.getState().getSeller();
                    try {
                        manageProductController.execute(seller);
                    } catch (SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(title);
//        this.add(dateTimePanel);
//        this.add(timesListPanel);
//        this.add(buttonPanel);

        this.setLayout(new BorderLayout(1, 1));
        this.add(topBar, BorderLayout.NORTH);
        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
        schedulePanel.add(title);
        schedulePanel.add(dateTimePanel);
        schedulePanel.add(timesListPanel);
        schedulePanel.add(buttonPanel);
        this.add(schedulePanel, BorderLayout.CENTER);


    }

    /**
     * Generates an array of dates starting from today for the next 30 days.
     *
     * @return an array of date strings
     */
    private String [] getDates() {
        LocalDateTime now = LocalDateTime.now();
        return Stream.iterate(now, date -> date.plusDays(1))
                .limit(30)
                .map(date -> date.toLocalDate().toString())
                .toArray(String[]::new);
    }

    /**
     * Generates an array of hours from 8 AM to 9 PM.
     *
     * @return an array of hour strings
     */
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

        dateTimePanel.removeAll();
        dateComboBox = new JComboBox<>(getDates());
        hourComboBox = new JComboBox<>(getHours());
        dateTimePanel.setLayout(new FlowLayout());
        dateTimePanel.add(new JLabel("Date:"));
        dateTimePanel.add(dateComboBox);
        dateTimePanel.add(new JLabel("Hour:"));
        dateTimePanel.add(hourComboBox);
        dateTimePanel.repaint();
        dateTimePanel.revalidate();

        timesListPanel.removeAll();
        timesListModel = new DefaultListModel<>();
        timesList = new JList<>(timesListModel);
        timesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        timesListPanel.setLayout(new BorderLayout());
        timesListPanel.add(new JLabel("Scheduled Times:"), BorderLayout.NORTH);
        timesListPanel.add(new JScrollPane(timesList), BorderLayout.CENTER);
        timesListPanel.repaint();
        timesListPanel.revalidate();

        topBar.removeAll();
        topBar.add(new TopBarSampleView(viewModel.getState().getSeller(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();
    }
}
