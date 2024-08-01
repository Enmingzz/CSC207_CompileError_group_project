package view.schedule;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.schedule.BuyerSelectScheduleState;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
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
import java.util.ArrayList;

/**
 * The BuyerScheduleView class represents the UI for selecting a schedule as a buyer.
 * It displays available times, allows selection of a time, and provides buttons to confirm or cancel the selection.
 */
public class BuyerScheduleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "buyer_schedule";

    private BuyerSelectScheduleViewModel viewModel;
    private  BuyerSelectScheduleController controller;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private JComboBox<LocalDateTime> availableTimesComboBox;
    private final JButton selectButton;
    private final JButton cancelButton;
    private JPanel topBar;
    private JPanel timeSelectPanel;

    /**
     * Constructs a BuyerScheduleView with the specified view model, controller, and top bar controllers.
     *
     * @param viewModel the view model for buyer select schedule
     * @param controller the controller for buyer select schedule
     * @param shoppingCartController the controller for the shopping cart
     * @param getSearchPageController the controller for the search page
     * @param viewSignupPageController the controller for the signup page
     * @param viewLoginPageController the controller for the login page
     * @param logOutController the controller for logging out
     * @param viewProfileController the controller for the profile view
     * @param mainPageController the controller for the main page
     */
    public BuyerScheduleView(BuyerSelectScheduleViewModel viewModel,
                             BuyerSelectScheduleController controller,
                             ShoppingCartController shoppingCartController,
                             GetSearchPageController getSearchPageController,
                             ViewSignupPageController viewSignupPageController,
                             ViewLoginPageController viewLoginPageController,
                             LogOutController logOutController,
                             ViewProfileController viewProfileController,
                             MainPageController mainPageController) {
        this.viewModel = viewModel;
        this.controller = controller;
        this.shoppingCartController = shoppingCartController;

        // for top bar
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
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

        JPanel buttons = new JPanel();
        selectButton = new JButton(viewModel.CONFIRM_BUTTON_LABEL);
        buttons.add(selectButton);
        cancelButton = new JButton(viewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancelButton);

        timeSelectPanel = new JPanel();
        timeSelectPanel.setLayout(new FlowLayout());
        timeSelectPanel.add(new JLabel("Please select a time for meeting the seller: "));
        availableTimesComboBox = new JComboBox<>();
        if (viewModel.getState().getProduct() != null){
            ArrayList<LocalDateTime> availableTimes = viewModel.getState().getProduct().getSchedule().getSellerTime();
            for (LocalDateTime time : availableTimes) {
                availableTimesComboBox.addItem(time);
            }
        }
        timeSelectPanel.add(availableTimesComboBox);


        selectButton.addActionListener(
                new ActionListener() {
                    /**
                     * Handles the action event when the select button is clicked.
                     *
                     * @param evt the action event
                     */
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(selectButton)) {
                            User buyer = viewModel.getState().getBuyer();
                            Product product = viewModel.getState().getProduct();
                            LocalDateTime selectedTime = (LocalDateTime) availableTimesComboBox.getSelectedItem();
                            try {
                                controller.execute(buyer, product, selectedTime);
                            } catch (SQLException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );

        cancelButton.addActionListener(
                new ActionListener() {
                    /**
                     * Handles the action event when the cancel button is clicked.
                     * Navigates back to the shopping cart view
                     *
                     * @param evt the action event
                     */
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancelButton)) {
                            User buyer = viewModel.getState().getBuyer();
                            try {
                                shoppingCartController.execute(buyer);
                            } catch (SQLException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );

//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout(1, 1));
        this.add(topBar, BorderLayout.NORTH);
        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
        schedulePanel.add(title);
        schedulePanel.add(timeSelectPanel);
        schedulePanel.add(buttons);
        this.add(schedulePanel, BorderLayout.CENTER);

//        this.add(title);
//        this.add(timeSelectPanel);
//        this.add(buttons);


    }


    @Override
    public void actionPerformed(ActionEvent evt) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        BuyerSelectScheduleState state = (BuyerSelectScheduleState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError());
        }

        timeSelectPanel.removeAll();
        timeSelectPanel.setLayout(new FlowLayout());
        timeSelectPanel.add(new JLabel("Please select a time for meeting the seller: "));
        availableTimesComboBox = new JComboBox<>();
        ArrayList<LocalDateTime> availableTimes = state.getProduct().getSchedule().getSellerTime();
        for (LocalDateTime time : availableTimes) {
            availableTimesComboBox.addItem(time);
        }
        timeSelectPanel.add(availableTimesComboBox);
        timeSelectPanel.repaint();
        timeSelectPanel.revalidate();

        topBar.removeAll();
        topBar.add(new TopBarSampleView(viewModel.getState().getBuyer(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();
    }
}
