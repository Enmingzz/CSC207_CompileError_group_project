package view.view_product;

import javax.swing.*;
import java.awt.*;
/**
 * This class represents a panel that displays a question and its corresponding answer along with a reply button.
 * It extends {@link JPanel} and is designed to hold two {@link JLabel} components for the question and answer,
 * as well as a {@link JButton} for replying.
 * <p>
 * This is particularly useful in UIs where displaying seller questions, answers, and providing a reply option in a structured format is needed.
 * </p>
 */
public class SellerQAInfoLabelTextPanel extends JPanel {

    /**
     * Constructs a new panel containing a question, an answer, and a reply button.
     * The panel uses a vertical box layout to arrange the components one below the other,
     * and a border is added around the panel.
     *
     * @param question the {@link JLabel} that contains the question text.
     * @param answer the {@link JLabel} that contains the answer text.
     * @param replyButton the {@link JButton} that allows the seller to reply to the question.
     */
    SellerQAInfoLabelTextPanel(JLabel question, JLabel answer, JButton replyButton){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.removeAll();
        this.add(question);
        this.add(answer);
        this.add(replyButton);
    }
}
