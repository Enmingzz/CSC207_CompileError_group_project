package view.schedule;

import interface_adapter.schedule.BuyerSelectScheduleController;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BuyerScheduleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "buyer schedule";
    private BuyerSelectScheduleViewModel viewModel;
    private final BuyerSelectScheduleController controller;

    private JComboBox<LocalDateTime> availableTimesComboBox;
    private JButton selectButton;

    public BuyerScheduleView(BuyerSelectScheduleViewModel viewModel, BuyerSelectScheduleController controller) {
        this.viewModel = viewModel;
        this.controller = controller;

        initializeComponents();
        layoutComponents();
        registerListeners();

        viewModel.addPropertyChangeListener(this);
    }

    private void initializeComponents() {
        availableTimesComboBox = new JComboBox<>();
        selectButton = new JButton("Select Time");
    }

    private void layoutComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new JLabel("Please select a time for the schedule:"));
        mainPanel.add(availableTimesComboBox);

        add(mainPanel, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
    }

    private void registerListeners() {
        selectButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            LocalDateTime selectTime = (LocalDateTime) availableTimesComboBox.getSelectedItem();
            if (selectTime != null) {
                controller.execute(selectTime);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a time for the schedule:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("availableTimes")) {
            Object newValue = evt.getNewValue();
            if (newValue instanceof ArrayList<?> newList) {
                if (!newList.isEmpty() && newList.get(0) instanceof LocalDateTime) {
                    @SuppressWarnings("unchecked")
                    ArrayList<LocalDateTime> availableTimes = (ArrayList<LocalDateTime>) evt.getNewValue();
                    availableTimesComboBox.removeAllItems();
                    for (LocalDateTime availableTime : availableTimes) {
                        availableTimesComboBox.addItem(availableTime);
                    }
                }
            }
        }

    }
}
