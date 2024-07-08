package view.view_product;

import entity.comment.*;
import entity.product.Product;
import entity.user.User;
import interface_adapter.main_page.MainPageController;
import interface_adapter.view_product.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SellerReplyView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "seller reply page";

    private final ReplyQuestionViewModel replyQuestionViewModel;

    final JTextField answerInputField = new JTextField(15);


    private final ReplyQuestionController replyQuestionController;
    private final MainPageController mainPageController;

    public SellerReplyView (ReplyQuestionViewModel replyQuestionViewModel,
                            ReplyQuestionController replyQuestionController,
                            MainPageController mainPageController){

        this.replyQuestionViewModel = replyQuestionViewModel;
        this.replyQuestionController = replyQuestionController;
        this.mainPageController = mainPageController;

        JLabel page_title = new JLabel(replyQuestionViewModel.TITLE_LABEL);
        page_title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel question_title = new JLabel(replyQuestionViewModel.QUESTION_LABEL);
        JLabel question_to_be_answered = new JLabel(replyQuestionViewModel.getState().getQuestion().getDescription());

        JLabel answerPlaceLabel = new JLabel(replyQuestionViewModel.ANSWER_LABEL);
        JButton publishAnswer = new JButton(replyQuestionViewModel.REPLY_BUTTON_LABEL);

        class AnswerInputKeyListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent event){
                ReplyQuestionState replyQuestionState = replyQuestionViewModel.getState();
                String answer_content = answerInputField.getText() + event.getKeyChar();

                AnswerFactory answerFactory = new CommonAnswerFactory();
                Answer answer = answerFactory.createAnswer(
                        answer_content, replyQuestionState.getQuestion().getStudentNumber());

                CommonQuestionFactory questionFactory = new CommonQuestionFactory();
                Question newQuestion = questionFactory.createQuestion(replyQuestionState.getQuestion().getDescription(),
                        replyQuestionState.getQuestion().getStudentNumber(),
                        answer);

                replyQuestionViewModel.getState().setQuestion(newQuestion);

//                ReplyQuestionState currentState = replyQuestionViewModel.getState();
//                currentState.setQuestion(newQuestion);
//                replyQuestionViewModel.setState(currentState);

            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        }

        //answer button
        class AnswerPublishButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(publishAnswer)){
                    try{
                        Product product = replyQuestionViewModel.getState().getProduct();
                        User user = replyQuestionViewModel.getState().getUser();
                        Question question_to_be_replied = replyQuestionViewModel.getState().getQuestion();

                        String answer_content = answerInputField.getText();

                        replyQuestionController.execute(product, user, question_to_be_replied, answer_content);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        // cancel button
        JButton cancel = new JButton(replyQuestionViewModel.CANCEL_BUTTON_LABEL);

        class CancelButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(cancel)){
                    try{
                        ReplyQuestionState state = replyQuestionViewModel.getState();
                        User user = state.getUser();
                        mainPageController.execute(user);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        cancel.addActionListener(new CancelButtonListener());

        this.add(page_title);
        this.add(question_title);
        this.add(question_to_be_answered);
        this.add(answerPlaceLabel);
        this.add(answerInputField);
        this.add(publishAnswer);
        this.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
