package view.rate_product;

import interface_adapter.ViewModel;
import interface_adapter.rating.RateProductController;
import interface_adapter.rating.RateProductViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RateProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "view rate product";

    private final RateProductViewModel rateProductViewModel;
    private final JTextField ratingInputField = new JTextField(1);
    private final RateProductController rateProductController;

    private final JButton createRating;
    private final JButton cancel;
    //TODO figure out how cancel works and if anything extra is needed to be done in order to get cancel working

    public RateProductView(RateProductViewModel rateProductViewModel, RateProductController rateProductController) {
        this.rateProductViewModel = rateProductViewModel;
        this.rateProductController = rateProductController;

        rateProductViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(rateProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(signupViewModel.USERNAME_LABEL), ratingInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
