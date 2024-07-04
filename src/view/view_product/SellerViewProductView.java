package view.view_product;

import entity.comment.CommonQuestionFactory;
import entity.comment.Question;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class SellerViewProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "seller_view_product view";// useless??

    private final SellerViewProductViewModel sellerViewProductViewModel;

    private final JButton cancel;

    private final ReplyQuestionController replyQuestionController;
    private final MainPageController mainPageController;



    public SellerViewProductView(SellerViewProductViewModel sellerViewProductViewModel,
                                ReplyQuestionController replyQuestionController,
                                MainPageController mainPageController){
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.replyQuestionController = replyQuestionController;
        this.mainPageController = mainPageController;

        this.sellerViewProductViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel(sellerViewProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //(1)product_info
        Product wtv_product = sellerViewProductViewModel.getState().getProduct();
        final JLabel image = new JLabel(String.valueOf(wtv_product.getImage()));//image???
        final JLabel description = new JLabel(wtv_product.getDescription());
        final JLabel price = new JLabel(String.valueOf(wtv_product.getPrice()));
        final JLabel _title = new JLabel(wtv_product.getTitle());
        final JLabel rating = new JLabel(String.valueOf(wtv_product.getRating()));
        final JLabel state = new JLabel(String.valueOf(wtv_product.getState()));
        final JLabel address = new JLabel(wtv_product.getAddress());
        final JLabel lstTags = new JLabel(String.valueOf(wtv_product.getListTags()));//what will valueOf list look like???
        final JLabel productID = new JLabel(wtv_product.getProductID());

        ProductInfoLabelTextPanel productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
                lstTags, productID);


        //(2)show q_and_a
        final JPanel qAInfo = new JPanel();

        final JLabel qA_title = new JLabel("Q&A:");

        ArrayList<Question> lst_question = sellerViewProductViewModel.getState().getQuestion();
        final JPanel qA_TextPanel = new JPanel();
        for (Question question : lst_question) {

            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);
            JButton replyButton = new JButton("Reply");

            SellerQAInfoLabelTextPanel panel = new SellerQAInfoLabelTextPanel(q, a, replyButton);
            qA_TextPanel.add(panel);

            class ReplyButtonListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == replyButton) {
                        try{
                            SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
                            Product product = sellerViewProductState.getProduct();
                            replyQuestionController.execute(product, sellerViewProductState.getUser(), question, answer_content);
                        }catch (Exception ex){
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }

            replyButton.addActionListener(new ReplyButtonListener());
        }

        qAInfo.add(qA_title);
        qAInfo.add(qA_TextPanel);


        //(3)some_discrete_buttons
        cancel = new JButton(sellerViewProductViewModel.CANCEL_BUTTON_LABEL);


        class CancelButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(cancel)){
                    try{
                        SellerViewProductState state = sellerViewProductViewModel.getState();
                        User user = state.getUser();
                        mainPageController.execute(user);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }


        cancel.addActionListener(new CancelButtonListener());

        // needs adjustments x,y axis?????
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(productInfo);
        this.add(qAInfo);
        this.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        SellerViewProductState state = (SellerViewProductState) evt.getNewValue();
        if (!Objects.equals(state.getPromptStr(), "")){
            JOptionPane.showMessageDialog(this, state.getPromptStr());
        }
    }
}
