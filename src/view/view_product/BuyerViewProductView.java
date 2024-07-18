package view.view_product;

import entity.comment.CommonQuestionFactory;
import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.AddToCartController;
import interface_adapter.view_product.BuyerViewProductState;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.PublishQuestionController;
import view.TopBarSampleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The BuyerViewProductView class for the product view pages.
 * Two controller:
 *      AddToCartController is used to transfer the user from the product view page to the shopping cart page.
 *      PublishQuestionController is used to let the user publish their questions.
 *      MainPageController is used to transfer the seller to the main page when they click cancel button.
 *
 */

public class BuyerViewProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "buyer_view_product view";

    private final BuyerViewProductViewModel buyerViewProductViewModel;

    final JTextField questionInputField = new JTextField(15);

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;


    private final JButton cancel;
    private final JButton addToCart;
    private final JButton publishQuestion;

    ProductInfoLabelTextPanel productInfo;
    JPanel qAInfo;

    /**
     * Constructs a BuyerViewProductView with specific controllers and view model.
     *
     * @param buyerViewProductViewModel the view model containing state and operations for product viewing.
     * @param addToCartController the controller for adding a product to the shopping cart.
     * @param publishQuestionController the controller for publishing questions about the product.
     * @param mainPageController the controller for navigating back to the main page.
     * @param getSearchPageController the controller for accessing the search page.
     * @param viewSignupPageController the controller for the signup page view.
     * @param viewLoginPageController the controller for the login page view.
     * @param shoppingCartController the controller for managing the shopping cart.
     * @param logOutController the controller for handling logout process.
     * @param viewProfileController the controller for viewing user profile.
     */
    public BuyerViewProductView(BuyerViewProductViewModel buyerViewProductViewModel,
                                AddToCartController addToCartController, PublishQuestionController publishQuestionController,

                                MainPageController mainPageController,
                                GetSearchPageController getSearchPageController,
                                ViewSignupPageController viewSignupPageController,
                                ViewLoginPageController viewLoginPageController,
                                ShoppingCartController shoppingCartController,
                                LogOutController logOutController,
                                ViewProfileController viewProfileController){
        this.buyerViewProductViewModel = buyerViewProductViewModel;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        JPanel topBar = new TopBarSampleView(this.buyerViewProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);
        //TODO implement the shared top bar

        this.buyerViewProductViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel(buyerViewProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



        //(1)product_info
        Product wtv_product = buyerViewProductViewModel.getState().getProduct();
        final JLabel image = new JLabel(String.valueOf(wtv_product.getImage()));//image???
        final JLabel description = new JLabel(wtv_product.getDescription());
        final JLabel price = new JLabel(String.valueOf(wtv_product.getPrice()));
        final JLabel _title = new JLabel(wtv_product.getTitle());
        final JLabel rating = new JLabel(String.valueOf(wtv_product.getRating()));
        final JLabel state = new JLabel(String.valueOf(wtv_product.getState()));
        final JLabel address = new JLabel(wtv_product.getAddress());
        final JLabel lstTags = new JLabel(String.valueOf(wtv_product.getListTags())); //what will valueOf list look like???
        final JLabel productID = new JLabel(wtv_product.getProductID());

        productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
                lstTags, productID);


        //(2)show q_and_a
        qAInfo = new JPanel();

        final JLabel qA_title = new JLabel("Q&A:");

        ArrayList<Question> lst_question = buyerViewProductViewModel.getState().getQuestion();
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


        //(3)add_question
        JPanel addQuestionInfo = new JPanel();

        JLabel input_question_title = new JLabel(buyerViewProductViewModel.INPUT_QUESTION_TITLE);
        addQuestionInfo.add(input_question_title);

        addQuestionInfo.add(questionInputField);

        publishQuestion = new JButton(buyerViewProductViewModel.ADD_QUESTION);
        addQuestionInfo.add(publishQuestion);


        //(4)some_discrete_buttons
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
            @Override
            public void keyTyped(KeyEvent event){
                BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
                String question_content = questionInputField.getText() + event.getKeyChar();

                CommonQuestionFactory questionFactory = new CommonQuestionFactory();
                Question newquestion = questionFactory.createQuestion(question_content,
                        buyerViewProductViewModel.getState().getProduct().getSellerStudentNumber(), null, Objects.toString(LocalDateTime.now()));
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
                                buyerViewProductViewModel.getState().getProduct().getSellerStudentNumber(), null, Objects.toString(LocalDateTime.now()));

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
                        BuyerViewProductState state = buyerViewProductViewModel.getState();
                        User user = state.getUser();
                        mainPageController.execute(user);
                    }catch (Exception e){
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
        this.add(qAInfo);
        this.add(addQuestionInfo);
        this.add(buttons);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Pop out the prompt window when detect state changes in ReplyQuestionPresenter to tell the user that their action
     * is successfully performed.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        BuyerViewProductState newState = (BuyerViewProductState) evt.getNewValue();

        if (!Objects.equals(newState.getPrompt_words(), "")){
            JOptionPane.showMessageDialog(this, newState.getPrompt_words());
        }else if(newState.getIsChanged()){
            Product wtv_product = newState.getProduct();
            final JLabel image = new JLabel(String.valueOf(wtv_product.getImage()));//image???
            final JLabel description = new JLabel(wtv_product.getDescription());
            final JLabel price = new JLabel(String.valueOf(wtv_product.getPrice()));
            final JLabel _title = new JLabel(wtv_product.getTitle());
            final JLabel rating = new JLabel(String.valueOf(wtv_product.getRating()));
            final JLabel state = new JLabel(String.valueOf(wtv_product.getState()));
            final JLabel address = new JLabel(wtv_product.getAddress());
            final JLabel lstTags = new JLabel(String.valueOf(wtv_product.getListTags())); //what will valueOf list look like???
            final JLabel productID = new JLabel(wtv_product.getProductID());

            productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
                    lstTags, productID);

            qAInfo = new JPanel();

            final JLabel qA_title = new JLabel("Q&A:");

            ArrayList<Question> lst_question = newState.getQuestion();
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

            JPanel topBar = new TopBarSampleView(newState.getUser(),
                    getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
            this.add(topBar);// TODO need to add this to all view

            newState.setIsChanged(false);
        }
    }
}
