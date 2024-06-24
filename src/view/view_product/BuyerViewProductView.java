package view.view_product;

import entity.comment.Answer;
import entity.comment.CommonQuestionFactory;
import entity.comment.Question;
import entity.comment.QuestionFactory;
import interface_adapter.view_product.AddToCartController;
import interface_adapter.view_product.BuyerViewProductState;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.PublishQuestionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;

public class BuyerViewProductView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "buyer_view_product view";
    private final BuyerViewProductViewModel buyerViewProductViewModel;

    final JTextField questionInputField = new JTextField(15);

    private JLabel image = new JLabel();
    private JLabel description = new JLabel();
    private JLabel price = new JLabel();
    private JLabel _title = new JLabel();
    private JLabel rating = new JLabel();
    private JLabel state = new JLabel();
    private JLabel address = new JLabel();
    private JLabel lstTags = new JLabel();
    private JLabel productID = new JLabel();


    private JLabel questionPublishSucceedField = new JLabel();

    private JButton cancel;
    private JButton addToCart;

    private AddToCartController addToCartController;
    private PublishQuestionController publishQuestionController;

    private JPanel qAInfoTextPanel;


    public BuyerViewProductView(BuyerViewProductViewModel buyerViewProductViewModel){
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.buyerViewProductViewModel.addPropertyChangeListener(this);

        ArrayList<Question> lst_question = buyerViewProductViewModel.getState().getQuestion();

        JLabel title = new JLabel("Buyer View Product State");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        ProductInfoLabelTextPanel productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
                lstTags, productID);


        for(int i = 0; i < lst_question.size(); i++){

            Question question = lst_question.get(i);
            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);

            BuyerQAInfoLabelTextPanel panel = new BuyerQAInfoLabelTextPanel(q, a);
            qAInfoTextPanel.add(panel);
        }

        JPanel buttons = new JPanel();
        cancel = new JButton(buyerViewProductViewModel.CANCEL_BUTTON_LABEL);
        addToCart = new JButton(buyerViewProductViewModel.ADD_TO_CART);

        buttons.add(cancel);
        buttons.add(addToCart);

        class AddTtoCartButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(addToCart)){
                    try {
                        addToCartController.execute(buyerViewProductViewModel.getState().getUser(),
                                buyerViewProductViewModel.getState().getProduct());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        class QuestionInputKeyListener implements KeyListener{
            public void keyTyped(KeyEvent event){
                BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
                QuestionFactory questionFactory = new CommonQuestionFactory();

                buyerViewProductState.setLst_question(questionInputField.getText() + event.getKeyChar());
                buyerViewProductViewModel.setState(buyerViewProductState);
            }

        }

        addToCart.addActionListener(new AddTtoCartButtonListener());

        questionInputField.addActionListener(new );


    }

}
