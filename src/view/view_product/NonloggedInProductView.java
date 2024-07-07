package view.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.view_product.UnloggedInViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class NonloggedInProductView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "non login view product view";
    private final UnloggedInViewModel nonLoggedInViewModel;


    private final JButton cancel;
    private final JButton addToCart;


    private final ViewLoginPageController viewLoginPageController;
    private final MainPageController mainPageController;


    public NonloggedInProductView(UnloggedInViewModel nonLoggedInViewModel,
                                  ViewLoginPageController viewLoginPageController,
                                  MainPageController mainPageController) {
        this.nonLoggedInViewModel = nonLoggedInViewModel;
        this.viewLoginPageController = viewLoginPageController;
        this.mainPageController = mainPageController;

        this.nonLoggedInViewModel.addPropertyChangeListener(this);



        JLabel title = new JLabel(nonLoggedInViewModel.TITLE_LABEL+", but you are not logged in yet :(");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //(1)product_info
        Product wtv_product = nonLoggedInViewModel.getState().getProduct();
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

        ArrayList<Question> lst_question = nonLoggedInViewModel.getState().getQuestion();
        final JPanel qA_TextPanel = new JPanel();
        for (Question question : lst_question) {

            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);

            BuyerQAInfoLabelTextPanel panel = new BuyerQAInfoLabelTextPanel(q, a);
            qA_TextPanel.add(panel);
        }

        qAInfo.add(qA_title);
        qAInfo.add(qA_TextPanel);


        //(3)buttons
        JPanel buttons = new JPanel();
        cancel = new JButton(nonLoggedInViewModel.CANCEL_BUTTON_LABEL);
        addToCart = new JButton(nonLoggedInViewModel.ADD_TO_CART);


        buttons.add(cancel);
        buttons.add(addToCart);


        class AddTtoCartButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(addToCart)) {
                    try {
                        viewLoginPageController.execute();
                    } catch (Exception e) {
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
                        UserFactory userFactory = new CommonUserFactory();
                        User emptyuser = userFactory.createUser("","","",0, "");
                        mainPageController.execute(emptyuser);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        addToCart.addActionListener(new AddTtoCartButtonListener());
        cancel.addActionListener(new CancelButtonListener());

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(productInfo);
        this.add(qAInfo);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){

    }
}