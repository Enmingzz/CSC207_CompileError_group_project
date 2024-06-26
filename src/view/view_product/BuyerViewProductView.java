package view.view_product;

import entity.comment.Answer;
import entity.comment.CommonQuestionFactory;
import entity.comment.Question;
import entity.comment.QuestionFactory;
import entity.product.Product;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.sql.SQLException;
import java.util.ArrayList;

public class BuyerViewProductView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "buyer_view_product view";// useless??
    private final BuyerViewProductViewModel buyerViewProductViewModel;

    final JTextField questionInputField = new JTextField(15);

//    private final JLabel image = new JLabel();
//    private final JLabel description = new JLabel();
//    private final JLabel price = new JLabel();
//    private final JLabel _title = new JLabel();
//    private final JLabel rating = new JLabel();
//    private final JLabel state = new JLabel();
//    private final JLabel address = new JLabel();
//    private final JLabel lstTags = new JLabel();
//    private final JLabel productID = new JLabel();


    private final JLabel questionPublishSucceedField = new JLabel();// how to pop up the prompt words?

    private final JButton cancel;
    private final JButton addToCart;
    private final JButton publishQuestion;

    private final AddToCartController addToCartController;
    private final PublishQuestionController publishQuestionController;

//    private final JPanel qAInfoTextPanel;


    public BuyerViewProductView(BuyerViewProductViewModel buyerViewProductViewModel,
                                AddToCartController addToCartController, PublishQuestionController publishQuestionController){
        this.buyerViewProductViewModel = buyerViewProductViewModel;
        this.addToCartController = addToCartController;
        this.publishQuestionController = publishQuestionController;

        this.buyerViewProductViewModel.addPropertyChangeListener(this);

        ArrayList<Question> lst_question = buyerViewProductViewModel.getState().getQuestion();

        JLabel title = new JLabel(buyerViewProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //(1)product_info
        final JLabel image = new JLabel();
        final JLabel description = new JLabel();
        final JLabel price = new JLabel();
        final JLabel _title = new JLabel();
        final JLabel rating = new JLabel();
        final JLabel state = new JLabel();
        final JLabel address = new JLabel();
        final JLabel lstTags = new JLabel();
        final JLabel productID = new JLabel();

        ProductInfoLabelTextPanel productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
                lstTags, productID);


        //(2)q_and_a
        final JPanel qAInfoTextPanel = new JPanel();
        for (Question question : lst_question) {

            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);

            BuyerQAInfoLabelTextPanel panel = new BuyerQAInfoLabelTextPanel(q, a);
            qAInfoTextPanel.add(panel);
        }
        JLabel input_question_title = new JLabel(buyerViewProductViewModel.INPUT_QUESTION_TITLE);
        qAInfoTextPanel.add(input_question_title);


        //(3)buttons
        JPanel buttons = new JPanel();
        cancel = new JButton(buyerViewProductViewModel.CANCEL_BUTTON_LABEL);
        addToCart = new JButton(buyerViewProductViewModel.ADD_TO_CART);
        publishQuestion = new JButton(buyerViewProductViewModel.ADD_QUESTION);

        buttons.add(cancel);
        buttons.add(addToCart);
        buttons.add(publishQuestion);


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
            @Override
            public void keyTyped(KeyEvent event){
                BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
                String question_content = questionInputField.getText() + event.getKeyChar();

                CommonQuestionFactory questionFactory = new CommonQuestionFactory();
                Question newquestion = questionFactory.createQuestion(question_content,
                        buyerViewProductViewModel.getState().getProduct().getSellerStudentNumber(), null);
                ArrayList<Question> lst_question = buyerViewProductViewModel.getState().getQuestion();
                lst_question.add(newquestion);

                buyerViewProductState.setLst_question(lst_question);
                buyerViewProductViewModel.setState(buyerViewProductState);
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        }

        class QuestionPublishButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(publishQuestion)){
                    try{
                        Product que_product = buyerViewProductViewModel.getState().getProduct();

                        String question_content = questionInputField.getText();
                        CommonQuestionFactory questionFactory = new CommonQuestionFactory();
                        Question new_question = questionFactory.createQuestion(question_content,
                                buyerViewProductViewModel.getState().getProduct().getSellerStudentNumber(), null);

                        publishQuestionController.execute(new_question, que_product);
                    }catch (SQLException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }


        class CancelButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(cancel)){
                    try{
                       // System.out.println(buyerViewProductViewModel.getState().getPrompt_words());
                        //jump to the main page? or the former page( can be shopping_cart or the main page,
                        // whichever gives us the nearest page?)
                    }catch (SQLException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }


        addToCart.addActionListener(new AddTtoCartButtonListener());
        questionInputField.addKeyListener(new QuestionInputKeyListener());
        publishQuestion.addActionListener(new QuestionPublishButtonListener());
        cancel.addActionListener(new CancelButtonListener());

        // needs adjustments x,y axis?????
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(productInfo);
        this.add(qAInfoTextPanel);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
