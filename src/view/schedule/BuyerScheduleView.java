package view.schedule;

import entity.product.Product;
import entity.user.User;
import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.schedule.BuyerSelectScheduleState;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;


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

public class BuyerScheduleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "buyer_schedule";

    private BuyerSelectScheduleViewModel viewModel;
    private BuyerSelectScheduleController controller;
    private ShoppingCartController shoppingCartController;

    private JComboBox<LocalDateTime> availableTimesComboBox;
    private final JButton selectButton;
    private final JButton cancelButton;

    public BuyerScheduleView(BuyerSelectScheduleViewModel viewModel,
                             BuyerSelectScheduleController controller,
                             ShoppingCartController shoppingCartController) {
        this.viewModel = viewModel;
        this.controller = controller;
        this.shoppingCartController = shoppingCartController;
        viewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(viewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        selectButton = new JButton(viewModel.CONFIRM_BUTTON_LABEL);
        buttons.add(selectButton);
        cancelButton = new JButton(viewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancelButton);

        availableTimesComboBox = new JComboBox<>();
        ArrayList<LocalDateTime> availableTimes = viewModel.getState().getProduct().getSchedule().getSellerTime();
        for (LocalDateTime time : availableTimes) {
            availableTimesComboBox.addItem(time);
        }

        selectButton.addActionListener(
                new ActionListener() {
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(new JLabel("Available Times:"));
        this.add(availableTimesComboBox);
        this.add(buttons);


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
    }
}
