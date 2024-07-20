package view.view_product;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a panel that displays a question and its corresponding answer as labels.
 * It extends {@link JPanel} and is designed to hold two {@link JLabel} components:
 * one for the question and one for the answer.
 * <p>
 * This is particularly useful in UIs where displaying buyer questions and answers in a structured format is needed.
 * </p>
 */

public class BuyerQAInfoLabelTextPanel extends JPanel {
    /**
     * Constructs a new panel containing a question and an answer label.
     *
     * @param question the {@link JLabel} that contains the question text.
     * @param answer the {@link JLabel} that contains the answer text.
     */
//    BuyerQAInfoLabelTextPanel(JLabel question, JLabel answer){
//        this.add(question);
//        this.add(answer);
//    }

    BuyerQAInfoLabelTextPanel(JLabel question, JLabel answer){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.removeAll();
        this.add(question);
        this.add(answer);
    }
}
