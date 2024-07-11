package view.schedule;

import interface_adapter.schedule.SellerSelectScheduleController;
import interface_adapter.schedule.SellerSelectScheduleState;
import interface_adapter.schedule.SellerSelectScheduleViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SellerScheduleView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "seller_schedule";
    private final SellerSelectScheduleController controller;

    private JList<LocalDateTime> availableTimesList;
    private JButton addButton;
    private JButton removeButton;
    private JButton submitButton;
    private DefaultListModel<LocalDateTime> listModel;

    public SellerScheduleView(SellerSelectScheduleController controller, SellerSelectScheduleViewModel viewModel) {
        this.controller = controller;

        initializeComponents();
        layoutComponents();
        registerListeners();

        viewModel.addPropertyChangeListener(this);
    }

    private void initializeComponents() {
        listModel = new DefaultListModel<>();
        availableTimesList = new JList<>(listModel);
        availableTimesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addButton = new JButton("Add Time");
        removeButton = new JButton("Remove Time");
        submitButton = new JButton("Submit Times");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(submitButton);

        add(new JScrollPane(availableTimesList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
    }

    private void registerListeners() {
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            LocalDateTime newTime = promptForTime();
            if (newTime != null) {
                listModel.addElement(newTime);
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = availableTimesList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        } else if (e.getSource() == submitButton) {
            ArrayList<LocalDateTime> times = new ArrayList<>();
            for (int i = 0; i < listModel.size(); i++) {
                times.add(listModel.getElementAt(i));
            }
            controller.selectSchedule(times);
        }

    }

    private LocalDateTime promptForTime() {
        // Use a date-time picker dialog to get the date and time from the seller
        // TODO

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SellerSelectScheduleState state = (SellerSelectScheduleState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError());
        }

    }
}
