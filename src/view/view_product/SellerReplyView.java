package view.view_product;

import entity.comment.CommonQuestionFactory;
import entity.comment.Question;
import entity.product.Product;
import interface_adapter.view_product.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class SellerReplyView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "seller reply page";

    private final ReplyQuestionViewModel replyQuestionViewModel;

    final JTextField answerInputField = new JTextField(15);

    private final JLabel replySucceedField = new JLabel();// how to pop up the prompt words?


    private final ReplyQuestionController replyQuestionController;

    public SellerReplyView (ReplyQuestionViewModel replyQuestionViewModel,ReplyQuestionController replyQuestionController){

        this.replyQuestionViewModel = replyQuestionViewModel;
        this.replyQuestionController = replyQuestionController;

        JLabel page_title = new JLabel(replyQuestionViewModel.TITLE_LABEL);
        JLabel question_title = new JLabel(replyQuestionViewModel.QUESTION_LABEL);
        JLabel question_to_be_answered = new JLabel(replyQuestionViewModel.getState().getQuestion().getDescription());

        JLabel answerPlace = new JLabel(replyQuestionViewModel.ANSWER_LABEL);
        JButton publishAnswer = new JButton(replyQuestionViewModel.REPLY_BUTTON_LABEL);

        class AnswerInputKeyListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent event){
                ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
                String answer_content = answerInputField.getText() + event.getKeyChar();

                CommonQuestionFactory questionFactory = new CommonQuestionFactory();
                Question newquestion = questionFactory.createQuestion(question_content,
                        replyQuestionViewModel.getState().getQuestion();
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

        class AnswerPublishButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(publishAnswer)){
                    try{
                        Question question_to_be_replied = replyQuestionViewModel.getState().getSpecificQuestion();
                        //need to renew the state file to create the specific question

                        String question_content = answerInputField.getText();
                        CommonQuestionFactory questionFactory = new CommonQuestionFactory();
                        Question new_question = questionFactory.createQuestion(question_content,
                                buyerViewProductViewModel.getState().getProduct().getSellerStudentNumber(), null);

                        replyQuestionController.execute();
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        JButton cancel = new JButton(replyQuestionViewModel.CANCEL_BUTTON_LABEL);




        this.add(answerInputField);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
